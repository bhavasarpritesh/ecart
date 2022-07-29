import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatashareService {
  public islogin: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public isadmin: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public isuser: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  constructor() { }
}
