import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TransactionService } from './transaction.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private trxnService: TransactionService) { }

  ngOnInit(): void {
    this.completePayment();
  }

  completePayment() {
    let token;
    let paymentId='';
    let payerId='';
    const resp = this.router.url.split('?')[1].split('&');
    if(this.router.url.indexOf('cancel')!==-1)
    {
      token = resp[0].split('=')[1];
    } else {
      paymentId = resp[0].split('=')[1];
      token = resp[1].split('=')[1];
      payerId = resp[2].split('=')[1];
      console.log('payerid:',payerId)
    }
    console.log('resp',resp);
    this.trxnService.completePayment({token: token, paymentId: paymentId, payerId: payerId}).subscribe(result => {
      console.log('complete payment:',result);
    });
  }
}
