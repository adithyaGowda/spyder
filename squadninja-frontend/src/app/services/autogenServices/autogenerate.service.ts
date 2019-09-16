import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import {AutogenerateService } from '../pages/auto-generate-team/auto-generate-team.component'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutogenerateService {

  constructor(private http:HttpClient) { }
  getByIdeaTitleAndRoleName(title,role):any{
    console.log("in getbyemail of reg service ",title,role);
    return this.http.get<any>(`http://13.235.10.115:8081/api/v1/applied/${title}?roleName=${role.role} `);
  }

  // get():any{
  //   return this.http.get<any>(`http://localhost:3000/ServiceProviderTest`);
  // }

}
