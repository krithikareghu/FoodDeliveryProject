import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { UserregisterService } from 'src/app/services/register/userregister.service';
import { Useraddress } from 'src/app/shared/model/useraddress';
import { UseraddressService } from '../../services/address/useraddress.service';
import { HttpParams } from '@angular/common/http';
import { MessageService } from './../../services/message.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addaddress',
  templateUrl: './addaddress.component.html',
  styleUrls: ['./addaddress.component.css']
})
export class AddaddressComponent implements OnInit {

  useraddress: Useraddress = new Useraddress();
  constructor(
    private useraddressService: UseraddressService,private auth:AuthenticationService,private message:MessageService,private router:Router
  ) { }

  ngOnInit(): void {
  }

  observer = {
    next: () => {alert("address added successfully")
  
  this.router.navigate(['/user'])},
    error: (error: any) =>alert("please enter proper address"),

};

addaddress() {
  console.log(this.useraddress.address)
  if(this.useraddress.address==null)
  {
    this.message.addadddresstosubmit();
  }
  else{
    this.useraddressService.addaddress(this.useraddress)
    .subscribe(this.observer);
  }
   
}
}
