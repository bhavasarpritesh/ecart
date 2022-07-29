import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { OrderProduct } from '../model/orderproduct';
const URL=environment.baseUrl+"/orderproduct";
@Injectable({
  providedIn: 'root'
})
export class OrderproductService {

  constructor(private http: HttpClient) { }
  findAllOrderProduct(id): Observable<OrderProduct[]>{
    return this.http.get<OrderProduct[]>(URL+'/getbyorder/'+id);
  }
  updateRating(data): Observable<any>{
    return this.http.put<OrderProduct[]>(URL+'/rate',data);
  }
}
