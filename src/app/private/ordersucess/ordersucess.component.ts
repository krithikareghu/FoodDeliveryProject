import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-ordersucess',
  templateUrl: './ordersucess.component.html',
  styleUrls: ['./ordersucess.component.css']
})
export class OrdersucessComponent implements OnInit {

  constructor() { }

  @Input()cartObj:any;
  ngOnInit(): void {
  }

}
