 import { NgModule } from '@angular/core';
 import { RouterModule, Routes } from '@angular/router';
import { LoginnavComponent } from './navigation/loginnav/loginnav.component';

 const routes: Routes = [
     {
        //  path:"home/addrestaurants",component:AddrestaurantComponent,
     },
    {
      path:"home/addaddress",component:LoginnavComponent
    }]


 @NgModule({
      imports: [RouterModule.forChild(routes)],
      exports: [RouterModule]
    })
      export class SharedRoutingModule { }