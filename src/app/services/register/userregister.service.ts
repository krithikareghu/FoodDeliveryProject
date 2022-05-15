import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Userregister } from '../../shared/model/userregister';

@Injectable({
  providedIn: 'root'
})
export class UserregisterService {

  requestheader = new HttpHeaders(
    {
      "No-Auth": "True"
    }
  )

  private baseurl="http://localhost:8080/register"
  constructor(private http:HttpClient) { }
 
  register(userregister:Userregister):Observable<object>{
    console.log(userregister);
    return this.http.post(`${this.baseurl}`,userregister,{ headers: this.requestheader });

  }
}
