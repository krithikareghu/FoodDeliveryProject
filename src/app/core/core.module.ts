import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SecurityComponent } from './security/security.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    SecurityComponent,
  
  ],
  imports: [
  CommonModule,
    RouterModule,SharedModule,FormsModule
  ],
  exports:[
  

  ]
})
export class CoreModule { }
