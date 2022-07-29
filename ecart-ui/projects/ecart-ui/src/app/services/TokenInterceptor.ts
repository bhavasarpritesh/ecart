import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { catchError, Observable, throwError } from "rxjs";
import { TokenserviceService } from "./tokenservice.service";
import { Injectable } from '@angular/core';
import { Router } from "@angular/router";
@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(private authService: TokenserviceService, private router: Router) {} 
 intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {  
    const token = this.authService.getToken();

   if (token) {
     // If we have a token, we set it to the header
     request = request.clone({
        setHeaders: {Authorization: token}
     });
  }

  return next.handle(request).pipe(
  	catchError((err) => {
   	 if (err instanceof HttpErrorResponse) {
       	 if (err.status === 401) {
       	  this.router.navigate(['/login']);
     	}
 	 }
  	return throwError(err);
	})
   )
  }
}
