import { TestBed } from '@angular/core/testing';

import { SectionComponentService } from './section-component.service';

describe('SectionComponentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SectionComponentService = TestBed.get(SectionComponentService);
    expect(service).toBeTruthy();
  });
});
