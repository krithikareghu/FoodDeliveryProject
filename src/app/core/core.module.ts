import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SecurityComponent } from './security/security.component';
import { AddrestaurantComponent } from './restaurant/addrestaurant/addrestaurant.component';
import { AdditemsComponent } from './restaurant/additems/additems.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    SecurityComponent,
    AddrestaurantComponent,
    AdditemsComponent
  ],
  imports: [
  CommonModule,
    RouterModule,SharedModule
  ],
  exports:[
    AdditemsComponent,
    AddrestaurantComponent

  ]
})
export class CoreModule { }
