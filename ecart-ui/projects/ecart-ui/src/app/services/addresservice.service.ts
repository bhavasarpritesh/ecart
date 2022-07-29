import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { address } from '../model/address';
import {environment} from "./../../environments/environment";
const API= environment.baseUrl+"/address";
@Injectable({
  providedIn: 'root'
})
export class AddresserviceService {

  constructor(private http: HttpClient) { }
  
  saveAddress(data: any,id:number): Observable<any> {
    return this.http.post(API + '/save/'+id, data);
  }
  getAddressByType(id,type):Observable<address>{
    return this.http.get<address>(API+"/getonebytype/"+id+"/"+type);

  }
  getAddressByUser(id):Observable<address>{
    return this.http.get<address>(API+"/getone/"+id);

  }
  updateAddress(data):Observable<any>{
    return this.http.put(API + '/update/', data);
  }
}
