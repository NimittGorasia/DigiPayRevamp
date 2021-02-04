import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SignupService } from './signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;
  constructor(private signUpService: SignupService) {
   }

  ngOnInit() {
    this.signUpForm = new FormGroup({
      'firstName': new FormControl(null, [Validators.required, Validators.minLength(2),Validators.pattern('^[a-zA-Z]+$')]),
      'lastName': new FormControl(null, [Validators.required, Validators.minLength(2),Validators.pattern('^[a-zA-Z]+$')]),
      'contact': new FormControl(null, [Validators.required, Validators.pattern('^[0-9]{10}$')]),
      'email': new FormControl(null,[Validators.required,Validators.email]),
      'password': new FormControl(null, [Validators.required,Validators.minLength(8)]),
      'confirm_password': new FormControl(null, [Validators.required])
      // 'recaptcha': new FormControl(['', Validators.required])
    });
  }

  onSignUp() {
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
