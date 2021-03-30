import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPassbookComponent } from './view-passbook.component';

describe('ViewPassbookComponent', () => {
  let component: ViewPassbookComponent;
  let fixture: ComponentFixture<ViewPassbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPassbookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPassbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
