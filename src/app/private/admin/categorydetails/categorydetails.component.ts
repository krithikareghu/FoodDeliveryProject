import { Component, OnInit, ViewChild } from '@angular/core';
import { FoodService } from './../../../services/food/food.service';
import { HttpClient } from '@angular/common/http';
import { HttpclientService } from './../../../services/httpclient.service';
import { RestauarntService } from './../../../services/restaurant/restauarnt.service';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';
import { ClientService } from './../client.service';
import { Router } from '@angular/router';
import { globalVars } from 'src/app/shared/url.model';

@Component({
  selector: 'app-categorydetails',
  templateUrl: './categorydetails.component.html',
  styleUrls: ['./categorydetails.component.css']
})
export class CategorydetailsComponent implements OnInit {
  selectedFile: any;
  imgURL: any;
baseurl=globalVars.backendAPI
  constructor(private client: FoodService,
    private http: HttpClient, private restaurant: RestauarntService, private helper: ClientService,private router:Router,
    private allcategory: HttpclientService) { }
  categoriesdetails!: any[];
  allcategories!: any;
  retrieveResonse: any;
  base64Data: any;
  retrievedImage: any;
  images: any = [];
  restaurants: any = [];

  ngOnInit() {

    this.client.getcategorydetails().subscribe(
      response => this.handlecategoryResponse(response),
    );
    this.displaycategorypic();

  }
  handlecategoryResponse(response: any) {
    this.categoriesdetails = response;
  }
  

  displaycategorypic() {
    this.http.get(this.baseurl+'/category/categorypic')
      .subscribe(
        res => {
          this.images = res;
         
        });
  }
  displayrestaurants() {
    this.restaurant.getrestaurants().subscribe(
      res => {
        this.restaurants = res;
      }
    )


  }
  remove(categoryid: any) {
    this.helper.removecategory(categoryid).subscribe(this.observer)
  }
  observer = {
    next: (res: any) => {
      this.categoriesdetails = res;
    }, error: () => {
      alert("Something went wrong")
    }
  }
  addcategory(){
    this.router.navigate(['/owner/addcategory'])
  }
}
