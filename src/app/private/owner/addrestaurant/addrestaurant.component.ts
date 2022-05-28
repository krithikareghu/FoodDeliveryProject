import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurantdetails } from '../../../shared/model/restaurantdetails';
import { RestauarntService } from './../../../services/restaurant/restauarnt.service';

@Component({
  selector: 'app-addrestaurant',
  templateUrl: './addrestaurant.component.html',
  styleUrls: ['./addrestaurant.component.css']
})
export class AddrestaurantComponent implements OnInit {

  constructor(private router: Router, private registerresturant: RestauarntService) { }

  ngOnInit(): void {
  }

  restaurantdetails: Restaurantdetails = new Restaurantdetails();
  observer = {
    next: () => {
      alert("registered successfully")
      localStorage.setItem("registeredrestaurant",this.restaurantdetails.restaurantname)
      this.router.navigate(['/owner/addcategory'])
    },
    error: (error: any) => alert("please enter proper credentials to register"),

  };
  registerrestaurant() {
   
    this.registerresturant.registerrestaurant(this.restaurantdetails).subscribe(this.observer);

  }
}
