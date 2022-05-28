import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Router } from '@angular/router';
import { MessageService } from './../../../services/message.service';

@Component({
  selector: 'app-adminnav',
  templateUrl: './adminnav.component.html',
  styleUrls: ['./adminnav.component.css']
})
export class AdminnavComponent implements OnInit {

  constructor(private auth:AuthenticationService,private router:Router,private message:MessageService) { }

  ngOnInit(): void {
  }
  value:any=0;

  public isloggedin(){

    return this.auth.isUserLoggedIn();
  }
  public logout(){
    this.auth.clear();
    this.router.navigate(['/home'])
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
 
}
}
