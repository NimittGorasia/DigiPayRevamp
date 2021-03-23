import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  completePayment(data) {
    const url='http://localhost:8082/payments/complete/payment';
    console.log('In service:', data);
    return this.http.post(url, data);
  }
}
