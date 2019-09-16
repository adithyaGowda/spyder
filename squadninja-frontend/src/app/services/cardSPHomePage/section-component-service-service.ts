import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SectionComponentServiceData } from 'src/app/services/cardSPHomePage/section-component-service-model';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class SectionComponentSP {

  private _url : string= 'http://13.235.10.115:8084/serviceprovider';


  constructor(private http:HttpClient) {
    this.http=http;
   }

  getSP(): Observable<SectionComponentServiceData[]> {
    return this.http.get<SectionComponentServiceData[]>(this._url);
}
}
