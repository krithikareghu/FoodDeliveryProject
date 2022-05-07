import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor( private httpClient: HttpClient) { }

  authenticate(phonenumber: string, password: string) {

    console.log(phonenumber);
    console.log(password);

    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(phonenumber + ':' + password) });

    return this.httpClient
    .post<any>("http://localhost:8080/authenticate", { phonenumber, password })
    .pipe(
     map(userData => {
        sessionStorage.setItem("phonenumber", phonenumber);
        let tokenStr = "Bearer " + userData.token;
        sessionStorage.setItem("token", tokenStr);
        return userData;
      })
    );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('phonenumber')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('phonenumber')
  }
}


