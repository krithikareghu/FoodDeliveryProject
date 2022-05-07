import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class JwtClientService {

  constructor(private http:HttpClient) { }
  public generatetoken(request: any){
    this.http.post("localhost:8080/authenticate",request)
  }
  public validate(token: string){
    let tokenstr='Bearer '+token;
    const headers=new HttpHeaders().set("Authorization",tokenstr);
    return this.http.get("localhost:8080/",{headers,responseType:'text' as 'json'})


  }
}
