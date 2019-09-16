import { Component, OnInit ,Input} from '@angular/core';
import { $ } from 'protractor';
import { FormControl } from '@angular/forms';
import {AutogenerateService} from '../../services/autogenServices/autogenerate.service';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-auto-generate-team',
  templateUrl: './auto-generate-team.component.html',
  styleUrls: ['./auto-generate-team.component.scss']
})
export class AutoGenerateTeamComponent implements OnInit {
  public items: any;
  public postedIdeaDetails: any;

  title="";
  obj1:any="";
  obj:any="";
 

  tabs=[];
  cards = [];
  x: any = [];
  // sel = new FormControl(0);
  // public serviceproviders = [];
​
// tslint:disable-next-line:max-line-length
  constructor(private http:HttpClient,private autogeneratesp:AutogenerateService) { }
  ngOnInit() {

    // this.autogeneratesp.get().subscribe(res =>{
    //   this.x=res;
    //   console.log(this.x);
    // })

   // this.getPostedIdeas().then(() => this.getTab(0));
    this.title=localStorage.getItem("title");
    console.log(this.title);
    this.obj=localStorage.getItem("Role");
    console.log(this.obj);
    this.obj1=JSON.parse(this.obj);
  
    for(let role of this.obj1){
        this.tabs.push(role.role);
        console.log("came0");
        if(role.role===this.x.role){
          console.log("came1");
        }
      }
  console.log("came2");
  this.getAnyTeam();
}

getAnyTeam(){
  
  
  this.autogeneratesp.getByIdeaTitleAndRoleName(this.title,this.obj1)
  .subscribe(data =>{
    console.log("data from posting an idea "+ this.title,this.obj1);
    this.autogeneratesp=data;
    console.log("after getting back from service",this.autogeneratesp);
  }
  ); 
}

​
 clickedAccept(item, role) {
    item.statusA = "Accepted";
    let designerpath: string = 'http://localhost:3000/' + role + '/' + item.id;
    console.log(designerpath);
    let value = 'Accepted';
    let statusR = 'Reject';
​
    this.http.patch(designerpath,{'statusA' : value, 'statusR' : statusR}).subscribe();

  }
​
  clickedReject(id) {
    let despath: string = 'http://localhost:3000/designers/' + id;
    let value = 'Accept';
    let statusR = 'Rejected';
    this.http.patch(despath, {'statusR': statusR,'statusA': value}).subscribe();
​
  }
​
​
​
​
​
  // async getPostedIdeas() {
  //   return new Promise((resolve, reject) =>
  //   this.autoGenerateTeam.posetedIdeas().subscribe((response) => {
  //       console.log(response);
  //       if (response) {
  //         this.postedIdeaDetails = response;
  //         }
  //       }, (err) => {
  //         console.log(err);
  //     }
  //     )
  //     );
  // }
}
