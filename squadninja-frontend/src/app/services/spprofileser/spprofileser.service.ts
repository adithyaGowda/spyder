import { RecommendCards } from './recommendIdeas.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SpProfile } from './spprofile.model';
import { Register } from 'src/app/register/register.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class  SpprofileserService {
  

  private _url: string = "http://13.235.10.115:8084/api/v1/serviceprovider";
  constructor(private http: HttpClient) { }
  getByEmailIdForServiceProvider(emailId):any{
    console.log("in getbyemail of reg service "+emailId);
    return this.http.get<SpProfile>(`http://13.235.10.115:8084/api/v1/serviceprovider/${emailId}`);
  }
  createUser(user: any):Observable<any> {
    console.log(user);
    return this.http.post<Register>(this._url, user);
  }
  updateTheProfile(profile: any,emailId):Observable<any> {
    console.log("*******in service", profile);
    let profileUpdated = {
      "email": emailId,
      "name": profile.name,
      "mobileNo": profile.mobileNo,
      "domain": profile.domain,
      "subDomain": profile.subDomain,
      "chargePerHour": profile.chargePerHour,
      "currentLocation": profile.currentLocation,
      "preferredLocation": [profile.prefferedLocation],
      "role":{
      "roleName" : profile.roleName,
      "experience": profile.experience,
      "skills": [profile.skills]
    	}
    }
    console.log(profileUpdated)
    return this.http.put<any>(`http://13.235.10.115:8084/api/v1/serviceprovider`,profileUpdated);
  }

  getRecommendationIdeas(emailId):Observable<RecommendCards>{
    console.log("in getbyemail of reg service "+emailId);
    return this.http.get<RecommendCards>(`http://13.235.10.115:8081/api/v1/skill/${emailId}`);
  }

}
