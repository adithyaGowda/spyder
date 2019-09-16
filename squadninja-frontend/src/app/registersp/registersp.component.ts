import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Register } from '../register/register.model';
import { SpprofileserService } from '../services/spprofileser/spprofileser.service';

@Component({
  selector: 'app-registersp',
  templateUrl: './registersp.component.html',
  styleUrls: ['./registersp.component.scss']
})
export class RegisterspComponent implements OnInit {

  registerForm:FormGroup;
  submitted=false;
  user:Register=new Register();

  
  constructor(private spservice:SpprofileserService) { }

  ngOnInit() {
  }

  getf(){return this.registerForm.controls;}
  saveDetails(){
    this.user.role='serviceprovider';
    this.spservice.createUser(this.user)
    .subscribe(data=>{
      console.log(data);
      this.submitted=true;
    },
    error=>console.log(error));
  }

}
