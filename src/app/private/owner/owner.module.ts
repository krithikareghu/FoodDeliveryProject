import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddcategoriesComponent } from './addcategories/addcategories.component';
import { AddrestaurantComponent } from './addrestaurant/addrestaurant.component';
import { AddmenuComponent } from './addmenu/addmenu.component';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { OwnerRoutingModule } from './owner-routing.module';
import { AppModule } from 'src/app/app.module';
import { CategoryComponent } from 'src/app/public/category/category.component';



@NgModule({
  declarations: [
    AddcategoriesComponent,
    AddrestaurantComponent,
    AddmenuComponent
  ],
  imports: [
    CommonModule,FormsModule,SharedModule
  ],
  exports:[
    AddrestaurantComponent,OwnerRoutingModule
  ]
})
export class OwnerModule { }
