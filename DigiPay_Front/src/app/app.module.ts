import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { ErrorComponent } from './error/error.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptorService } from './utils/interceptor.service';
import { LoginComponent } from './login/login.component';
import { PrivacyPolicyComponent } from './policy-docs/privacy-policy/privacy-policy.component';
import { TermsConditionComponent } from './policy-docs/terms-condition/terms-condition.component';
import { HomeComponent } from './home/home.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddMoneyComponent } from './add-money/add-money.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TransactionComponent } from './transaction/transaction.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    ErrorComponent,
    LoginComponent,
    PrivacyPolicyComponent,
    TermsConditionComponent,
    HomeComponent,
    AddBooksComponent,
    AddMoneyComponent,
    HeaderComponent,
    FooterComponent,
    TransactionComponent,
    TransactionHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
