import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { RouterModule } from '@angular/router';
import { CategorydetailsComponent } from './categorydetails/categorydetails.component';

import { SharedModule } from './../../shared/shared.module';

@NgModule({
  declarations: [
    AdminComponent,
    CategorydetailsComponent
  ],
  imports: [
 

  CommonModule,RouterModule,SharedModule
  ],
  exports:[
   AdminComponent
  ]
})
export class AdminModule { }
