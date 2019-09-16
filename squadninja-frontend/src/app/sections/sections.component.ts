import { Component, OnInit } from '@angular/core';
import { SectionComponentService } from 'src/app/services/cardHomePage/section-component.service';
import {SectionComponentSP} from 'src/app/services/cardSPHomePage/section-component-service-service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-sections',
  templateUrl: './sections.component.html',
  styleUrls: ['./sections.component.scss']
})
export class SectionsComponent implements OnInit 
{
  focus;
  focus1;
  private router:Router;
  // cards = [
  //   {
  //     title: 'Card Title 1',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  //   {
  //     title: 'Card Title 2',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  //   {
  //     title: 'Card Title 3',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  //   {
  //     title: 'Card Title 4',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  //   {
  //     title: 'Card Title 5',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  //   {
  //     title: 'Card Title 6',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  //   {
  //     title: 'Card Title 7',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  //   {
  //     title: 'Card Title 8',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  //   {
  //     title: 'Card Title 9',
  //     description: 'Some quick example text to build on the card title and make up the bulk of the card content',
  //     buttonText: 'Button',
  //     img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
  //   },
  // ];
  // slides: any = [[]];


  sections: any = [];
  private ideaCardsData: any;
  private spCardData: any;

  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }
  constructor(private sectionComponentService : SectionComponentService, private sectionComponentSP: SectionComponentSP){}
  ngOnInit() {
    this.sectionComponentService.getIdeas()
      .subscribe(data => {
        this.ideaCardsData = data
        console.log(this.ideaCardsData);
      });

      this.sectionComponentSP.getSP()
      .subscribe(data => {
        this.spCardData = data
        console.log(this.spCardData);
      });
    this.sections = this.chunk(this.sections, 3);
  }
  openCard()
  {
    this.router.navigate(['/login']);
  }

}
