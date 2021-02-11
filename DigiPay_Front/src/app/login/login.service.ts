import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { User } from '../auth/user.model';

export interface AuthResponseData {
  token: string;
  expiresIn: string;
}


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = '';
  user = new BehaviorSubject<User>(null);
  private tokenExpirationTimer: any;
  constructor(private http: HttpClient, private router: Router) { }

  login(data: JSON) {
    this.url='http://localhost:8080/api/login/authenticate';
    console.log('In service:', data);
    return this.http.post<AuthResponseData>(this.url, data)
          .pipe(
            catchError(this.handleError),
            tap(resData => {
              this.handleAuthentication(
                resData.token,
                +resData.expiresIn
              );
            })
          );
  }

  private handleAuthentication(token: string, expiresIn: number) {
    const expirationDate = new Date(new Date().getTime() + expiresIn * 1000);
    console.log(expirationDate);
    const user = new User(token, expirationDate);
    console.log('user obj:',user)
    this.user.next(user);
    this.autoLogout(expiresIn * 1000);
    localStorage.setItem('userData', JSON.stringify(user));
  }

  private handleError(errorResponse: String) {
    return throwError(errorResponse);
  }

  autoLogin() {
    const userData: {
      _token: string;
      _tokenExpirationDate: string;
    } = JSON.parse(localStorage.getItem('userData'));

    if (!userData) {
      return;
    }

    const loadedUser = new User(
      userData._token,
      new Date(userData._tokenExpirationDate)
    );

    if (loadedUser.token) {
      this.user.next(loadedUser);
      const expirationDuration =
        new Date(userData._tokenExpirationDate).getTime() -
        new Date().getTime();
      this.autoLogout(expirationDuration);
    }
  }

  logout() {
    this.user.next(null);
    localStorage.removeItem('userData');
    this.router.navigate(['/login']);
    if (this.tokenExpirationTimer) {
      clearTimeout(this.tokenExpirationTimer);
    }
    this.tokenExpirationTimer = null;
  }

  autoLogout(expirationDuration: number) {
    console.log('duration:', expirationDuration)
    this.tokenExpirationTimer = setTimeout(() => {
      this.logout();
    }, expirationDuration);
  }
}
