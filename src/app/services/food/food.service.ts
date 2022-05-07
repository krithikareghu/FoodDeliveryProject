import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Addcategory } from './../../shared/model/addcategory';
import { Observable } from 'rxjs';
import { Category } from './../../shared/model/category';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private allcategoryurl="http://localhost:8080/allcategory"
  private categorydetails="http://localhost:8080/findAllcategories"

  constructor(private http:HttpClient) { }


getcategorydetails()
{
  return this.http.get(this.categorydetails);
}




}
