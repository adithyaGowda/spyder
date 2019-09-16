import { TestBed } from '@angular/core/testing';

import { AutogenerateService } from './autogenerate.service';

describe('AutogenerateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AutogenerateService = TestBed.get(AutogenerateService);
    expect(service).toBeTruthy();
  });
});
