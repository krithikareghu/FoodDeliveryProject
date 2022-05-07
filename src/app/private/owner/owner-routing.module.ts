import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddcategoriesComponent } from './addcategories/addcategories.component';
import { AddrestaurantComponent } from './addrestaurant/addrestaurant.component';

const routes: Routes = [
    {
        path:"owner/addrestaurants",component:AddrestaurantComponent,
    },{
      path:"owner/addcategory",component:AddcategoriesComponent
    }]


@NgModule({
     imports: [RouterModule.forChild(routes)],
     exports: [RouterModule]
   })
     export class OwnerRoutingModule { }