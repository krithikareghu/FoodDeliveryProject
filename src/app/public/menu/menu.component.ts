import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FoodService } from 'src/app/services/food/food.service';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { UserloginService } from 'src/app/services/login/userlogin.service';


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
  constructor(private http: HttpClient, private helper: HttpclientService, private food: FoodService,public userlogin:UserloginService
    ,private route:ActivatedRoute) {}
  
  ngOnInit() {


  
    this.helper.getallcategories().subscribe(
      response => this.handleallcategoryResponse(response),
    );
    this.display();
  }
  handleallcategoryResponse(response: any) {

    this.allcategories = response;
    console.log(this.allcategories)
  }

  display() {
    this.helper.getcategorypics()
      .subscribe(
         res => {
        
           this.images = res;
           console.log(res)

        });
        this.value = Array.from({ length: 20 }, () => (Math.random() * (9.00 - 2.00 + 2.00) + 1.00).toFixed(1));

  }


}