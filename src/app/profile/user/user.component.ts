import { Component, OnInit } from '@angular/core';
import { UserregisterService } from './../../services/register/userregister.service';
import { Userregister } from 'src/app/shared/model/userregister';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { map } from 'rxjs/operators';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { Updateuser } from 'src/app/shared/model/updateuser';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private http:HttpclientService,private auth:AuthenticationService) { }
userid!:any;
user:string[]=[];
heading:string[]=[];
value:boolean=false;
updateuser!:Updateuser;
  ngOnInit() {

  
  this.userid=this.auth.getuserid();
  this.http.getuserbyid(this.userid).subscribe(this.observer)
  this.http.getOrdersByUserId(this.userid).subscribe(this.orderobserver)
  }
  observer={
    next:(res:any)=>{
   for(var userdetails in res){
     if(userdetails!=="password")
     {
        this.user.push(res[userdetails])
        this.heading.push(userdetails)
        }
  }   
    },error: ()=>{
      alert("something went wrong");
    }
  }
  orders:any[]=[]
  orderobserver={
    next:(res:any)=>{
      this.orders=res;
console.log(this.orders)
    },error:()=>{
      alert("Sorry, error occured while loading the order details")
    }
  }
  edit(){
    this.value=true;
  }
  save(user:Updateuser){
   
    this.http.updateuserdetails(user).subscribe(this.updateobserver)
  }
  updateobserver={
    next:(res:any)=>{
      this.user=res;
    },error:(error:any)=>{
      alert("Something wrong happened")
    }
  }

  

}
