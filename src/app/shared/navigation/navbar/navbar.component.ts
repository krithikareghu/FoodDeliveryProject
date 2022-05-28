import { Component, HostListener, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Router, ActivatedRoute } from '@angular/router';

import { UserloginService } from 'src/app/services/login/userlogin.service';


import { MessageService } from 'src/app/services/message.service';
import { CartService } from 'src/app/services/cart/cart.service';
import { HttpclientService } from 'src/app/services/httpclient.service';




@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private auth: AuthenticationService, private router: Router, private cart: CartService, private message: MessageService
    , public userlogin: UserloginService, private http: HttpclientService) { 
   // this.value=0;
     
    }
    value:any=0;

  noofitems!: number;
  ngOnInit(): void {

    this.cart.cartServiceEvent.subscribe(this.observer);

  }
  observer = {
    next: (data: any) => {
      this.noofitems = this.cart.getQty();

    }
  }


  public isloggedin() {

    return this.auth.isUserLoggedIn();
  }
  public logout() {
    this.auth.clear();
    this.router.navigate(['home'])
    this.message.logoutSuccess();
  }

bar(){
  if(this.value==0)
  {
    this.value=1;
  }
  else{
    this.value=0;
  }
 
  //document.getElementsByClassName('togglebutton')[0]
  // console.log(document.getElementsByClassName('navbar')[0])  
  //       document.getElementsByClassName('navbar')[0]
  //   .classList.toggle('active')
   
      }
  }
  

 





  


