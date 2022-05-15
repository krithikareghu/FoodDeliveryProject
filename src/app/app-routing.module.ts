
import { RouterModule, Routes } from '@angular/router';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { IndexComponent } from './profile/index/index.component';
import { LoginComponent } from './profile/login/login.component';
import { SignupComponent } from './profile/signup/signup.component';
import { AddaddressComponent } from './profile/addaddress/addaddress.component';
import { NgModule } from '@angular/core';
import { AdminComponent } from './private/admin/admin.component';
import { CategoryComponent } from './public/category/category.component';
import { AddrestaurantComponent } from './private/owner/addrestaurant/addrestaurant.component';
import { MenuComponent } from './public/menu/menu.component';
import { ForbiddenComponent } from './public/forbidden/forbidden/forbidden.component';
import { UserComponent } from './profile/user/user.component';
import { AuthGuard } from './core/auth/-auth.guard';
import { AddmenuComponent } from './private/owner/addmenu/addmenu.component';
import { RestaurantsComponent } from './public/restaurants/restaurants.component';
import { FooditemsComponent } from './public/fooditems/fooditems.component';
import { ItemComponent } from './public/item/item.component';

const routes: Routes = [

  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: IndexComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: "addaddress", component: AddaddressComponent, canActivate: [AuthGuard], data: { roles: ['user'] } },
  { path: "addrestaurant", component: AddrestaurantComponent },
  { path: "category", component: MenuComponent },
  { path: "admin/allusers", component: AdminComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: "home/allcategories", component: CategoryComponent },
  { path: "forbidden", component: ForbiddenComponent },
  { path: "home/user", component: UserComponent },
  { path: "owner/addmenu", component: AddmenuComponent },
  { path: 'home/user', component: UserComponent },
  { path: "search/:searchItem", component: IndexComponent },
  { path: 'category/:id', component: MenuComponent },
  { path: 'restaurants/:categoryid', component: RestaurantsComponent },
  { path: 'restaurants/:categoryid/items/:restaurantname', component: FooditemsComponent },
  { path: 'cart', component: ItemComponent },
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
