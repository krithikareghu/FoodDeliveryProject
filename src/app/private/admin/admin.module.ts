import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { RouterModule } from '@angular/router';
import { CategorydetailsComponent } from './categorydetails/categorydetails.component';



@NgModule({
  declarations: [
    AdminComponent,
    CategorydetailsComponent
  ],
  imports: [
  
  CommonModule,RouterModule
  ],
  exports:[
   AdminComponent
  ]
})
export class AdminModule { }
