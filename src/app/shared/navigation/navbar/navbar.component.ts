import { Component, HostListener, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Router, ActivatedRoute } from '@angular/router';

import { UserloginService } from 'src/app/services/login/userlogin.service';


import { MessageService } from 'src/app/services/message.service';
import { CartService } from 'src/app/services/cart/cart.service';




@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private auth:AuthenticationService,private router:Router,private cart:CartService,private message:MessageService
    ,public userlogin:UserloginService,private route:ActivatedRoute) { }
  public searchFilter: any = '';
   noofitems!:number;
  ngOnInit(): void {

this.cart.cartServiceEvent.subscribe(this.observer);
        
  }
observer={
  next:(data:any)=>{
    this.noofitems=this.cart.getQty();

  }
}

    
public isloggedin(){

  return this.auth.isUserLoggedIn();
}
public logout(){
   this.auth.clear();
   this.router.navigate(['home'])
   this.message.logoutSuccess();
}

}
