import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart/cart.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  constructor(private cart:CartService) { 
    
  }
  cartitems:any;
  itemselected!:any;
  items!:any;
  totalcost!:any;

  ngOnInit(): void {
    //this.itemselected=JSON.stringify(this.cart.getitems());
    this.items=this.cart.getitems()
    console.log(this.items)
  this.totalcost=this.cart.gettotalcost();
  console.log(this.totalcost)


  }

 
  display(){

  
  }

}
