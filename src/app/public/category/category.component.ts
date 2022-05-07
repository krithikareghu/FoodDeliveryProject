import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories!: any[];
  constructor(private http: HttpclientService) { }

  ngOnInit() {
    this.http.getallcategories().subscribe(
      response => this.handlecategoryResponse(response),
    );
  }
  handlecategoryResponse(response: any) {
    this.categories = response;
  }

}
