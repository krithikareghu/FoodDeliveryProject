import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';


@Injectable()
export class AuthinterceptorInterceptor implements HttpInterceptor {

  constructor(private auth: AuthenticationService, private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

//     let modifiedReq;
//     if(localStorage.getItem('jwtToken')){
//       console.log("token")
//     modifiedReq = req.clone({ 
//       headers: req.headers.set('Authorization', `Bearer ${localStorage.getItem('jwtToken')}`),
//     });
//   }
//   else{
//     modifiedReq =req;
//   }
//     return next.handle(modifiedReq);
//   }
// }
if (req.headers.get("NO-AUTH") === "True") {
  return next.handle(req.clone());
}

//     let jwtotken=req.clone({
//       headers: req.headers.set('Authorization', `Bearer ${localStorage.getItem('jwtToken')}`),
//     })
//     return next.handle(jwtotken);
//   }

  const token: any = this.auth.getToken();   
    req = this.addtoken(req, token);
    

     return next.handle(req).pipe(
     
       catchError(

        (err: HttpErrorResponse) => {
          if (err.status === 401) {
            this.router.navigate(['/login']);
          } else if (err.status === 403) {
            this.router.navigate(['/forbidden']);
          }
          return throwError("Something went wrong");
        }
      )
    );
    
   }
  
  
  private addtoken(request: HttpRequest<any>, token: string) {
    return request.clone({
      setHeaders: {
        Authorization: "Bearer "+this.auth.getToken()
     
      }
    })

 }

}


//export const authInterceptorProviders=[{provide:HTTP_INTERCEPTORS,useclass:AuthinterceptorInterceptor,multi:true}]
