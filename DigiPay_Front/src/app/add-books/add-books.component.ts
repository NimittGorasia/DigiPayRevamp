import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AddBooksService } from './add-books.service';

@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.css']
})
export class AddBooksComponent implements OnInit {

  addBookForm: FormGroup;
  constructor(private addBooksService: AddBooksService) { }

  ngOnInit(): void {
    this.addBookForm = new FormGroup({
      'title': new FormControl(null,Validators.required),
      'image': new FormControl(null,Validators.required),
      'description': new FormControl(null,Validators.required),
      'price': new FormControl(null,Validators.required),
      'author': new FormControl(null,Validators.required),
      'genre': new FormControl(null,Validators.required)
    });
  }

  onAddBook(){
    this.addBooksService.addBooks(this.addBookForm.value).subscribe(token =>{
      console.log("Success Message: ",token);
    });
    console.log(this.addBookForm.value);
  }
}
