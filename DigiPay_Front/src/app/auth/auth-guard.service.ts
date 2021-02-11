import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
import { LoginService } from '../login/login.service';

@Injectable({ providedIn: 'root' })
export class AuthGuardService implements CanActivate {

  constructor(private loginService: LoginService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  : boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    return this.loginService.user.pipe(
      take(1),
      map(user => {
        console.log('user',user);
        const isAuth = !!user;
        console.log('user isAuth:',isAuth);

        if (isAuth) {
          return true;
        }
        return this.router.createUrlTree(['/login']);
      })
    );
  }
}
