import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Userlogin } from '../../shared/model/userlogin';

@Injectable({
  providedIn: 'root'
})
export class UserloginService {
  private baseurl="http://localhost:8080/login"
  constructor(private http:HttpClient) { }

  login(userlogin:Userlogin):Observable<object>{
    console.log(userlogin);
    return this.http.post(`${this.baseurl}`,userlogin);

  }
}
