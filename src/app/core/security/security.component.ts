import { Component, OnInit } from '@angular/core';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {

  constructor(private jwtservice:JwtClientService) { }

  ngOnInit(): void {
  }
  // public gettoken(request: any){
  //   let res=this.jwtservice.generatetoken(request);
  //   // res.subscribe((data: any)=>console.log(data))

  // }


}
