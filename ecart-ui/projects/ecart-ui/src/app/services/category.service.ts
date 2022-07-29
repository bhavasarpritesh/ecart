import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { category } from '../model/category';

const URL=environment.baseUrl+"/productcategory";
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }
  getAllCategory(): Observable<category[]> {
    return this.http.get<category[]>( URL + "/getall");
  }
}
