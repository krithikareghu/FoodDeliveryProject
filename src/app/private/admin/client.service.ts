import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { globalVars } from 'src/app/shared/url.model';



@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private client:HttpClient) { }
  baseurl=globalVars.backendAPI;
  getallusers(){
    return this.client.get(this.baseurl+"/admin/allusers");
  }
  getallrestaurants(){
    return this.client.get(this.baseurl+"/admin/allrestaurantdetails");
  }
  getallitems(){
    return this.client.get(this.baseurl+'/admin/allitems')
  } 
  getallpics(){
    return this.client.get(this.baseurl+'/admin/itempics')
  }
  removeitem(itemid:any){
    return this.client.delete(this.baseurl+'/admin/deleteitems/'+itemid)
  }
  removerestaurant(restauarntname:any){
    console.log(restauarntname)
    return this.client.delete(this.baseurl+'/admin/deleterestaurant/'+restauarntname)
  }
  removeuser(userid:any){
    return this.client.delete(this.baseurl+'/admin/deleteuser/'+userid)

  }
  removecategory(categoryid:any)
  {
    return this.client.delete(this.baseurl+"/admin/deletecategory/"+categoryid)
  }

}
