import { TestBed } from '@angular/core/testing';

import { RestauarntService } from './restauarnt.service';

describe('RestauarntService', () => {
  let service: RestauarntService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestauarntService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
