import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { UserloginService } from 'src/app/services/login/userlogin.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private auth:AuthenticationService,private router:Router,private userservice:UserloginService){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
 if(this.auth.getToken()!=null)
 {
   const role=  route.data["roles"] as Array<string>
   if(role){
     const match=this.userservice.roleMatch(role);
     if(match){
       return true;
     }
     else{
       this.router.navigate(['/forbidden']);
       return false;
     }

   }
 }
 this.router.navigate(['/login']);
 return false;

  }
  
}
