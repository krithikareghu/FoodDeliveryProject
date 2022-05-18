import { Component, OnInit } from '@angular/core';
import { UserregisterService } from './../../services/register/userregister.service';
import { Userregister } from 'src/app/shared/model/userregister';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private http:HttpClient,private auth:AuthenticationService) { }
  private baseurl="http://localhost:8080/getuserdetails/{phonenumber}"
  user!:any;
  ngOnInit() {
  this.user= this.getuserdetails();
   console.log( typeof(this.userdetails))
   //console.log(this.userdetails.phonenumber)
  //  for (const item of Object.entries(this.userdetails)) {
  //   console.log(item)
  // }
  }
userdetailslist!:any;
  result!:any;
  userdetails!:any;
  getuserdetails(){
    this.userdetails= this.http.get(`${this.baseurl}`+this.auth.getToken()); 
  
  //       // this.result=res.json().result;
  //   return this.result;

  // })

  }
  

}
