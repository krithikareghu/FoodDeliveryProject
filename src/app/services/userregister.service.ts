import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Userregister } from './../model/userregister';
import { Observable } from 'rxjs';

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
