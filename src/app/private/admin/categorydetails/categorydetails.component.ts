import { Component, OnInit } from '@angular/core';
import { FoodService } from './../../../services/food/food.service';

@Component({
  selector: 'app-categorydetails',
  templateUrl: './categorydetails.component.html',
  styleUrls: ['./categorydetails.component.css']
})
export class CategorydetailsComponent implements OnInit {

  constructor(private client:FoodService) { }
  categories!:any[];

  ngOnInit() {
    this.client.getcategorydetails().subscribe(
      response => this.handlecategoryResponse(response),
      );
     
    }
    handlecategoryResponse(response: any) {
      this.categories = response;
    }
  
  }
   
  
