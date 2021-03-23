import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  user;
  ngOnInit(): void {
    this.loginService.user.subscribe(resp => {
      this.user = resp;
    });
  }

  logout() {
    this.loginService.logout();
  }
}
