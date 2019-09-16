import { Component ,OnInit } from '@angular/core';

@Component({
  selector: 'app-fussion-chart',
  templateUrl: './fussion-chart.component.html',
  styleUrls: ['./fussion-chart.component.scss']
})
export class FussionChartComponent {
  dataSource: Object;
  
  

  constructor() {
    this.dataSource = {
      chart: {
        caption: " IdeaHamster [2018-19]",
        subCaption: "In Idea = One Million barrels",
        xAxisName: "MyIdea",
        yAxisName: "Work on Idea",
        numberSuffix: "k",
        theme: "fusion"
      },
      // Chart Data
      data: [
        {
          label: "InvitedTeam",
          value: "2"
        },
        {
          label: "AppliedTeam",
          value: "5"
        },
        {
          label: "SelectedTeam",
          value: "5"
        },
        {
          label: "PostedIdea",
          value: "6"
        },
       
      ]
    }; // end of this
   }

  ngOnInit() {
    
  }



}
