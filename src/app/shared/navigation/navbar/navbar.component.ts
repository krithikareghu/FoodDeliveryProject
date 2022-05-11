import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Userlogin } from 'src/app/shared/model/userlogin';
import { UserloginService } from 'src/app/services/login/userlogin.service';
import { SearchpipePipe } from './../../pipes/searchpipe.pipe';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private auth:AuthenticationService,private router:Router,public userlogin:UserloginService,private route:ActivatedRoute) { }
  public searchFilter: any = '';
  ngOnInit(): void {
    this.route.params.subscribe(params=>{
      if(params['searchFilter'])
        this.searchFilter=params['searchFilter']})
  }
public isloggedin(){

  return this.auth.isUserLoggedIn();
}
public logout(){
   this.auth.clear();
   this.router.navigate(['home'])
}

}
