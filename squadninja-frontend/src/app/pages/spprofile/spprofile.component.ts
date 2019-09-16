import { SpProfile } from './../../services/spprofileser/spprofile.model';
import { Component, OnInit } from '@angular/core';
import { SpprofileserService } from 'src/app/services/spprofileser/spprofileser.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-spprofile',
  templateUrl: './spprofile.component.html',
  styleUrls: ['./spprofile.component.scss']
})
export class SpprofileComponent implements OnInit {

  // serviceProviderData: any;
  
  serviceProviderData={
    name:"",mobileNo:"",domain:"",subDomain:"",currentLocation:"",preferredLocation:"",roleName:"",skills:"",experience:"",chargePerHour:""
 };

 updated: any;
 public emailId='';
  // private dialog: MatDialog
  constructor(private serviceProviderProfile: SpprofileserService, private route: ActivatedRoute) { }
  user : SpProfile = new SpProfile();
  ngOnInit() {
    this.emailId =localStorage.getItem("emailId");
    this.getTheProfile();
    
    
  }
  getTheProfile(){
    this.serviceProviderProfile.getByEmailIdForServiceProvider(this.emailId)
    .subscribe((data)=> {
      console.log("data fetched..", data);
      this.serviceProviderData=data;
      console.log("after getting back from service",this.serviceProviderData);
    });
  }
    onSubmitUpdate(){
      let this1=this;
      console.log("this.serviceProviderData", this.serviceProviderData);
      // console.log("this.user******", this.serviceProviderData);
      this.serviceProviderProfile.updateTheProfile(this1.serviceProviderData,this.emailId).subscribe((data)=> {
        console.log("data updated..", data);
        this1.updated=data;
        this1.getTheProfile();
        console.log("after getting back from service",this1.updated);
    }, err => {
      console.log(err);
    });

    // onSubmitUpdate(){
    //   let this1=this;
    //   console.log("this.serviceProviderData",this.serviceProviderProfile.updateTheProfile(this1.serviceProviderData).subscribe);
    //   // console.log("this.user******", this.serviceProviderData);
    //   this.serviceProviderProfile.updateTheProfile(this1.serviceProviderData).subscribe(data => console.log("*****", data));
      
    }
  
}
