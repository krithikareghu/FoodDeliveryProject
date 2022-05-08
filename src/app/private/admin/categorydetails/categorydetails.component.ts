import { Component, OnInit } from '@angular/core';
import { FoodService } from './../../../services/food/food.service';
import { HttpClient } from '@angular/common/http';
import { HttpclientService } from './../../../services/httpclient.service';

@Component({
  selector: 'app-categorydetails',
  templateUrl: './categorydetails.component.html',
  styleUrls: ['./categorydetails.component.css']
})
export class CategorydetailsComponent implements OnInit {
  selectedFile: any;
  imgURL: any;

  constructor(private client: FoodService, private http: HttpClient, private allcategory: HttpclientService) { }
  categoriesdetails!: any[];
  allcategories!: any;
  retrieveResonse: any;
  base64Data: any;
  retrievedImage: any;
  images: any=[];

  ngOnInit() {

    this.client.getcategorydetails().subscribe(
      response => this.handlecategoryResponse(response),
    );
    this.allcategory.onlycategoryname().subscribe(
      response => this.handleallcategoryResponse(response),
    );
  }
  handlecategoryResponse(response: any) {
    this.categoriesdetails = response;
  }
  handleallcategoryResponse(response: any) {
    this.allcategories = response;
    this.display();
  }

   display() {
      this.http.get('http://localhost:8080/categorypic')
        .subscribe(
          res => {
            this.images=res;

            // for(let i of  res)
            // this.retrieveResonse = res;
            // this.base64Data = this.retrieveResonse.categorypicture
           //  this.retrievedImage =  'data:image/jpeg;base64,' + this.base64Data;
           
     //console.log(res);
          });
          
        
  }

}

