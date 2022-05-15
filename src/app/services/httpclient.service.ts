import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Userregister } from 'src/app/shared/model/userregister';

@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  requestheader = new HttpHeaders(
    {
      "No-Auth": "True"
    })
  

  constructor(private http:HttpClient) { }
  
  getcustomerdetails(){
    return this.http.get<Userregister>('http://localhost:8080/allusers');
  }
 
  getallcategories(){
    return this.http.get('http://localhost:8080/findAllcategories',{headers: this.requestheader });
  }
  onlycategoryname(){
    return this.http.get("http://localhost:8080/allcategory",{headers: this.requestheader});
  }
  getrestaurants(categoryid:number){
    return this.http.get("http://localhost:8080/getrestaurantsfromcategory/"+categoryid,{headers: this.requestheader})
  }
  getcategorypics(){
    return this.http.get('http://localhost:8080/categorypic',{headers: this.requestheader})
  }
  getitems(restaurantname:string){
    return this.http.get('http://localhost:8080/getitemsfromrestaurants/'+restaurantname,{headers: this.requestheader})
  }
  getitempic(restaurantname:string){
    return this.http.get('http://localhost:8080/itempic/'+restaurantname,{headers:this.requestheader})
  }
}