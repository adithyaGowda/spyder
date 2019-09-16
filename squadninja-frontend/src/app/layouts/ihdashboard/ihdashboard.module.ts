import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpClientModule} from '@angular/common/http';

import { IhDashboardRoutes } from './ihdashboard-routing.module';
import { RouterModule } from '@angular/router';
import { FormsModule , ReactiveFormsModule} from '@angular/forms';
import { ClipboardModule } from 'ngx-clipboard';


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { IhdashboardcardsComponent } from 'src/app/pages/ihdashboardcards/ihdashboardcards.component';
import { IhprofileComponent } from 'src/app/pages/ihprofile/ihprofile.component';
import { MatTabsModule, MatCard, MatCardModule, MatCardActions, MatHint, MatOption, MatSelect, MatInputModule, MatChipsModule, MatIconModule, MatAutocompleteModule, MatCardAvatar, MatCardTitle, MatCardHeader } from '@angular/material';
import { PostideaComponent } from 'src/app/pages/postidea/postidea.component';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatSelectModule} from '@angular/material/select';
import { IhprofileserService } from 'src/app/services/ihprofileser/ihprofileser.service';
import { IdeaviewComponent } from 'src/app/pages/ideaview/ideaview.component';
import { AutoGenerateTeamComponent } from 'src/app/pages/auto-generate-team/auto-generate-team.component';



@NgModule({
  declarations: [
    IhdashboardcardsComponent,
    IhprofileComponent,
    PostideaComponent,
    IdeaviewComponent,
    AutoGenerateTeamComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(IhDashboardRoutes),
    FormsModule,
    NgbModule,
    HttpClientModule,
    ClipboardModule,
    MatTabsModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatChipsModule,
    MatIconModule,
    MatInputModule,
    MatAutocompleteModule ,
    ReactiveFormsModule,
    MatTabsModule,
    MatCardModule
  ],
  providers:[
    IhprofileserService
  ]
})
export class IhdashboardModule { }

