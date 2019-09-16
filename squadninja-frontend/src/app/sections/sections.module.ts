import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import { SectionsComponent } from './sections.component';
import {RouterModule} from '@angular/router';
import { MDBBootstrapModule} from 'angular-bootstrap-md';

@NgModule({
  declarations: [SectionsComponent],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule,
    RouterModule,
    MDBBootstrapModule
  ],
  exports: [SectionsComponent]
})
export class SectionsModule { }
