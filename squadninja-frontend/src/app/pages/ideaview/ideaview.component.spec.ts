import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeaviewComponent } from './ideaview.component';

describe('IdeaviewComponent', () => {
  let component: IdeaviewComponent;
  let fixture: ComponentFixture<IdeaviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeaviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeaviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
