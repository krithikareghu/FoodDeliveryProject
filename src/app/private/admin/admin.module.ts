import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { RouterModule } from '@angular/router';
import { CategorydetailsComponent } from './categorydetails/categorydetails.component';

import { SharedModule } from './../../shared/shared.module';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { AllrestaurantsComponent } from './allrestaurants/allrestaurants.component';
import { ItemsComponent } from './items/items.component';

@NgModule({
  declarations: [
    AdminComponent,
    CategorydetailsComponent,
    UserdetailsComponent,
    AllrestaurantsComponent,
    ItemsComponent
  ],
  imports: [
 

  CommonModule,RouterModule,SharedModule
  ],
  exports:[
   AdminComponent
  ]
})
export class AdminModule { }
