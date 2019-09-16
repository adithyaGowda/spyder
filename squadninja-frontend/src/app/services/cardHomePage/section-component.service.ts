import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SectionComponentData } from 'src/app/services/cardHomePage/section-component-model';
import { Observable } from 'rxjs/internal/Observable';
import { SpProfile } from '../spprofileser/spprofile.model';
import { IdeaDetail } from '../spprofileser/IdeaDetail.model';

@Injectable({
  providedIn: 'root'
})
export class SectionComponentService {
  


  private _url : string= 'http://13.235.10.115:8090/api/v1/ideas';

  constructor(private http:HttpClient) {
    this.http=http;
   }

  getIdeas(): Observable<SpProfile[]> {
    return this.http.get<SpProfile[]>(this._url);
}

myIdeas(emailId):Observable<IdeaDetail[]>{
  return this.http.get<IdeaDetail[]>(`http://13.235.10.115:8090/api/v1/idea/${emailId}`);
}

addTeamManagement(modalCardDetails: { title: string; description: string; role: string; domain: string; subdomain: string; }) {
  return this.http.post('http://localhost:8083/api/v1/appliedTeam', modalCardDetails);
}
}
