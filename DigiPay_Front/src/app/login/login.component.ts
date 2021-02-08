import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      'username': new FormControl(null, [Validators.required, Validators.pattern('^[0-9]{10}$')]),
      'password': new FormControl(null, [Validators.required])
    });
  }

  onLogin() {
    if(this.loginForm.invalid) {
      return;
    }
    this.loginService.login(this.loginForm.value).subscribe(token => {
      console.log('Token:',token);
    });
    console.log(this.loginForm.value);
  }
}
