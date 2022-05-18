import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navigation/navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { AdminnavComponent } from './navigation/adminnav/adminnav.component';
import { SearchpipePipe } from './pipes/searchpipe.pipe';
import { MatToolbarModule } from '@angular/material/toolbar';

@NgModule({
  declarations: [
    NavbarComponent,
    AdminnavComponent,
    SearchpipePipe,
    
  ],
  imports: [
  
  CommonModule,
    RouterModule,
    MatToolbarModule
  ],
  exports: [
    NavbarComponent, AdminnavComponent
  ]
})
export class SharedModule { }

