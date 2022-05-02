import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Useraddress } from './../model/useraddress';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UseraddressService {

  constructor(private http:HttpClient) { }


  private baseurl="http://localhost:8080/addaddress"
  
  addaddress(useraddress:Useraddress):Observable<object>{
    console.log(useraddress);
    return this.http.put(`${this.baseurl}`,useraddress);

  }
}

