import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  private url = '';
  constructor(private http: HttpClient) { }

  signUp(data: JSON) {
    this.url='http://localhost:8080/api/signUp/demoDetails';
    console.log('In service:', data);
    return this.http.post(this.url, data);
  }

}