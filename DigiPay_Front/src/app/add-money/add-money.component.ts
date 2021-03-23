import { Component, OnChanges, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { AddMoneyService } from './add-money.service';

@Component({
  selector: 'app-add-money',
  templateUrl: './add-money.component.html',
  styleUrls: ['./add-money.component.css']
})
export class AddMoneyComponent implements OnInit, OnChanges {

  constructor(private addMoneyService: AddMoneyService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  ngOnChanges() {
    this.route.params.subscribe(resp => {
      console.log('params',resp);
    })
  }

  doTrxn() {
    this.addMoneyService.doTrxn().subscribe(resp => {
      console.log('trxn:',resp['redirect_url']);
      window.location.href = resp['redirect_url'];
    });

    // console.log(this.router.urlHandlingStrategy.extract);
  }
}
