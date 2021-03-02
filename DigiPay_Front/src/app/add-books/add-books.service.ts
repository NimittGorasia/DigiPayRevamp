import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})

export class AddBooksService{
    private url = '';
    constructor(private http: HttpClient) { }

  addBooks(data: JSON) {
    this.url='http://localhost:8082/books/addBooks';
    console.log('In service:', data);
    return this.http.post(this.url, data);
  }

}