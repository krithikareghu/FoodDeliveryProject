import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Userregister } from 'src/app/shared/model/userregister';
import { Category } from '../shared/model/category';

@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  constructor(private http:HttpClient) { }
  getcustomerdetails(){
    return this.http.get<Userregister>('http://localhost:8080/allusers');
  }
  getallcategories(){
    return this.http.get('http://localhost:8080/findAllcategories');
  }
  onlycategoryname(){
    return this.http.get("http://localhost:8080/allcategory");
  }
  
}
