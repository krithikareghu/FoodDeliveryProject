import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Userlogin } from 'src/app/model/userlogin';
import { UserloginService } from './../../services/userlogin.service';

import {  Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userlogin: Userlogin = new Userlogin();
  

  // loginForm!: FormGroup;
  // loading = false;
  // submitted = false;
  // returnUrl!: string;

  
  constructor(
    private userloginservice:UserloginService,
      // private formBuilder: FormBuilder,
      // private route: ActivatedRoute,
       private router: Router,
    //   private authenticationService: AuthenticationService,
    //   private alertService: AlertService
  ) {
    //   // redirect to home if already logged in
    //   if (this.authenticationService.currentUserValue) { 
    //       this.router.navigate(['/']);
    //   }
  }

  ngOnInit() {
    //   this.loginForm = this.formBuilder.group({
    //       username: ['', Validators.required],
    //       password: ['', Validators.required]
  
}

observer = {
  next:()  => this.router.navigate(['/home']),
  error: (error: any) =>alert("please enter proper credentials to login"),

};

login() {
  console.log(this.userlogin)
  this.userloginservice.login(this.userlogin)
      .subscribe(this.observer);
}
}































// function setFormMessage(formElement:any, type, message) {
//   const messageElement = formElement.querySelector(".form__message");
//   messageElement.textContent = message;
//   messageElement.classList.remove("form__message--success", "form__message--error");
//   messageElement.classList.add(`form__message--${type}`);
// }


// function setInputError(inputElement, message) {
//   inputElement.classList.add("form__input--error");
//   inputElement.parentElement.querySelector(".form__input-error-message").textContent = message;
// }

// function clearInputError(inputElement) {
//   inputElement.classList.remove("form__input--error");
//   inputElement.parentElement.querySelector(".form__input-error-message").textContent = "";
// }
// function home() {
//   window.location.href = "index.html";
// }

// document.addEventListener("DOMContentLoaded", () => {

//   const loginForm = document.querySelector("#login");
//   const createAccountForm = document.querySelector("#createAccount");

//   document.querySelector("#linkCreateAccount").addEventListener("click", e => {
//       e.preventDefault();
//       loginForm.classList.add("form--hidden");
//       createAccountForm.classList.remove("form--hidden")
//   });
//   document.querySelector("#linkLogin").addEventListener("click", e => {
//       e.preventDefault();
//       loginForm.classList.remove("form--hidden");
//       createAccountForm.classList.add("form--hidden")
//   });


//   loginForm.addEventListener("submit", e => {
//       e.preventDefault();
//       // setFormMessage(loginForm, "error", "Invalid username or password ");
//   })
//   // createAccountForm.addEventListener("submit", e => {
//   //     e.preventDefault();

//   // });


//   document.querySelectorAll(".form__input").forEach(inputElement => {
//       inputElement.addEventListener("blur", e => {
//           var input = e.target.value;
//           if (e.target.id === "signupUsername" && e.target.value.length < 5) {
//               setInputError(inputElement, "Username must be at least  6 characters in length");
//           }
//           else if (e.target.id == "signupEmail" && e.target.value.length < 9) {
//               setInputError(inputElement, "Email must be at least 10 characters in length");
//           }
//           else if (e.target.id == "signupEmail" && !input.match("@gmail.com")) {
//               setInputError(inputElement, "Enter the correct Email");
//           }
//       });
//       inputElement.addEventListener("input", e => {
//           clearInputError(inputElement);
//       });


//       var password = document.getElementById("password");
//       var confirmpassword = document.getElementById("confirmpassword");
  
//       confirmpassword.addEventListener("blur", () => {
//           if (password.value !== confirmpassword.value) {
//               setInputError(confirmpassword, "password mismatch")
//           }
//       });

//       password.addEventListener("blur", () => {
//           if (password.value.length <= 4)
//               setInputError(password, "password should be atleast 5 characters")

//       });
//   });


// });



