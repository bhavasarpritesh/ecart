import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {environment} from "./../../environments/environment";
const API= environment.baseUrl;
@Injectable({
  providedIn: 'root'
})
export class AdmindashboardserviceService {

  constructor(private http: HttpClient) { }
  
  getOrderCount(): Observable<any> {
    return this.http.get(API + '/order/getcount');
  }
  getUSerCount(): Observable<any> {
    return this.http.get(API + '/user/getcount');
  }
  getProductCount(): Observable<any> {
    return this.http.get(API + '/product/getcount');
  }
}
