import { Component, OnInit } from '@angular/core';
import { JwtClientService } from './../../services/jwt/jwt-client.service';
import { Userlogin } from './../../shared/model/userlogin';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {

  constructor(private jwtClientService:JwtClientService,private userlogin:Userlogin) { }
  
request=this.userlogin;

  ngOnInit(): void {
  }
  public getaccesstoken(request: any){
    let resp=this.jwtClientService.generatetoken(request)
    

  }


}
