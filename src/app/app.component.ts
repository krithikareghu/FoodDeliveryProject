import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from './services/auth/authentication.service';
import { UserloginService } from './services/login/userlogin.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'food Delivery App';
  constructor(private auth:AuthenticationService,private router:Router,public userlogin:UserloginService,private route:ActivatedRoute) { }
  public searchFilter: any = '';
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
