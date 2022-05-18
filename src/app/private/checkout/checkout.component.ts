import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart/cart.service';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { MessageService } from 'src/app/services/message.service';


@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
ordersuccess:boolean=false;
  cartObj:any= [];
  cartTotalPrice :any
  pay_type = "cash_on_delivery";
  delivery_address = "";
  Quantity:number=1;
  constructor(private router:Router,private cartService:CartService,private message:MessageService,
    private http:HttpclientService,private auth:AuthenticationService) { }

  ngOnInit() { 
    if(this.isuserloggedin())  
    {
      this.getCartDetailsByUser();
    } 
   
    //below function will be triggerd from when removing and qty  is changing..
    this.cartService.cartServiceEvent.subscribe(data=>{
      this.cartObj =  this.cartService.getCartOBj();
      this.cartTotalPrice  = this.cartService.cartTotalPrice;
    
    });

   
  }
  i=1;
  plus(cart:any){
   if(cart.qty<4)
   {
      cart.qty=cart.qty+1;
      cart.price=cart.qty*cart.price;
     this.changequantity(cart);

   }
    
    }

    minus(cart:any){
  
     if(cart.qty>1){
      cart.qty=cart.qty-1;  
      cart.price=cart.price/(cart.qty+1);
      this.changequantity(cart)
     }   
  }
  isuserloggedin(){
    return this.auth.isUserLoggedIn()
 }
 
  

    changequantity(cart:any){
    var request = {
      "cartId":cart.id,
      "qty":cart.qty,
      "price":cart.price
  
    }
  
      this.http.updatequantity (request).subscribe(this.updatequantityobserver)
      
  }

      updatequantityobserver={
     next:(data:any)=>{
       
     this.cartTotalPrice=  this.getTotalAmounOfTheCart()
       
      },
     error:(error:any)=>{
        alert("Error while fetching the Details");
      }
    
    }
    
  getCartDetailsByUser(){


    this.http.getcartsbyuser().subscribe(this.getcartobserver)}
  getcartobserver={
    next:(data:any)=>{
      this.cartObj = data;
      this.cartTotalPrice = this.getTotalAmounOfTheCart();  
  
    },
    error:()=>{
      alert("Error while fetching the cart ");
    }
  }

  getTotalAmounOfTheCart(){
    let obj = this.cartObj;
    let totalPrice  = 0;   
    for(var item in obj ){      
      totalPrice = totalPrice +parseFloat(obj[item].price);
    }
    return totalPrice.toFixed(2);
  }

userid!:any;
  getuserid(){
    this.http.getuserid().subscribe(this.getidobserver)
  
  }
  getidobserver={
    next:(res:any)=>{
  this.userid=res;
    },error:()=>{
     console.log("error in getting the id")
    }
  }

  removeCartById(cartObj:any){
   
    if(confirm("Are you sure want to delete..?")){
      this.getuserid();
      var request = {         
          "userId":this.userid,
          "cartId":cartObj.id,
      }
      this.http.removecartitem(request).subscribe(this.removeCartobserver)
  }
}
  removeCartobserver=()=>{
    next:{ 
      this.cartObj= this.cartService.getCartDetailsByUser();
      this.cartTotalPrice = this.getTotalAmounOfTheCart();  
    }
  error:(error:any)=>{
   console.log("error")
  }
    } 
  
  
  checkoutCart(){
    console.log(this.cartObj)
    if(this.cartObj.length==0){
      console.log(this.cartObj)
      this.message.cartempty();
      return;
    }
    if(this.delivery_address == ""){
      this.message.warn("Add delivery address")
      return;
    }
   
    if(this.pay_type == "cash_on_delivery"){
      let request = {
        "total_price":this.cartTotalPrice,
        "pay_type":"COD",
        "deliveryAddress":this.delivery_address
     }
      this.http.checkoutorder(request).subscribe(this.checkoutorderobserver)
    
    }else{
        alert("Payment Integration is not yet completed.")
    }
  }
  checkoutorderobserver={
    next:()=>{
      alert("checkout process completed.Your Order is processed..");
    this.cartObj=  this.cartService.getCartDetailsByUser();
      this.router.navigate(['']);
      this.ordersuccess=true;

    },error:(data:any)=>{
      this.message.ordersucess("Order placed successfully")  ;
      this.router.navigate(['/ordersucess']);
   this.ordersuccess=true;
       this.cartObj=  this.cartService.getCartDetailsByUser();
    }
  }




}

