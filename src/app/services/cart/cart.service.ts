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
 
  noofitems = new BehaviorSubject([]);
  constructor(private message: MessageService, private auth: AuthenticationService,
    private http:HttpClient,private helper:HttpclientService,private Userlogin:UserloginService) { 


  }

  
  cartQty =0;
  cartObj = [];
 public cartTotalPrice :any;


 getCartDetailsByUser(){
  this.userid=this.auth.getuserid();

  this.helper.getcartsbyuser(this.userid).subscribe(this.observer)
  
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
    this.cartServiceEvent.next({"status":"completed"})
   this.userid=this.auth.getuserid();
    if(this.isloggedin())
    {
    if( this.Userlogin.roleMatch(['User']))
    {

      var request  = {
        "itemID":item.id,
        "qty":1,
        "itemname":item.itemname,
        "price":item.itemprice,
        "userId":this.userid,
       
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
          this.message.addtocart();
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




  //  removeCart(cartId:number){
  //     var request = {         
  //         "userId":this.userid,
  //         "cartId":cartId,
  //     }
  //     console.log(request)
  //     this.helper.removecartitem(request).subscribe(this.removeCartobserver)
  // }
  // removeCartobserver=(data:any)=>{
  //   next:{ this.getCartDetailsByUser();}
  // error:(error:any)=>{
  //   alert("Error while fetching the cart Details");
  // }
  // }

public isloggedin() {
  return this.auth.isUserLoggedIn();
}


}

