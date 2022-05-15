import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient, HttpParams } from '@angular/common/http';
import { Useraddress } from '../../shared/model/useraddress';
import { AuthenticationService } from '../auth/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UseraddressService {

  constructor(private http:HttpClient,private auth:AuthenticationService) { }
    

  private baseurl="http://localhost:8080/addaddress"
  
  addaddress(useraddress:Useraddress):Observable<object>{

    const token=this.auth.getToken();
  const params=new HttpParams().append('jwttoken',token!)
    console.log(useraddress);
    return this.http.put(`${this.baseurl}`,useraddress,{params:params});

  }
}

