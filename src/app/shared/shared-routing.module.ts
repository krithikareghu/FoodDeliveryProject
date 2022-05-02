 import { NgModule } from '@angular/core';
 import { RouterModule, Routes } from '@angular/router';
import { AddrestaurantComponent } from '../core/restaurant/addrestaurant/addrestaurant.component';

 const routes: Routes = [
     {
         path:"addrestaurants",component:AddrestaurantComponent
     }]


@NgModule({
     imports: [RouterModule.forChild(routes)],
     exports: [RouterModule]
   })
      export class SharedRoutingModule { }