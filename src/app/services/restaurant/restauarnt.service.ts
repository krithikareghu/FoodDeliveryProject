import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurantdetails } from './../../shared/model/restaurantdetails';

@Injectable({
  providedIn: 'root'
})
export class RestauarntService {


 requestheader = new HttpHeaders(
    {
      "No-Auth": "True"
    }
  ) 
  constructor(private http: HttpClient) { }
  args: any;
  getrestaurants(): Observable<object> {
    return this.http.get("http://localhost:8080/allrestaurants");
  }
   registerrestaurant(restaurantdetails: Restaurantdetails) {
    return  this.http.post("http://localhost:8080/addrestaurant", restaurantdetails,{ headers: this.requestheader })
  }


}