import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddMoneyComponent } from './add-money/add-money.component';
import { AuthGuardService } from './auth/auth-guard.service';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PrivacyPolicyComponent } from './policy-docs/privacy-policy/privacy-policy.component';
import { TermsConditionComponent } from './policy-docs/terms-condition/terms-condition.component';
import { SignupComponent } from './signup/signup.component';
import { TransactionComponent } from './transaction/transaction.component';
import { ViewPassbookComponent } from './view-passbook/view-passbook.component';
import { ViewPassbookService } from './view-passbook/view-passbook.service';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', canActivate: [AuthGuardService], component: HomeComponent},
  {path: 'privacy-notice', component: PrivacyPolicyComponent},
  {path: 'terms-conditions', component: TermsConditionComponent},
  {path: 'add-books', canActivate: [AuthGuardService], component: AddBooksComponent},
  {path: 'add-money',canActivate: [AuthGuardService], component: AddMoneyComponent},
  {path: 'success',canActivate: [AuthGuardService], component: TransactionComponent},
  {path: 'cancel',canActivate: [AuthGuardService], component: TransactionComponent},
  {path: 'view-passbook',canActivate: [AuthGuardService], component: ViewPassbookComponent},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
