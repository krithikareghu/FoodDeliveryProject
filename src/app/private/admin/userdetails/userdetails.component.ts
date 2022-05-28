import { Component, OnInit } from '@angular/core';
import { ClientService } from './../client.service';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {

  constructor(private client:ClientService) { }

  allusers!:any[];
  admin!:any
  ngOnInit() {

  this.getallusers();

  }
  observer={
    next:(res:any)=>{
   
    this.allusers=res.splice(1);
  
    },
    error:()=>{
      alert("error in getting all users");
    }
  }

  getallusers(){
 
    this.client.getallusers().subscribe(this.observer)
  }
  removeusers(userid:any){
    this.client.removeuser(userid).subscribe(this.removeobserver)

  }
removeobserver={
  next:(res:any)=>{
    this.allusers=res.splice(1);
    console.log(this.allusers)

  },error:()=>{
    alert("something went wrong")
  }
}  

}
