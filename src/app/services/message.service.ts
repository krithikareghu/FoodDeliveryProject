import { Injectable } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private toast:NgToastService ) { }

  loginSuccess() {
    this.toast.success({detail:"Success",summary:"Loggedin successfully", duration:2000})
  }

  logoutSuccess() {
    this.toast.success({detail:"Success",summary:"Logged out",duration:2000})
  }

  registerSuccess() {
    this.toast.success({detail:"Success",summary:"Registered successfully" ,position:"tr",duration:2000})
  }

  pleaseLoginMessage() {
    this.toast.error({summary:"Please log in to continue", position:"tr",duration:2000})
  }

  invalidEmailPasswordMessage() {
    this.toast.error({detail:"Success",summary:"Phonenumber or password incorrect",position:"tr",duration:2000})
  }

  loginAsAdmin() {
    this.toast.success({detail:"Success",summary:"Logged in as Admin",position:"tr",duration:2000})
   
  }

  loginAsUser() {
    this.toast.error({summary:"Login as user to continue",position:"tr",duration:2000})
   
  }
  loginAsOwner() {
    this.toast.success({detail:"Success",summary:"Logged in as owner",position:"tr",duration:2000})
   
  }

  emailExistAlready() {
    this.toast.error({detail:"Success",summary:"Credentials already exists ",position:"tr",duration:2000})
   
  }
  addtocart(){
    this.toast.success({detail:"Success",summary:"Added to cart",duration:2000})
  }

  failedtoaddtocart(){
    this.toast.error({detail:"error",summary: "Try again",position:"tr",duration:2000})
  }
  itemalreadyexists(){
    this.toast.warning({summary: "Already added to cart",position:"tr",duration:2000})

  }
 cartempty(){
  this.toast.warning({summary: "Cart is empty",position:"tr",duration:2000})
   
 }
 warn(message:any){
  this.toast.warning({summary:message,position:"tr",duration:2000})
 }
 ordersucess(message:any){
  this.toast.success({summary:message,duration:2000})
 }
  }

