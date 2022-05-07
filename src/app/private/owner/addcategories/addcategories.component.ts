import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FoodService } from './../../../services/food/food.service';
import { Addcategory } from './../../../shared/model/addcategory';

@Component({
  selector: 'app-addcategories',
  templateUrl: './addcategories.component.html',
  styleUrls: ['./addcategories.component.css']
})
export class AddcategoriesComponent implements OnInit {

  constructor(private httpClient: HttpClient,private categoryservice:FoodService) { }

  addcategory:Addcategory=new Addcategory();
  ngOnInit(): void {

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
    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };

  }
  // This part is for uploading

  observer = {
    next: (res: any) => {
      console.log(res);
      this.receivedImageData = res;
      this.base64Data = this.receivedImageData.pic;
      this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data;
      console.log("hi");
      alert("category added successfully");
    },
    error: (err: any) => console.log('Error Occured during saving: ' + err.value)

  }
  onUpload() {
    const uploadData = new FormData();
    uploadData.append('myFile', this.selectedFile,this.selectedFile.name);
   const categoryname=this.addcategory.categoryname;
   const params = new HttpParams()
      .append('category', categoryname)
    console.log(this.addcategory)
    return this.httpClient.post("http://localhost:8080/addcategory",uploadData,{
      params:params
    })
    .subscribe(this.observer)

}




}



