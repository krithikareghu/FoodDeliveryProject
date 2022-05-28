import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurantdetails } from './../../shared/model/restaurantdetails';
import { globalVars } from 'src/app/shared/url.model';
@Injectable({
  providedIn: 'root'
})
export class RestauarntService {
  baseurl=globalVars.backendAPI

 requestheader = new HttpHeaders(
    {
      "No-Auth": "True"
    }
  ) 
  constructor(private http: HttpClient) { }
  args: any;
  getrestaurants(): Observable<object> {
    return this.http.get(this.baseurl+"/allrestaurants");
  }
   registerrestaurant(restaurantdetails: Restaurantdetails) {
    return  this.http.post(this.baseurl+"/admin/addrestaurant", restaurantdetails,{ headers: this.requestheader })
  }


}