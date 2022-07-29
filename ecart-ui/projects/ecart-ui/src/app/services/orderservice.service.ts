import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { vieworders } from '../model/vieworders';
import {environment} from './../../environments/environment';
const URL=environment.baseUrl+"/order";

function _window() : any {
  return window;
}
@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {

  constructor(private http: HttpClient) { }
 
  findAllOrder(): Observable<vieworders[]>{
    return this.http.get<vieworders[]>(URL+'/getall');
  }
  updateOrderSatus(sid,oid): Observable<any>{
    return this.http.patch<any>(URL+'/updatestatus/'+sid+'/'+oid,{});
  }
  findAllOrderUser(id): Observable<vieworders[]>{
    return this.http.get<vieworders[]>(URL+'/get/'+id);
  }
  get nativeWindow() : any {
    return _window();
 }
 makeOrder(data):Observable<any>{
  const headers = { 'content-type': 'application/json'} 
   return this.http.post(URL+'/save',data,{'headers':headers});

 }

}
