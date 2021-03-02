import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBooksComponent } from './add-books/add-books.component';
import { AuthGuardService } from './auth/auth-guard.service';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PrivacyPolicyComponent } from './policy-docs/privacy-policy/privacy-policy.component';
import { TermsConditionComponent } from './policy-docs/terms-condition/terms-condition.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', canActivate: [AuthGuardService], component: HomeComponent},
  {path: 'privacy-notice', component: PrivacyPolicyComponent},
  {path: 'terms-conditions', component: TermsConditionComponent},
  {path: 'add-books', component: AddBooksComponent},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
