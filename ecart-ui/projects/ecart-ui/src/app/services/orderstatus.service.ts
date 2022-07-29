import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { orderstatus } from '../model/ordersatus';
import {environment} from './../../environments/environment';
const URL=environment.baseUrl+"/orderstatus";
@Injectable({
  providedIn: 'root'
})
export class OrderstatusService {

  constructor(private http: HttpClient) { }
  getAllOrderSatus(): Observable<orderstatus[]>{
    return this.http.get<orderstatus[]>(URL+'/getall');
  }
}
