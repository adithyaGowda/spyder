import { Component, OnInit } from '@angular/core';
import { Register } from './register.model';
import { FormGroup } from '@angular/forms';
import {IhprofileserService} from '../services/ihprofileser/ihprofileser.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm:FormGroup;
  submitted=false;
  user:Register=new Register();
  router: any;
  constructor(private ihservice:IhprofileserService) { }

  ngOnInit() {
  }

  getf(){return this.registerForm.controls;}
  saveDetails(){
    this.user.role='ideaHamster';
    this.ihservice.createUser(this.user)
    .subscribe(data=>{
      console.log(data);
      this.submitted=true;
    },
    error=>console.log(error));
    // this.router.navigate(['/login']);
  }

}
