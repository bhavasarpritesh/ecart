import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {environment} from "./../../environments/environment";
const AUTH_API= environment.baseUrl+"/user";
@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {
  constructor(private http: HttpClient) { }
  login(data: any): Observable<any> {

    return this.http.post(AUTH_API + '/login', data);

  }

  register(data: any): Observable<any> {

    return this.http.post(AUTH_API + '/save', data);
  }
 
}
  