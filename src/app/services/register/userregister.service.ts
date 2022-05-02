import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Userregister } from '../../shared/model/userregister';

@Injectable({
  providedIn: 'root'
})
export class UserregisterService {

  private baseurl="http://localhost:8080/register"
  constructor(private http:HttpClient) { }
 
  register(userregister:Userregister):Observable<object>{
    console.log(userregister);
    return this.http.post(`${this.baseurl}`,userregister);

  }
}
