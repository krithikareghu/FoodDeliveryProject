import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HttpclientService } from 'src/app/services/httpclient.service';
import { Additems } from 'src/app/shared/model/additems';
import { globalVars } from 'src/app/shared/url.model';

@Component({
  selector: 'app-addmenu',
  templateUrl: './addmenu.component.html',
  styleUrls: ['./addmenu.component.css']
})
export class AddmenuComponent implements OnInit {

  baseurl= globalVars.backendAPI
  constructor(private httpClient: HttpClient, private client: HttpclientService,
   ) { }
   additems: Additems = new Additems();

  ngOnInit() {
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
  
    console.log(Itemname)

    const params = new HttpParams()
      .append('itemname', Itemname)
      .append('itemprice',Itemprice)
    
    return this.httpClient.post(this.baseurl+"/admin/additem", uploadData, {
      params: params
    })
      .subscribe(this.observer)

  }




}


