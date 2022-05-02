import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Userregister } from 'src/app/model/userregister';
import { UserregisterService } from './../../services/userregister.service';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

    userregister: Userregister = new Userregister();

    //   registerForm!: FormGroup;
    //   loading = false;
    //   submitted = false;

    constructor(
        private registeruserservice: UserregisterService
        //   private formBuilder: FormBuilder,
        //   private router: Router,
        //   private authenticationService: AuthenticationService,
        //   private userService: UserService,
        //   private alertService: AlertService
    ) {
        //   // redirect to home if already logged in
        //   if (this.authenticationService.currentUserValue) { 
        //       this.router.navigate(['/']);
        //   }
    }

    ngOnInit() {
        //   this.registerForm = this.formBuilder.group({
        //       firstName: ['', Validators.required],
        //       lastName: ['', Validators.required],
        //       username: ['', Validators.required],
        //       password: ['', [Validators.required, Validators.minLength(6)]]
        //   });
    }

    observer = {
        next: (data: any) => alert("registered successfully"),
        error: (error: any) =>alert("please enter proper credentials to register"+error),

    };

    register() {
        console.log(this.userregister)
        this.registeruserservice.register(this.userregister)
            .subscribe(this.observer);
    }
    












    // convenience getter for easy access to form fields
    //   get f() { return this.registerForm.controls; }








    //   onSubmit() {
    //     this.submitted = true;

    //     // stop here if form is invalid
    //     if (this.registerForm.invalid) {
    //         return;
    //     }

    //     this.loading = true;
    //     this.userService.register(this.registerForm.value)
    //         .pipe(first())
    //         .subscribe(
    //             (data:any) => {
    //                 this.alertService.success('Registration successful', true);
    //                 this.router.navigate(['/login']);
    //             },
    //           (error: any) => {
    //                 this.alertService.error(error);
    //                 this.loading = false;
    //             });
    // }
    // }
}
