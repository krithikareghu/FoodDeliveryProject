import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navigation/navbar/navbar.component';
import { LoginnavComponent } from './navigation/loginnav/loginnav.component';
import { RouterModule } from '@angular/router';
import { AdminnavComponent } from './navigation/adminnav/adminnav.component';
@NgModule({
  declarations: [
    NavbarComponent,
    LoginnavComponent,
    AdminnavComponent,
    
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    NavbarComponent, LoginnavComponent, AdminnavComponent
  ]
})
export class SharedModule { }

