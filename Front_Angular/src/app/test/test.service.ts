import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  private apiUrl = '/api/signUp/demoDetails';
  constructor(private http: HttpClient) {}

  sendData(data: JSON) {
    console.log(data);
    let empHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.apiUrl, data, { headers: empHeaders});
  }



  loginData(data: JSON) {
    let empHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<string>('/login', data, { headers: empHeaders });
  }
  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
