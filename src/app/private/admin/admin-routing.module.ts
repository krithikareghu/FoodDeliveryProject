import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from 'src/app/core/auth/-auth.guard';
import { AllrestaurantsComponent } from './allrestaurants/allrestaurants.component';
import { CategorydetailsComponent } from './categorydetails/categorydetails.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { ItemsComponent } from './items/items.component';


const routes: Routes = 
[{path:"categorydetails",component:CategorydetailsComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] }},
{path:'allusers',component:UserdetailsComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] }},
{path:'allrestaurants',component:AllrestaurantsComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] }},
{path:'allitems',component:ItemsComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] }}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],

exports: [RouterModule]
})
export class AdminRoutingModule { }
