import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoGenerateTeamComponent } from './auto-generate-team.component';

describe('AutoGenerateTeamComponent', () => {
  let component: AutoGenerateTeamComponent;
  let fixture: ComponentFixture<AutoGenerateTeamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoGenerateTeamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoGenerateTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
