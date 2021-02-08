import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = '';
  constructor(private http: HttpClient) { }

  login(data: JSON) {
    this.url='http://localhost:8082/api/login/authenticate';
    console.log('In service:', data);
    return this.http.post(this.url, data);
  }

}
