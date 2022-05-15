import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FoodService } from 'src/app/services/food/food.service';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { Foodcategory } from './../../shared/model/foodcategory';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  images: any = [];
  allcategories!: any
  categorydetials:any;
  value!: any;
  constructor(private http: HttpClient, private helper: HttpclientService, private food: FoodService
    ,private route:ActivatedRoute) {}
    //   this.route.params.subscribe(params=>{
    //     if(params['id']){
    //       this.foodcategory=this.food.getfoodbyid(params['id'])
    //     }
    //   })
    //   console.log(this.foodcategory.Restaurant)
    //  }
  // foodcategory!:Foodcategory;
  ngOnInit() {

// this.allcategory.getallcategories().subscribe(response=>{
//   this.handlecategorydetailsResponse(response)
// })
    // this.route.params.subscribe(params=>{
    //   if(params['searchItem']){
    //     this.categories=this.food.getall().filter
    //     (categoryfood=>categoryfood.categoryname
    //       .toLowerCase()
    //     .includes(params['searchItem'].toLowerCase))
    //     console.log(this.categories)
    //   }
    //   else{
    //   this.categories = this.food.getall();
    //   }
    // })

  
    this.helper.getallcategories().subscribe(
      response => this.handleallcategoryResponse(response),
    );
    this.display();
  }
  handleallcategoryResponse(response: any) {
    this.allcategories = response;
    this.display();
  }

  display() {
    this.helper.getcategorypics()
      .subscribe(
        async res => {
          await (this.images = res);

        });
        this.value = Array.from({ length: 20 }, () => (Math.random() * (9.00 - 2.00 + 2.00) + 1.00).toFixed(1));

  }


}