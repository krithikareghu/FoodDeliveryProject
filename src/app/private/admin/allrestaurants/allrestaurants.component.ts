import { Component, OnInit } from '@angular/core';
import { ClientService } from './../client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-allrestaurants',
  templateUrl: './allrestaurants.component.html',
  styleUrls: ['./allrestaurants.component.css']
})
export class AllrestaurantsComponent implements OnInit {

  constructor(private client:ClientService,private router:Router) { }
allrestaurants:any;
  ngOnInit(): void {
   this.getallrestaurants();
  }
  observer={
    next:(res:any)=>{
this.allrestaurants=res;

    },error:()=>
    {
      alert("Error in loading the restaurants ")
    }
  }
  getallrestaurants(){
    this.client.getallrestaurants().subscribe(this.observer)
  }
  deleterestaurant(restauarntname:any){
    this.client.removerestaurant(restauarntname).subscribe(this.removeobserver)
  }
  removeobserver={
    next:(res:any)=>{
      this.allrestaurants=res;
    },error:()=>{
      alert("something went wrong")
    }
  }
  addrestaurant(){
this.router.navigate(['/addrestaurant'])
  }


}
