import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart/cart.service';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { MessageService } from 'src/app/services/message.service';
import { BehaviorSubject } from 'rxjs';


@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  successcart:any=[];
  ordersuccess: boolean = false;
  cartObj: any = [];
  cartTotalPrice: any
  pay_type = "cash_on_delivery";
  delivery_address = "";
  Quantity: number = 1;
  public cartServiceEvent = new BehaviorSubject({});
  constructor(private router: Router, private cartService: CartService, private message: MessageService,
    private http: HttpclientService, private auth: AuthenticationService) { }

  ngOnInit() {
    if (this.isuserloggedin()) {
      this.getCartDetailsByUser();
     
    }

    this.cartService.cartServiceEvent.subscribe(data => {
      this.cartObj = this.cartService.getCartOBj();
      this.cartTotalPrice = this.cartService.cartTotalPrice;

    });
  }
  plus(cart: any) {
    if (cart.qty < 4) {
      cart.qty = cart.qty + 1;
      cart.price = cart.qty * cart.price;
      this.changequantity(cart);
    }

  }

  minus(cart: any) {

    if (cart.qty > 1) {
      cart.qty = cart.qty - 1;
      cart.price = cart.price / (cart.qty + 1);
      this.changequantity(cart)
    }
  }
  isuserloggedin() {
    return this.auth.isUserLoggedIn()
  }


  userid=this.auth.getuserid();
  changequantity(cart: any) {
   
    let request = {
      "cartId": cart.id,
      "userId": this.userid,
      "qty": cart.qty,
      "price": cart.price

    }

    this.http.updatequantity(request).subscribe(this.updatequantityobserver)

  }

  updatequantityobserver = {
    next: (data: any) => {

      this.cartTotalPrice = this.getTotalAmountOfTheCart()

    },
    error: (error: any) => {
      alert("Error while fetching the Details");
    }

  }
userstring!:string;


cartqty:any;
  getCartDetailsByUser() {
    

this.userid=this.auth.getuserid();


    this.http.getcartsbyuser(this.userid).subscribe(this.getcartobserver)
  }
  getcartobserver = {
    next: (data: any) => {
      this.cartObj = data;
      this.cartqty = data.length;
      this.cartTotalPrice = this.getTotalAmountOfTheCart();
      this.cartServiceEvent.next({"status":"completed"})

    },
    error: () => {
      alert("Error while fetching the cart ");
    }
  }

  getTotalAmountOfTheCart() {
    console.log(this.cartObj)
    let obj = this.cartObj;
    let totalPrice = 0;
    for (var item in obj) {
      console.log(obj[item].price)
      totalPrice = totalPrice + parseFloat(obj[item].price);
    }
    return totalPrice.toFixed(2);
  }


  // getuserid() {
  //   this.http.getuserid().subscribe(this.getidobserver)

  // }
  getidobserver = {
    next: (res: any) => {
      this.userid = res;
    }, error: () => {
      console.log("error in getting the id")
    }
  }

  removeCartById(cartObj: any) {
this.userid=this.auth.getuserid();
    if (confirm("Are you sure want to delete..?")) {
      let request = {
        "userId": this.userid,
        "cartId": cartObj.id,
      }
      this.http.removecartitem(request).subscribe(this.removeCartobserver)
    }
  }
  removeCartobserver = () => {
    next: {
     
      this.cartObj = this.getCartDetailsByUser();
     this.cartServiceEvent.next(this.cartObj)
      this.cartService.cartServiceEvent.subscribe(data => {
        this.cartObj = this.cartService.getCartOBj();
        this.cartTotalPrice = this.cartService.cartTotalPrice;
  
      });
      this.cartTotalPrice = this.getTotalAmountOfTheCart();
    }
    error: (error: any) => {
      console.log("error")
    }
  }

  


  checkoutCart() {
    console.log(this.cartObj)
    if (this.cartObj.length == 0) {
      console.log(this.cartObj)
      this.message.cartempty();
      return;
    }
    if (this.delivery_address == "") {
      this.message.warn("Add delivery address")
      return;
    }

    if (this.pay_type == "cash_on_delivery") {
      let request = {
        "total_price": this.cartTotalPrice,
        "pay_type": "COD",
        "deliveryAddress": this.delivery_address,
        "userId":this.auth.getuserid()
      }
      this.http.checkoutorder(request).subscribe(this.checkoutorderobserver)

    } else {
      alert("Payment Integration is not yet completed.")
    }
  }
  checkoutprice!:any;
  checkoutorderobserver = {
    next: () => {
      this.successcart=this.cartObj;
      alert("checkout process completed.Your Order is processed..");
      this.cartObj = this.getCartDetailsByUser();
      this.router.navigate(['']);
      this.cartTotalPrice=this.getTotalAmountOfTheCart;
      this.ordersuccess = true;

    }, error: (data: any) => {
      //alert("something went wrong")
      this.successcart=this.cartObj;
      this.checkoutprice=this.getTotalAmountOfTheCart();
      console.log(this.cartTotalPrice)
      alert("checkout process completed.Your Order is processed..");
      this.ordersuccess = true;
      this.cartObj = this.getCartDetailsByUser(); 
    }
  }




}
// for chheckout order
// getCartDetailsByUser(){
//   this.userid=this.auth.getuserid();

//   this.helper.getcartsbyuser(this.userid).subscribe(this.observer)
  
//  }

//  observer={
//  next:(data:any)=>{

//  this.cartObj = data;
//    this.cartQty = data.length;
//   this.cartServiceEvent.next({"status":"completed"})

// },
// error:()=>{
//  alert("Error while fetching the cart Details");

// }
// }