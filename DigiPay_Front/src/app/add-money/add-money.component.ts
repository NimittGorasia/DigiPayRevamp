import { Component, OnChanges, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { AddMoneyService } from './add-money.service';

@Component({
  selector: 'app-add-money',
  templateUrl: './add-money.component.html',
  styleUrls: ['./add-money.component.css']
})
export class AddMoneyComponent implements OnInit {

  addToWallet: FormGroup;
  constructor(private addMoneyService: AddMoneyService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.addToWallet = new FormGroup({
      'sum': new FormControl(null, [Validators.required, Validators.min(10)])
    });
  }


  doTrxn() {
    if(this.addToWallet.invalid) {
      return;
    }
    this.addMoneyService.doTrxn(this.addToWallet.value).subscribe(resp => {
      console.log('trxn:',resp['redirect_url']);
      window.location.href = resp['redirect_url'];
    });

    // console.log(this.router.urlHandlingStrategy.extract);
  }
}
