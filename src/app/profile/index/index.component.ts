import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private auth:AuthenticationService,private router:Router) { }

  ngOnInit() {
  }

  public isloggedin(){
  
    return this.auth.isUserLoggedIn();
  }
  public logout(){
     this.auth.clear();
     this.router.navigate(['home/login'])
  }

}
