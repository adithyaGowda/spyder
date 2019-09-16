import { NgModule, NO_ERRORS_SCHEMA  } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { RouterModule } from '@angular/router';
import {HomeComponent} from './home.component';
import { SectionsModule } from '../sections/sections.module';
import { NavbarComponent } from './navbar/navbar.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './footer/footer.component';
import { MDBBootstrapModule} from 'angular-bootstrap-md';


@NgModule({
  declarations: [HomeComponent, NavbarComponent, FooterComponent],
  exports: [HomeComponent],
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    RouterModule,
    SectionsModule,
    NgbModule,
    MDBBootstrapModule
    
  ]
})
export class HomeModule { }
 