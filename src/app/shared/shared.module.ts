import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navigation/navbar/navbar.component';
import { LoginnavComponent } from './navigation/loginnav/loginnav.component';
import { RouterModule } from '@angular/router';
import { CoreModule } from '../core/core.module';
@NgModule({
  declarations: [
    NavbarComponent,
    LoginnavComponent
  ],
  imports: [
 
CommonModule,
  RouterModule,CoreModule
  ],
  exports:[
    NavbarComponent,LoginnavComponent
  ]
})
export class SharedModule { }

