import { Items } from "./items";
import { Restaurants } from "./restaurants";

export class Foodcategory {

        id!:number;
        categoryname!:String;
        
        categoryurl!:String;

        Restaurant!:{
                restaurantname:String,
                restaurantcontact:String,
        
        Items:{
                itemname: String; 
                itemprice: Number;
                itemurl: String;  
        }[],
       }[]
       
}
