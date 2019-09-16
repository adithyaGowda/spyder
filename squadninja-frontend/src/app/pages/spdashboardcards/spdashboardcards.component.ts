import { Component, OnInit } from '@angular/core';
import { SectionComponentService } from 'src/app/services/cardHomePage/section-component.service';
import { SectionComponentSP } from 'src/app/services/cardSPHomePage/section-component-service-service';
import { HttpClient } from '@angular/common/http';
import { FormControl } from '@angular/forms';
import { SpprofileserService } from 'src/app/services/spprofileser/spprofileser.service';

@Component({
  selector: 'app-spdashboardcards',
  templateUrl: './spdashboardcards.component.html',
  styleUrls: ['./spdashboardcards.component.scss']
})
export class SpdashboardcardsComponent implements OnInit {
private_url:string="http://13.235.10.115:8083/api/v1/appliedTeam";

  sections: any = [];
  private ideaCardsData: any;
  public emailId :string= "";
  // private spCardData: any;

//  cards = ['Idea1', 'Idea2','Idea1', 'Idea2','Idea1'];
 sel = new FormControl(0);

  modalCardDetails = {
    title: '',
    description: '',
    role: '',
    domain: '',
    subdomain: ''
                
  }
  recommendCards: any = [];

  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }
  constructor(private sectionComponentService : SectionComponentService ,private spprofileserService : SpprofileserService){}
  ngOnInit() {

    this.emailId=localStorage.getItem("emailId");

    this.sectionComponentService.getIdeas()
      .subscribe(data => {
        this.ideaCardsData = data
        console.log(this.ideaCardsData);
      });

    this.spprofileserService.getRecommendationIdeas(this.emailId)
    .subscribe(data => {
        this.recommendCards = data
        console.log(this.recommendCards);
      });

      // this.sectionComponentSP.getSP()
      // .subscribe(data => {
      //   this.spCardData = data
      // });
    this.sections = this.chunk(this.sections, 3);
    
  }

  saveCardDetails(x: any) {
    console.log(x);
    this.modalCardDetails.title = x.title;
    this.modalCardDetails.description = x.description;
    this.modalCardDetails.role = x.role;
    this.modalCardDetails.domain = x.domain;
    this.modalCardDetails.subdomain = x.subDomain;
  
  }

  applyData() {
    this.sectionComponentService.addTeamManagement(this.modalCardDetails).subscribe(res => {

    }, err => {
      console.log(err)
    })
  }
}
