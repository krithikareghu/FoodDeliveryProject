
import { RouterModule, Routes } from '@angular/router';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { IndexComponent } from './profile/index/index.component';
import { LoginComponent } from './profile/login/login.component';
import { SignupComponent } from './profile/signup/signup.component';
import { AddaddressComponent } from './profile/addaddress/addaddress.component';
import { AddrestaurantComponent } from './private/owner/addrestaurant/addrestaurant.component';
import { NgModule } from '@angular/core';
import { AdminComponent } from './private/admin/admin.component';
import { CategoryComponent } from './public/category/category.component';

const routes: Routes = [

  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: IndexComponent },
  { path: 'home/login', component: LoginComponent },
  { path: 'home/signup', component: SignupComponent },
  { path: "home/addaddress", component: AddaddressComponent },
  // ]{ path: "home/addrestaurant", component: AddrestaurantComponent },
  { path: "admin/allusers", component: AdminComponent },
  { path: "home/allcategories", component: CategoryComponent },
  { path: "admin", loadChildren: () => (import('./private/admin/admin.module')).then(mod => mod.AdminModule) },
  { path: "admin", loadChildren: () => (import('./core/core.module')).then(mod => mod.CoreModule) },
  { path: "home", loadChildren: () => (import('./shared/shared.module')).then(mod => mod.SharedModule) },
  { path: "**", component: PagenotfoundComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],


  exports: [RouterModule]
})
export class AppRoutingModule { }
