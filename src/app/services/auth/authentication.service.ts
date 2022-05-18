import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpclientService } from 'src/app/services/httpclient.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient,private helper:HttpclientService) { }
userid:any;
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





  // authenticate(phonenumber: string, password: string) {

  //   console.log(phonenumber);
  //   console.log(password);

  //   // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(phonenumber + ':' + password) });

  //   return this.httpClient
  //   .post<any>("http://localhost:8080/authenticate", { phonenumber, password })
  //   .pipe(
  //    map(userData => {
  //       sessionStorage.setItem("phonenumber", phonenumber);
  //       let tokenStr = "Bearer " + userData.token;
  //       sessionStorage.setItem("token", tokenStr);
  //       return userData;
  //     })
  //   );
  // }

  // // isUserLoggedIn() {
  // //   let user = sessionStorage.getItem('phonenumber')
  // //   console.log(!(user === null))
  // //   return !(user === null)
  // // }

  // logOut() {
  //   sessionStorage.removeItem('phonenumber')
  // }
}


