import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FoodService } from './../../../services/food/food.service';
import { Addcategory } from './../../../shared/model/addcategory';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { Router } from '@angular/router';
import { globalVars } from 'src/app/shared/url.model';

@Component({
  selector: 'app-addcategories',
  templateUrl: './addcategories.component.html',
  styleUrls: ['./addcategories.component.css']
})
export class AddcategoriesComponent implements OnInit {

  constructor(private httpClient: HttpClient, private client: HttpclientService,private router:Router,    private categoryservice: FoodService) { }
baseurl=globalVars.backendAPI
  addcategory: Addcategory = new Addcategory();
  ngOnInit() {
   // this.client.onlycategoryname().subscribe((response:any)=>this.handlecategoryResponse(response),)
    this.client.getallcategories().subscribe(
      response => this.handlecategoryResponse(response),
    );

  }
  categories!: any[];
  handlecategoryResponse(response: any) {
    this.categories = response;
  }


  public selectedFile!: any;
  public event1!: any;
  imgURL: any;
  receivedImageData: any;
  base64Data: any;
  convertedImage: any;

  public onFileChanged(event: any) {
    console.log(event);
    this.selectedFile = event.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };

  }

  observer = {
    next: (res: any) => {
      console.log(res);
      this.receivedImageData = res;
      this.base64Data = this.receivedImageData.pic;
      this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data;
      alert("category added successfully");
      this.router.navigate(['/owner/addmenu'])
    },
    error: (err: any) => console.log('Error Occured during saving: ' + err.value)

  }
  onUpload() {
    const uploadData = new FormData();
    uploadData.append('myFile', this.selectedFile)
    // this.selectedFile.name);
    const categoryname = this.addcategory.categoryname;
    const params = new HttpParams()
      .append('category', categoryname)
    console.log(this.addcategory)
    return this.httpClient.post(this.baseurl+"/admin/addcategory", uploadData, {
      params: params
    })
      .subscribe(this.observer)

  }




}



