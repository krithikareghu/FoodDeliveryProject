import { Injectable } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private toast:NgToastService ) { }

  loginSuccess() {
    this.toast.success({detail:"Success",summary:"Loggedin successfully", position:"tr",duration:5000})
    // this.toast.success("Logged in successfully");
  }

  logoutSuccess() {
    this.toast.error({detail:"Success",summary:"Logged out",position:"tr",duration:5000})
    // this.toast.error("Logged out")
  }

  registerSuccess() {
    this.toast.success({detail:"Success",summary:"Registered successfully" ,position:"tr",duration:5000})
    //this.toast.success("Registered Successfully")
  }

  normalLogoutMessage() {
    this.toast.error({detail:"Success",summary:"This is Success",position:"tr",duration:4000})
    //this.toast.error("Session expired")
  }

  pleaseLoginMessage() {
    this.toast.error({summary:"Please log in to continue", position:"tr",duration:4000})
   // this.toast.info("Please login to access the page")
  }

  invalidEmailPasswordMessage() {
    this.toast.error({detail:"Success",summary:"This is Success",position:"tr",duration:4000})
    //this.toast.error("Invalid email or password")
  }

  loginAsAdmin() {
    this.toast.success({detail:"Success",summary:"This is Success",position:"tr",duration:4000})
    // this.toast.info("Login as Admin to access the page", undefined, {
    //   timeOut:3000
    // })
  }

  emailExistAlready() {
    this.toast.error({detail:"Success",summary:"Credentials already exists ",position:"tr",duration:4000})
    // this.toast.error("Email already exisits!", undefined, {
    //   timeOut:3000
    // })
  }

 
  }

