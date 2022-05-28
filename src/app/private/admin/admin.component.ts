import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { UserloginService } from './../../services/login/userlogin.service';
import { ClientService } from './client.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  message:any;
  constructor(private client: ClientService,private userservice:UserloginService) { }
  customers!: any[];
 
  ngOnInit() {
    this.client.getallusers().subscribe(
      response => this.handlecustomerResponse(response),
     
    ); 
  
  }
  handlecustomerResponse(response: any) {
    this.customers = response;
  }
  
  }
 




