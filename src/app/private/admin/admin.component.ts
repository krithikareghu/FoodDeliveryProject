import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private http: HttpclientService) { }
  customers!: any[];
 
  ngOnInit() {
    this.http.getcustomerdetails().subscribe(
      response => this.handlecustomerResponse(response),
    );
   
  }


  handlecustomerResponse(response: any) {
    this.customers = response;
  }
 


}

