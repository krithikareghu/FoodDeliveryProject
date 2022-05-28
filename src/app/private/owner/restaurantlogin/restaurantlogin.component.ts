import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { UserloginService } from 'src/app/services/login/userlogin.service';
import { MessageService } from 'src/app/services/message.service';
import { Userlogin } from 'src/app/shared/model/userlogin';

@Component({
  selector: 'app-restaurantlogin',
  templateUrl: './restaurantlogin.component.html',
  styleUrls: ['./restaurantlogin.component.css']
})
export class RestaurantloginComponent implements OnInit {


  userlogin: Userlogin = new Userlogin();  
  constructor(
    private userloginservice:UserloginService,
       private router: Router,
       private auth:AuthenticationService  ,private message:MessageService,private http:HttpclientService 
  ) {
  }

  ngOnInit() { 
}
phonenumber!:string;
observer = {
  next:(response:any)  =>{
    this.auth.setRoles(response.userData.roles);
    this.auth.setuserid(response.userData.id);
    this.auth.setToken(response.jwttoken);
   const role= response.userData.roles[0].rolename;
    
     if(role=='owner'){
      this.router.navigate(['/owner/addcategory'])
      this.message.loginAsOwner();
    }
    else{
      this.router.navigate(['/home'])
      this.message.loginSuccess();
    }
 
    },
  
  error: () =>this.message.invalidEmailPasswordMessage()

};


// login() {
//   this.userloginservice.loginrestaurant(this.userlogin)
//       .subscribe(this.observer);
// }
}
