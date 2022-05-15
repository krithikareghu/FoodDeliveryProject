import { Foodcategory } from "./foodcategory";

export class Cart {
    items:any;
    quantity:number=1;
    price!:number;
    getprice(){
        return this.price*this.quantity;
    }
    gettotalprice(){
        let totalprice=0;
      
    }

}
