import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { Additems } from 'src/app/shared/model/additems';

@Component({
  selector: 'app-addmenu',
  templateUrl: './addmenu.component.html',
  styleUrls: ['./addmenu.component.css']
})
export class AddmenuComponent implements OnInit {

  
  constructor(private httpClient: HttpClient, private client: HttpclientService,
   ) { }
   additems: Additems = new Additems();

  ngOnInit() {
   // this.client.onlycategoryname().subscribe(response=>this.handlecategoryResponse(response))
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
      console.log("hi");
      alert("item added successfully");
    },
    error: (err: any) => console.log('Error Occured during saving: ' + err.value)

  }
  onUpload() {
    const uploadData = new FormData();
    uploadData.append('myFile', this.selectedFile, this.selectedFile.name);
    const Itemname = this.additems.itemname;
    const Itemprice = this.additems.itemprice;
    const Itemdescription = this.additems.itemdescription;
    //this.additems.itempicture=uploadData;
    const Categoryname=this.additems.categoryname;
    //console.log(Categoryname.length);
    console.log(Itemname)

    const params = new HttpParams()
      .append('itemname', Itemname)
      .append('itemprice',Itemprice)
      .append('categoryname',Categoryname)
      console.log(Categoryname)

    return this.httpClient.post("http://localhost:8080/additem", uploadData, {
      params: params
    })
      .subscribe(this.observer)

  }




}


