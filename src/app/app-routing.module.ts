import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { IndexComponent } from './profile/index/index.component';
import { LoginComponent } from './profile/login/login.component';
import { SignupComponent } from './profile/signup/signup.component';
import { AddaddressComponent } from './profile/addaddress/addaddress.component';
import { AddrestaurantComponent } from './core/restaurant/addrestaurant/addrestaurant.component';
const routes: Routes = [
  
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path:'home',component:IndexComponent},
  {path:'home/login',component:LoginComponent},
  {path:'home/signup',component:SignupComponent},
  {path:"home/addaddress", component:AddaddressComponent},
  //{path:"home/addastaurants",component:AddrestaurantComponent},
  {path:"**", component:PagenotfoundComponent},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],


exports: [RouterModule]
})
export class AppRoutingModule { }
