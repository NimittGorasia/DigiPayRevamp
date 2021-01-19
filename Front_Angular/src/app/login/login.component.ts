import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TestService } from '../test/test.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild('f') form: NgForm;
  constructor(private testService: TestService, private router: Router) { }

  ngOnInit(): void {
  }
  onLogin() {
    this.testService.loginData(this.form.value);
    this.router.navigate(['/test']);
  }

}
