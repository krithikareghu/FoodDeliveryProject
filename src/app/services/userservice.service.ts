// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class UserserviceService {

//   constructor() { }

//    setFormMessage(formElement:any, type:any, message:any) {
//       const messageElement = formElement.querySelector(".form__message");
//       messageElement.textContent = message;
//       messageElement.classList.remove("form__message--success", "form__message--error");
//       messageElement.classList.add(`form__message--${type}`);
//     }
    
    
//      setInputError(inputElement:any, message:any) {
//       inputElement.classList.add("form__input--error");
//       inputElement.parentElement.querySelector(".form__input-error-message").textContent = message;
//     }
    
//      clearInputError(inputElement:any) {
//       inputElement.classList.remove("form__input--error");
//       inputElement.parentElement.querySelector(".form__input-error-message").textContent = "";
//     }
//      home() {
//       window.location.href = "index.html";
//     }
    
//     document.addEventListener("DOMContentLoaded", () => {
    
//       const loginForm = document.querySelector("#login");
//       const createAccountForm = document.querySelector("#createAccount");
    
//       document.querySelector("#linkCreateAccount").addEventListener("click", e => {
//           e.preventDefault();
//           loginForm.classList.add("form--hidden");
//           createAccountForm.classList.remove("form--hidden")
//       });
//       document.querySelector("#linkLogin").addEventListener("click", e => {
//           e.preventDefault();
//           loginForm.classList.remove("form--hidden");
//           createAccountForm.classList.add("form--hidden")
//       });
    
    
//       loginForm.addEventListener("submit", e => {
//           e.preventDefault();
//           // setFormMessage(loginForm, "error", "Invalid username or password ");
//       })
//       // createAccountForm.addEventListener("submit", e => {
//       //     e.preventDefault();
    
//       // });
    
    
//       document.querySelectorAll(".form__input").forEach(inputElement => {
//           inputElement.addEventListener("blur", e => {
//               var input = e.target.value;
//               if (e.target.id === "signupUsername" && e.target.value.length < 5) {
//                   setInputError(inputElement, "Username must be at least  6 characters in length");
//               }
//               else if (e.target.id == "signupEmail" && e.target.value.length < 9) {
//                   setInputError(inputElement, "Email must be at least 10 characters in length");
//               }
//               else if (e.target.id == "signupEmail" && !input.match("@gmail.com")) {
//                   setInputError(inputElement, "Enter the correct Email");
//               }
//           });
//           inputElement.addEventListener("input", e => {
//               clearInputError(inputElement);
//           });
    
    
//           var password = document.getElementById("password");
//           var confirmpassword = document.getElementById("confirmpassword");
      
//           confirmpassword.addEventListener("blur", () => {
//               if (password.value !== confirmpassword.value) {
//                   setInputError(confirmpassword, "password mismatch")
//               }
//           });
    
//           password.addEventListener("blur", () => {
//               if (password.value.length <= 4)
//                   setInputError(password, "password should be atleast 5 characters")
    
//           });
//       });
    
    
//     });
    
// }
