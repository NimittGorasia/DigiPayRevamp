import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RecaptchaErrorParameters } from 'ng-recaptcha';
import { SignupService } from './signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;
  @ViewChild('captchaRef', {static: true}) captchaRef;
  constructor(private signUpService: SignupService, private http: HttpClient) {
   }

  ngOnInit() {
    this.signUpForm = new FormGroup({
      'firstName': new FormControl(null, [Validators.required, Validators.minLength(2),Validators.pattern('^[a-zA-Z]+$')]),
      'lastName': new FormControl(null, [Validators.required, Validators.minLength(2),Validators.pattern('^[a-zA-Z]+$')]),
      'contact': new FormControl(null, [Validators.required, Validators.pattern('^[0-9]{10}$')]),
      'email': new FormControl(null,[Validators.required,Validators.email]),
      'password': new FormControl(null, [Validators.required,Validators.minLength(8)]),
      'confirm_password': new FormControl(null, [Validators.required]),
      'recaptcha': new FormControl(['', Validators.required])
    });
  }

  onSignUp() {
    this.captchaRef.execute();
    // this.signUpForm.get('recaptcha').value.execute();
    if(this.signUpForm.invalid) {
      return;
    }
    if(this.signUpForm.get('password').value !== this.signUpForm.get('confirm_password').value) {
      console.log('Password does not match');
      return;
    }
    console.log(this.signUpForm.value);

    let obj = {};
    obj['firstName'] = this.signUpForm.get('firstName').value;
    obj['lastName'] = this.signUpForm.get('lastName').value;
    obj['contact'] = this.signUpForm.get('contact').value;
    obj['email'] = this.signUpForm.get('email').value;
    obj['password'] = this.signUpForm.get('password').value;

    this.signUpService.signUp(JSON.parse(JSON.stringify(obj))).subscribe(res => {
      console.log('success', res);
    }, err => {
      console.log('error occured');
    });
  }

  public captchaResponse = "";
  public resolved(captchaResponse: string): void {
    // const newResponse = captchaResponse
    //   ? `${captchaResponse.substr(0, 7)}...${captchaResponse.substr(-7)}`
    //   : captchaResponse;
    // this.captchaResponse += `${JSON.stringify(newResponse)}\n`;

    console.log(captchaResponse);
    this.http.get('https://www.google.com/recaptcha/api/siteverify?secret=6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe&response='+captchaResponse,
      {
        headers: {
          'Access-Control-Allow-Origin': '*'
        }
      }).subscribe(res => {
                        console.log(res);
                      });
  }

  public onError(errorDetails: RecaptchaErrorParameters): void {
    this.captchaResponse += `ERROR; error details (if any) have been logged to console\n`;
    console.log(`reCAPTCHA error encountered; details:`, errorDetails);
  }
}
export class PhoneNumber {
  country: string;
  area: string;
  prefix: string;
  line: string;

  // format phone numbers as E.164
  get e164() {
    const num = this.country + this.area + this.prefix + this.line
    return `+${num}`
  }

}
