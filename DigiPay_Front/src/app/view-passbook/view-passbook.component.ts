import { Component, OnInit } from '@angular/core';
import { ViewPassbookService } from './view-passbook.service';

@Component({
  selector: 'app-view-passbook',
  templateUrl: './view-passbook.component.html',
  styleUrls: ['./view-passbook.component.css']
})
export class ViewPassbookComponent implements OnInit {

  constructor(private viewPassbookService: ViewPassbookService) { }

  ngOnInit(): void {
  }

  viewPassbook() {
    this.viewPassbookService.viewPassbook().subscribe(resp => {

    });
  }

}
