import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { AuthenticationService } from '../auth/authentication.service';
import { MessageService } from '../message.service';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Userlogin } from '../../shared/model/userlogin';
import { UserloginService } from 'src/app/services/login/userlogin.service';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartServiceEvent = new BehaviorSubject({}); 
   //cart:Cart=new Cart();
  placeholder: any = [];
  noofitems = new BehaviorSubject([]);
  items:any=[];   
  cartitems!:any;
  cartarray!:any;

 
  constructor(private message: MessageService, private auth: AuthenticationService,
    private http:HttpClient,private helper:HttpclientService,private Userlogin:UserloginService) { 
    const itemholder = JSON.parse(localStorage.getItem('cartitems') || '[]')
    if (itemholder) {
      this.noofitems.next(itemholder);

      this.getCartDetailsByUser();
  
    }

  }

  
  cartQty = 0;
  cartObj = [];
 public cartTotalPrice :any;


   getCartDetailsByUser(){
   
     this.helper.getcartsbyuser().subscribe(this.observer)
     
    }

    observer={
    next:(data:any)=>{

    this.cartObj = data;
      this.cartQty = data.length;
     this.cartServiceEvent.next({"status":"completed"})

  },
  error:()=>{
    alert("Error while fetching the cart Details");

  }
}

  addCart(item:any){
    this.cartServiceEvent.next({"status":"completed"})//emitter

    if(this.isloggedin())
    {
    if( this.Userlogin.roleMatch(['user']))
    {

      var request  = {
        "itemID":item.id,
        "qty":1,
        "itemname":item.itemname,
        "price":item.itemprice,
       
      }
  
      this.helper.addtocart(request).subscribe(this.addcartobserver)
    }
    else{
      this.message.loginAsUser();
    }
  }
    else{
      this.message.pleaseLoginMessage();
    }

    }
      addcartobserver={
        next:(data:any)=>{
          this.getCartDetailsByUser();
         
  
        },error:(error:any)=>{
         this.message.itemalreadyexists();
        }
   
    }
    getCartOBj(){
    return this.cartObj;
  }

  // getTotalAmounOfTheCart(){
  //   let obj = this.cartObj;
  //   let totalPrice  = 0;

  //   for(var o in obj ){      
  //     totalPrice = totalPrice +parseFloat(obj[o].price);
  //   }

  //   return totalPrice.toFixed(2);
  // }
  userid!:any;
  getQty(){
    return this.cartQty;
  }
  token!:any;
getuserid(){
  this.helper.getuserid().subscribe(this.getidobserver)

}
getidobserver={
  next:(res:any)=>{
this.userid=res;
  },error:()=>{
   console.log("error in getting the id")
  }

}
   removeCart(cartId:number){
     this.getuserid();
      var request = {         
          "userId":this.userid,
          "cartId":cartId,
      }
      console.log(request)
      this.helper.removecartitem(request).subscribe(this.removeCartobserver)
  }
  removeCartobserver=(data:any)=>{
    next:{ this.getCartDetailsByUser();}
  error:(error:any)=>{
    alert("Error while fetching the cart Details");
  }
  }

public isloggedin() {

  return this.auth.isUserLoggedIn();
}

public gettotalcost(){
  return localStorage.getItem('totalPrice')
}
}

