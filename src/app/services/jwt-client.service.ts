import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {

  constructor(private http:HttpClient) { }

//   generatetoken(request:any){

//     this.http.post("localhost:8080/authenticate",request,{responseType:'text' as 'json'})
//   }

// welcome(token:any){
//   let wholetoken="bearer "+token;
//   const headers=new HttpHeaders().set("Authorisation",wholetoken)
//   return this.http.get("localhost:8080"),{headers,responseType:'text' as 'json'};
// }
  
}
