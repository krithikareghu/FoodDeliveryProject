import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SecurityComponent } from './security/security.component';
import { AddrestaurantComponent } from '../private/owner/addrestaurant/addrestaurant.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    SecurityComponent,
    AddrestaurantComponent,
  ],
  imports: [
  CommonModule,
    RouterModule,SharedModule
  ],
  exports:[
    AddrestaurantComponent

  ]
})
export class CoreModule { }
