import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestauarntService {

  constructor(private http:HttpClient) { }
  getrestaurants(){
    return this.http.get("http://localhost:8080/allrestaurants");
  }

}
