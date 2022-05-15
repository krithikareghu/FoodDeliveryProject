import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navigation/navbar/navbar.component';
import { LoginnavComponent } from './navigation/loginnav/loginnav.component';
import { RouterModule } from '@angular/router';
import { AdminnavComponent } from './navigation/adminnav/adminnav.component';
import { MenuComponent } from '../public/menu/menu.component';
import { SearchpipePipe } from './pipes/searchpipe.pipe';
import { MatToolbarModule } from '@angular/material/toolbar';

@NgModule({
  declarations: [
    NavbarComponent,
    LoginnavComponent,
    AdminnavComponent,
    SearchpipePipe,
    
  ],
  imports: [
    CommonModule,
    RouterModule,
    MatToolbarModule
  ],
  exports: [
    NavbarComponent, LoginnavComponent, AdminnavComponent
  ]
})
export class SharedModule { }

