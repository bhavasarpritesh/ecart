import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { product } from '../model/product';
import { productcard } from '../model/productcard';
import {environment} from './../../environments/environment';
const URL=environment.baseUrl+"/product";
@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {
  constructor(private http: HttpClient) {
  }
  headers = new HttpHeaders({ 'enctype':'mutipart/form-data' });

  postProduct(product: any): Observable<any>{
    return this.http.post(URL + '/save', product);
  }
    findAllProducts(): Observable<product[]>{
      return this.http.get<product[]>(URL+'/getall');
    }
  findAllProductsByCategory(category): Observable<productcard[]>{
    return this.http.get<productcard[]>(URL + `/getbytype/${category}`);
  }
  findProductByName(name): Observable<productcard[]> {
    return this.http.get<productcard[]>(URL + `/getbyname/${name}`);
    }
  findProductById(id): Observable<productcard> {
    return this.http.get<productcard>( URL + `?id=${id}`);
  }
  updateProduct(product: any): Observable<any>{
    return this.http.put(URL + `/update`, product);
  }
  updateProductStatus(sid,id): Observable<any>{
    return this.http.patch(URL + `/update/${sid}/${id}`,{});
  }
  
}
