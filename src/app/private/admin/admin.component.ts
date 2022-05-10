import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { UserloginService } from './../../services/login/userlogin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  message:any;
  constructor(private client: HttpclientService,private userservice:UserloginService) { }
  customers!: any[];
 
  ngOnInit() {
    this.client.getcustomerdetails().subscribe(
      response => this.handlecustomerResponse(response),
     
    ); 
    this.forAdmin();  
  }
  handlecustomerResponse(response: any) {
    this.customers = response;
  }
  forAdmin(){
    this.userservice.foradmin().subscribe((response)=>{
      this.message=response;
      console.log(response)
    },
    (error)=>{
      console.log(error);
    }
    )
  }
 


}

