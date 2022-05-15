import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { AuthenticationService } from '../auth/authentication.service';
import { MessageService } from '../message.service';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  placeholder: any = [];
  cartitems = new BehaviorSubject([]);
  items:any=[];
  constructor(private message: MessageService, private auth: AuthenticationService) {
    
    // const itemholder = JSON.parse(localStorage.getItem('cartitems') || '[]')
    // if (itemholder) {
    //   this.cartitems.next(itemholder);
    //   //console.log(itemholder)
    // }
    this.items.push((localStorage.getItem("cartitems")));
      console.log(this.items)
  // localStorage.removeItem("cartitems")
  // localStorage.removeItem("totalPrice")

  }


  totalPrice:number=parseInt(localStorage.getItem("totalPrice") || "0");
  
  public storeitem(menu: any) {
    //const itemholder = JSON.parse(localStorage.getItem('cartitems') ||  '[]')

    if (this.isloggedin()) {
      
     
     
       this.placeholder.push(menu.itemname)
 
    
       if(!localStorage.getItem('cartitems'))
       {
         this.cartitems.next(this.placeholder)
         this.cartitems.getValue()
         localStorage.setItem("cartitems",JSON.stringify(this.placeholder))
       
         //localStorage.setItem("cartitems", `[{"itemname":"${menu.itemname}","itemprice":"${menu.itemprice}"}]`)
         this.totalPrice+=parseInt(menu.itemprice);
      localStorage.setItem("totalPrice", ""+this.totalPrice)
    
  
       }
       else{
      const newdata=[...this.items,JSON.stringify(this.placeholder)];
      this.cartitems.next(this.placeholder)
      localStorage.setItem("cartitems",JSON.stringify(newdata));
     // localStorage.setItem("cartitems","["+localStorage.getItem("cartitems")+","+`{"itemname":"${menu.itemname}","itemprice":"${menu.itemprice}"}]`)
      this.totalPrice+=parseInt(menu.itemprice)
      localStorage.setItem("totalPrice",""+this.totalPrice)
    
       }
    }
    else {
      this.message.pleaseLoginMessage();
    }
  }
  
  public isloggedin() {

    return this.auth.isUserLoggedIn();
  }
  public getitems(){
   // console.log(this.cartset)
    return  localStorage.getItem('cartitems')
  }
  public gettotalcost(){
    return localStorage.getItem('totalPrice')
  }
}

  



  // storeitem(menu: any) {
  //   if(this.isloggedin()){
  //   this.cart.push(menu)
  //   if (localStorage.getItem("cartitems") == null) {
  //     localStorage.setItem("cartitems",this.cart)
  //     this.totalPrice+=menu.itemprice
  //     localStorage.setItem("totalPrice", ""+this.totalPrice)
  //   } else {
  //     localStorage.setItem("cartitems",localStorage.getItem("cartItem")+","+`{"itemname":"${menu.itemname}","itemprice":"${menu.itemprice}"}`)
  //     this.totalPrice+=parseInt(menu.itemprice)
  //     localStorage.setItem("totalPrice",""+this.totalPrice)
  //   }
  // }
 
 // let exist: any;
      // console.log(itemholder)
      // if (itemholder) {
      //   exist = itemholder.find((item: any) => {
      //    return item.itemname === menu.itemname;

      //   })
      // }
      // if (!exist) {
      //   if (itemholder) {
      //     const newdata = [...itemholder, menu];
      //     localStorage.setItem('cartitems', JSON.stringify(newdata));
      //     this.cartitems.next(JSON.parse(localStorage.getItem('cartitems') || null || '{}'))


      //   }
      //   else{
      //     this.placeholder.push(menu)
      //     localStorage.setItem('cartitems', JSON.stringify(this.placeholder));
      //     this.cartitems.next(this.placeholder);

      //   }
      // }
      // if(itemholder)
      // {
     
      // //this.cartset.add(itemholder);
      // console.log("hi")
      // console.log(itemholder)
      // }