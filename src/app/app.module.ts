import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './profile/login/login.component';

import { IndexComponent } from './profile/index/index.component';
import { SignupComponent } from './profile/signup/signup.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { FormsModule } from '@angular/forms';
// import { UserserviceService } from './services/userservice.service';
import { HttpClientModule } from '@angular/common/http';
import { CoreModule } from './core/core.module';
import { AddaddressComponent } from './profile/addaddress/addaddress.component';
import { SharedModule } from './shared/shared.module';
//import {  authInterceptorProviders } from './helpers/authinterceptor.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    IndexComponent,
    SignupComponent,
    PagenotfoundComponent,
    AddaddressComponent,
  
  ],
  imports: [
  BrowserModule,
    AppRoutingModule,
    FormsModule, HttpClientModule,
    SharedModule,
    CoreModule,
   // AuthinterceptorInterceptor
  ],
//  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
