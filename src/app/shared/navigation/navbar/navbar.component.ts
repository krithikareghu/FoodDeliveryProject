import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Router } from '@angular/router';
import { Userlogin } from 'src/app/shared/model/userlogin';
import { UserloginService } from 'src/app/services/login/userlogin.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private auth:AuthenticationService,private router:Router,public userlogin:UserloginService) { }

  ngOnInit(): void {
  }
public isloggedin(){

  return this.auth.isUserLoggedIn();
}
public logout(){
   this.auth.clear();
   this.router.navigate(['home'])
}

}
