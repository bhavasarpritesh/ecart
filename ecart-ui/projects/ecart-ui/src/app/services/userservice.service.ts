import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from '../model/user';
import { userlist } from '../model/userlist';
import {environment} from './../../environments/environment';
const URL=environment.baseUrl+"/user";
@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  constructor(private http: HttpClient) { }
  getAllUser(): Observable<userlist[]> {
    return this.http.get<userlist[]>( URL + "/getall");
  }
  generateOtp(email):Observable<any>{
    return this.http.get<any>(URL+"/generateotp/"+email);

  }
  resetPassword(data):Observable<any>{
    const headers = { 'content-type': 'application/json'} 
    return this.http.patch(URL+'/updatepassword',data,{'headers':headers})
  }
  generateOtpForSignUp(email):Observable<any>{
    return this.http.get<any>(URL+"/generate/"+email);

  }
  updateProdfile(data):Observable<any>{
    const headers = { 'content-type': 'application/json'} 
    return this.http.patch(URL+'/updateprofile',data,{'headers':headers})
  }
  updatePassword(data):Observable<any>{
    const headers = { 'content-type': 'application/json'} 
    return this.http.patch(URL+'/updatepasswordby',data,{'headers':headers})
  }
}
