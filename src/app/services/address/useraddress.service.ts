import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient, HttpParams } from '@angular/common/http';
import { Useraddress } from '../../shared/model/useraddress';
import { AuthenticationService } from '../auth/authentication.service';
import { globalVars } from 'src/app/shared/url.model';

@Injectable({
  providedIn: 'root'
})
export class UseraddressService {

  constructor(private http:HttpClient,private auth:AuthenticationService) { }
    

  private baseurl=globalVars.backendAPI+"/user/addaddress"
   userid=localStorage.getItem("userID")
  
  addaddress(useraddress:Useraddress):Observable<object>{
    return this.http.put(`${this.baseurl}/`+this.userid,useraddress);

  }
}

