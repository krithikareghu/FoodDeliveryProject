import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { globalVars } from 'src/app/shared/url.model';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

 
  private categorydetails = globalVars.backendAPI+ "/category/findAllcategories"

  constructor(private http: HttpClient) { }




  getcategorydetails() {
    return this.http.get(this.categorydetails);
  }
}

 
  