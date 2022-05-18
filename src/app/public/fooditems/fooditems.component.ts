import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { MessageService } from './../../services/message.service';

import { Cart } from 'src/app/shared/model/cart';
import { CartService } from 'src/app/services/cart/cart.service';


@Component({
  selector: 'app-fooditems',
  templateUrl: './fooditems.component.html',
  styleUrls: ['./fooditems.component.css']
})
export class FooditemsComponent implements OnInit {
  restaurantname: any;
  allitems!: any;
  itempic: any;
  rating: any;

  constructor(private helper: HttpclientService,private cart:CartService,private message:MessageService,
    private route: ActivatedRoute) { 
   
    }
//cartmodel:Cart=new Cart();

  ngOnInit(): void {

    this.route.paramMap.subscribe((params: ParamMap) => {
      this.restaurantname = params.get('restaurantname')
    })
    this.helper.getitems(this.restaurantname).subscribe(response =>
      this.allitems = response)
    this.helper.getitempic(this.restaurantname).subscribe(response => {
      this.itempic = response;
      this.rating = Array.from({ length: 20 }, () => (Math.random() * (9.00 - 2.00 + 2.00) + 1.00).toFixed(1));

    })
 
  
  }
  value:boolean=false;
 
  observer={
    next:()=>{
      this.value=true;
      this.message.addtocart();
    },
    error:()=>{

    

this.message.failedtoaddtocart();

    }

  }
  storeitem(item:any){
    console.log(item.itemname)
    
    this.cart.addCart(item)
  }


}
