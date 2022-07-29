import { Injectable } from '@angular/core';
import { user } from '../model/user';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
@Injectable({
  providedIn: 'root'
})
export class TokenserviceService {

  constructor() { }

  logout(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, user);
  }

  public getUser(): any {
    return sessionStorage.getItem(USER_KEY);
  }
  public isAuthenticated(): boolean {
    return sessionStorage.getItem(TOKEN_KEY) != null;
  }
}
