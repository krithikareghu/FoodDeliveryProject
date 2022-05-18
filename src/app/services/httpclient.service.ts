import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Userregister } from 'src/app/shared/model/userregister';

@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  requestheader = new HttpHeaders(
    {
      "No-Auth": "True"
    })
  baseurl="http://localhost:8080"

  constructor(private http:HttpClient) { }


  getcustomerdetails(){
    return this.http.get<Userregister>(this.baseurl+'/allusers');
  }
 
  getallcategories(){
    return this.http.get(this.baseurl+'/findAllcategories',{headers: this.requestheader });
  }
  onlycategoryname(){
    return this.http.get(this.baseurl+"/allcategory",{headers: this.requestheader});
  }
  getrestaurants(categoryid:number){
    return this.http.get(this.baseurl+"/getrestaurantsfromcategory/"+categoryid,{headers: this.requestheader})
  }
  getcategorypics(){
    return this.http.get(this.baseurl+'/categorypic',{headers: this.requestheader})
  }
  getitems(restaurantname:string){
    return this.http.get(this.baseurl+'/getitemsfromrestaurants/'+restaurantname,{headers: this.requestheader})
  }
  getitempic(restaurantname:string){
    return this.http.get(this.baseurl+'/itempic/'+restaurantname,{headers:this.requestheader})
  }

  jwttoken=localStorage.getItem("jwtToken");

 jwtheader={
  "token":""+this.jwttoken
}
  addtocart(request:any){
   
  return  this.http.post(this.baseurl+"/additemtocart",request,{headers:this.jwtheader})
  }
 

  removecartitem(request:any){
 
    return this.http.delete(this.baseurl+"/removeItemFromCart",{params:request})
  }
  
  updatequantity(request:any){
    return this.http.put(this.baseurl+"/updateQtyForCart",request,{headers:this.jwtheader})
  }
  getcartsbyuser(){
    return this.http.get(this.baseurl+"/getCartsByUserId",{headers:this.jwtheader})
  }
  checkoutorder(request:any){
    return this.http.post(this.baseurl+"/checkout_order",request,{headers:this.jwtheader})
  }
  
  getuserid(){
console.log(this.jwttoken)
    return this.http.get(this.baseurl+"/getuserid",{headers:this.jwtheader})
  }
  getOrdersByUserId(){
    return this.http.get(this.baseurl+"/getOrdersByUserId",{headers:this.jwtheader})
  }
}