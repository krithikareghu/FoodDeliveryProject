import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './profile/login/login.component';
import { IndexComponent } from './profile/index/index.component';
import { SignupComponent } from './profile/signup/signup.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CoreModule } from './core/core.module';
import { AddaddressComponent } from './profile/addaddress/addaddress.component';
import { SharedModule } from './shared/shared.module';
import { UserloginService } from './services/login/userlogin.service';
import { UserComponent } from './profile/user/user.component';
import { MenuComponent } from './public/menu/menu.component';
import { CategoryComponent } from './public/category/category.component';
import { OwnerModule } from './private/owner/owner.module';
import { OwnerRoutingModule } from './private/owner/owner-routing.module';
import { AdminRoutingModule } from './private/admin/admin-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatGridListModule } from '@angular/material/grid-list';
import { ForbiddenComponent } from './public/forbidden/forbidden/forbidden.component'
import { AuthGuard } from './core/auth/-auth.guard';
import { AuthinterceptorInterceptor } from './core/auth/helpers/authinterceptor.interceptor';
import { SearchpipePipe } from './shared/pipes/searchpipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    IndexComponent,
    SignupComponent,
    PagenotfoundComponent,
    AddaddressComponent,
    UserComponent,
    MenuComponent,
    CategoryComponent,
    ForbiddenComponent,


  ],
  imports: [
    BrowserModule, OwnerRoutingModule,
    AdminRoutingModule,
    AppRoutingModule,
    FormsModule, HttpClientModule,
    SharedModule,
  
    CoreModule, OwnerModule, BrowserAnimationsModule, MatButtonModule, MatGridListModule
  ],
  providers: [UserloginService, AuthGuard, 
    { provide: HTTP_INTERCEPTORS,
     useClass: AuthinterceptorInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
