import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from 'src/app/profile/login/login.component';
import { AddcategoriesComponent } from './addcategories/addcategories.component';
import { AddrestaurantComponent } from './addrestaurant/addrestaurant.component';
import { RestaurantloginComponent } from './restaurantlogin/restaurantlogin.component';
import { CategorydetailsComponent } from './../admin/categorydetails/categorydetails.component';

const routes: Routes = [
    {
        path:"owner/addrestaurants",component:AddrestaurantComponent,
    },{
      path:"owner/addcategory",component:AddcategoriesComponent
    },
  {path:"loginrestaurant",component:RestaurantloginComponent},
{
  path:"categorydetails",component:CategorydetailsComponent
},
]


@NgModule({
     imports: [RouterModule.forChild(routes)],
  

exports: [RouterModule]
   })
     export class OwnerRoutingModule { }