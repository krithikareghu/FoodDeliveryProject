import { Component, OnInit } from '@angular/core';
import { UserregisterService } from './../../services/register/userregister.service';
import { Userregister } from 'src/app/shared/model/userregister';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private http:HttpClient) { }
  private baseurl="localhost:8080/getuserdetails"
  ngOnInit() {
  }
  getuserdetails(user:Userregister):Observable<object>{
   
    return this.http.get(`${this.baseurl}`+user.phonenumber);

  }

}
