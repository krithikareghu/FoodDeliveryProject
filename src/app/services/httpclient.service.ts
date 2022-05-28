import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { globalVars } from '../shared/url.model';

@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  requestheader = new HttpHeaders(
    {
      "NO-AUTH": "True"
    })
  baseurl= globalVars.backendAPI

  constructor(private http:HttpClient) { }

  getallcategories(){
  
    return this.http.get(this.baseurl+'/category/findAllcategories',{headers: this.requestheader });
  }
  onlycategoryname(){
    return this.http.get(this.baseurl+"/category/allcategory",{headers: this.requestheader});
  }
  getrestaurants(categoryid:number){
    return this.http.get(this.baseurl+"/category/getrestaurantsfromcategory/"+categoryid,{headers: this.requestheader})
  }
  getcategorypics(){
    return this.http.get(this.baseurl+'/category/categorypic',{headers: this.requestheader})
  }
  getitems(restaurantname:string){
    return this.http.get(this.baseurl+'/category/getitemsfromrestaurants/'+restaurantname,{headers: this.requestheader})
  }
  getitempic(restaurantname:string){
    return this.http.get(this.baseurl+'/category/itempic/'+restaurantname,{headers:this.requestheader})
  }

  getuserbyid(userid:any){
   
    return this.http.get(this.baseurl+'/user/getuserdetails/'+userid)
  }


  addtocart(request:any){
   
  return  this.http.post(this.baseurl+"/user/additemtocart",request)
  }
 

  removecartitem(request:any){
 
    return this.http.delete(this.baseurl+"/user/removeItemFromCart",{params:request})
  }
  
  updatequantity(request:any){
    return this.http.put(this.baseurl+"/user/updateQtyForCart",request)
  }
  
  getcartsbyuser(userid:any){
    return this.http.get(this.baseurl+"/user/getCartsByUserId/"+userid)
  }
  checkoutorder(request:any){
    return this.http.post(this.baseurl+"/user/checkout_order",request)
  }
  
  // getuserid(){

  //   return this.http.get(this.baseurl+"/getuserid")
  // }
  getOrdersByUserId(userid:any){
    return this.http.get(this.baseurl+"/user/getOrdersByUserId/"+userid)
  }
  updateuserdetails(updateuser:any){
    return this.http.put(this.baseurl+'/user/updateuser',updateuser);
  }
 

}