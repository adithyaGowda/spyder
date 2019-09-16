import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FussionChartComponent } from './fussion-chart.component';



describe('FussionChartComponent', () => {
  let component: FussionChartComponent;
  let fixture: ComponentFixture<FussionChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FussionChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FussionChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

