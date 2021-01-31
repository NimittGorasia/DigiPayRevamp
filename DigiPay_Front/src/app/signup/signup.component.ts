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
      'userName': new FormControl(null, [Validators.required]),
      'contact': new FormControl(null, [Validators.required]),
      'email': new FormControl(null,[Validators.email]),
      'password': new FormControl(null, [Validators.required,Validators.maxLength(8)]),
      'confirm_password': new FormControl(null, [Validators.required])
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
    this.signUpService.signUp(this.signUpForm.value).subscribe(res => {
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
