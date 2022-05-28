import { Component, OnInit } from '@angular/core';
import { ClientService } from './../client.service';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(private client: ClientService,private router:Router) { }

  ngOnInit(): void {
    this.getallitems();

  }
  allitems!: any;
  observer = {
    next: (res: any) => {
      this.allitems = res;
    },
    error: (error: any) => {
      alert("something went wrong")
    }
  }
  itempic: any;
  picobserver = {
    next: (res: any) => {
      this.itempic = res;
      console.log(this.itempic)
    }

  }
  removeitem(itemid: any) {
    this.client.removeitem(itemid).subscribe(this.removeobserver)

  }
  removeobserver = {
    next: (res: any) => {
      this.allitems = res;


    }, error: () => {
      alert("Something went wrong")
    }
  }
  getallitems() {
    this.client.getallitems().subscribe(this.observer)
    this.client.getallpics().subscribe(this.picobserver)
  }
  additems(){
    this.router.navigate(['/owner/addmenu'])
  }

}
