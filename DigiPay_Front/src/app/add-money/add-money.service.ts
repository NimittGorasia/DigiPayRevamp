import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AddMoneyService {

  constructor(private http: HttpClient) { }

  doTrxn(sum) {
    return this.http.post('http://localhost:8082/payments/make/payment', sum);
  }

}
