import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpclientService } from 'src/app/services/httpclient.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient,private helper:HttpclientService) { }

  public setRoles(roles: []) {
    localStorage.setItem('roles', JSON.stringify(roles))
  }

  public getroles() {
    return JSON.parse(localStorage.getItem('roles') || null || '{}')
  }

  public setToken(jwtToken: string) {
    localStorage.setItem("jwtToken", jwtToken);
   

  }
  public getToken() {
    return localStorage.getItem("jwtToken")
  }
  public setuserid(userid:string){
    localStorage.setItem("userID",userid)
  }

  public clear() {
    localStorage.clear();
  }

  public isUserLoggedIn() {
   
    return this.getroles() && this.getToken();
  }
  public getuserid(){
    return localStorage.getItem("userID");
  }




}