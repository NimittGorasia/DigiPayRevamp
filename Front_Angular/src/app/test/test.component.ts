import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TestService } from './test.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  @ViewChild('f') form: NgForm;
  constructor(private testService: TestService) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    this.testService.sendData(this.form.value).subscribe(res => {
      console.log('in cmp:',res);
    }, error => {
      console.log('Error occured',error);
    });
  }

}
