import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { take } from 'rxjs/internal/operators/take';
import { exhaustMap } from 'rxjs/operators';
import { LoginService } from '../login/login.service';

@Injectable()
export class AuthInterceptorService implements HttpInterceptor {

  constructor(private loginService: LoginService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log('Request intercepted and it is on way!');
    return this.loginService.user.pipe(
      take(1),
      exhaustMap(user => {
        console.log('user:',user);
        if (!user){
          return next.handle(req);
        }
        const modifiedRequest = req.clone({
          headers: new HttpHeaders().set('Authorization','Bearer '+user.token)
        });
        return next.handle(modifiedRequest);
      })
    );
    
  }

}
