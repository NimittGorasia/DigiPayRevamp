import { TestBed } from '@angular/core/testing';

import { ViewPassbookService } from './view-passbook.service';

describe('ViewPassbookService', () => {
  let service: ViewPassbookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewPassbookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
