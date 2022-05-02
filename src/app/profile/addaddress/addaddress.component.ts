import { Component, OnInit } from '@angular/core';
import { UserregisterService } from 'src/app/services/register/userregister.service';
import { Useraddress } from 'src/app/shared/model/useraddress';
import { UseraddressService } from '../../services/address/useraddress.service';

@Component({
  selector: 'app-addaddress',
  templateUrl: './addaddress.component.html',
  styleUrls: ['./addaddress.component.css']
})
export class AddaddressComponent implements OnInit {

  useraddress: Useraddress = new Useraddress();
  constructor(
    private useraddressService: UseraddressService
  ) { }

  ngOnInit(): void {
  }

  observer = {
    next: () => alert("address added successfully"),
    error: (error: any) =>alert("please enter proper address"+error),

};

addaddress() {
    console.log(this.useraddress)
    this.useraddressService.addaddress(this.useraddress)
        .subscribe(this.observer);
}
}
