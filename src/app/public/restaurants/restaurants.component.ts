import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { Router, ActivatedRoute ,ParamMap} from '@angular/router';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

  constructor(private http:HttpclientService,private route:ActivatedRoute) { }
  categoryid!:any;
allrestaurant!:any;

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.categoryid = params.get('categoryid')
    })

    this.http.getrestaurants(this.categoryid).subscribe(response=>{
      this.allrestaurant=response;
    })
  }

}
