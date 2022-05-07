import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategorydetailsComponent } from './categorydetails/categorydetails.component';


const routes: Routes = 
[{
  path:"admin/categorydetails",component:CategorydetailsComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
