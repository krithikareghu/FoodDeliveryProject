import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  images: any=[];
  allcategories!: any
  value!:any;
  constructor(private http: HttpClient,private allcategory: HttpclientService) { }

  ngOnInit(): void {
    
    this.allcategory.onlycategoryname().subscribe(
      response => this.handleallcategoryResponse(response),
    );
    this.display();
  }
  handleallcategoryResponse(response: any) {
    this.allcategories = response;
    this.display();
  }

  display() {
    this.http.get('http://localhost:8080/categorypic')
      .subscribe(
        async res => {
         await (this.images=res);
          
        });   
    this.value= Array.from({length: 20},()=>(Math.random() * (9.00 - 2.00 + 2.00) + 1.00).toFixed(1));
 
      

  }
}// this.value= Array.from({length: 20}, () =>(Math.random() * 10));
// this.value= Array.from({length: 20},()=>Math.random() * (10.0 - 1.0 + 1.00) + 1.00);