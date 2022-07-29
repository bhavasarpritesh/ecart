import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { user } from '../model/user';
import { TokenserviceService } from '../services/tokenservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {
  constructor(private service:TokenserviceService,private router:Router,private dialog: MatDialog){}
  public user:user;
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot):  boolean  {
     this.user=JSON.parse(this.service.getUser());
      if(this.service.isAuthenticated()&&this.user.roles.pop()=='user')
       return true;
       else{
      
         this.dialog.open(SuccessalertComponent,{data:{msg:' Access deny !!! please login as Customer '}});
         this.router.navigate(['/admindashboard']);
         return false;
       }
  }
  
}
