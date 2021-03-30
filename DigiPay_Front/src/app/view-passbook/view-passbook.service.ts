import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ViewPassbookService {

  constructor(private http: HttpClient) { }

  viewPassbook() {
    return this.http.post('http://localhost:8082/payments/view/passbook', "");
  }
}
