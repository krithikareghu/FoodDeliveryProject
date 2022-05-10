import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Userlogin } from 'src/app/shared/model/userlogin';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';


@Injectable({
  providedIn: 'root'
})
export class UserloginService {
  private baseurl = "http://localhost:8080/authenticate"
  constructor(private http: HttpClient, private auth: AuthenticationService) { }

  requestheader = new HttpHeaders(
    {
      "No-Auth": "True"
    }
  )

  login(userlogin: Userlogin): Observable<object> {

    return this.http.post(`${this.baseurl}`, userlogin, { headers: this.requestheader });

  }
  public roleMatch(allowedRoles: any): boolean {
    let isMatch = false;
    const userRoles: any = this.auth.getroles();

    if (userRoles != null && userRoles) {

      for (let i = 0; i < userRoles.length; i++) {

        for (let j = 0; j < allowedRoles.length; j++) {
          if (userRoles[i].rolename == allowedRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }

    return false;
  }
  public foradmin(){
   return this.http.get("http://localhost:8080/forAdmin",{responseType:'text'});
  }
}

