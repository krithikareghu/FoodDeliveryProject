import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Userregister } from 'src/app/shared/model/userregister';
import { UserregisterService } from '../../services/register/userregister.service';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

    userregister: Userregister = new Userregister();
    constructor(
        private registeruserservice: UserregisterService,
           private router: Router){}
    

    ngOnInit() {
    }

    observer = {
        next: () => {alert("registered successfully")
        this.router.navigate(['/home/login'])
    },
        error: (error: any) =>alert("please enter proper credentials to register"),

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
