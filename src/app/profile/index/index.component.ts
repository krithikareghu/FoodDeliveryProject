import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from 'src/app/services/food/food.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private auth:AuthenticationService,private router:Router,private food:FoodService,private route:ActivatedRoute) { }
categories!:any;
value!: any;
 

  ngOnInit() {

   
    this.route.params.subscribe(params=>{
      
      if(params['searchItem']){
        this.categories=this.food.getall().filter
        (category=>category.categoryname.toLowerCase().includes(params['searchItem'].toLowerCase));
      // console.log('searchItem')
      }
      else{
      this.categories = this.food.getall();
      }
     
   //this.categories= this.food.getall();
  })
  this.value = Array.from({ length: 20 }, () => (Math.random() * (9.00 - 2.00 + 2.00) + 1.00).toFixed(1));

}




  public isloggedin(){
  
    return this.auth.isUserLoggedIn();
  }
  public logout(){
     this.auth.clear();
     this.router.navigate(['home/login'])
  }

}
