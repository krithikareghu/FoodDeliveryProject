import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { ActivatedRoute,ParamMap } from '@angular/router';

@Component({
  selector: 'app-fooditems',
  templateUrl: './fooditems.component.html',
  styleUrls: ['./fooditems.component.css']
})
export class FooditemsComponent implements OnInit {

  constructor(private helper:HttpclientService,private route:ActivatedRoute) { }
restaurantname:any;
  allitems!:any;
  itempic:any;
  rating:any;
  ngOnInit(): void {

    this.route.paramMap.subscribe((params: ParamMap) => {
      this.restaurantname = params.get('restaurantname')
    })
this.helper.getitems(this.restaurantname).subscribe(response=>
  this.allitems=response)
  this.helper.getitempic(this.restaurantname).subscribe(response=>{
    this.itempic=response;
    this.rating = Array.from({ length: 20 }, () => (Math.random() * (9.00 - 2.00 + 2.00) + 1.00).toFixed(1));

    console.log(this.allitems);
  })

  }

}
