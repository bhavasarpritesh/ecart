import { AfterContentInit, AfterViewInit, Component, OnInit } from '@angular/core';
import { ViewChild } from '@angular/core';
import { BreakpointObserver } from '@angular/cdk/layout';
import { MatSidenav } from '@angular/material/sidenav';
import { delay, filter } from 'rxjs/operators';
import { NavigationEnd, Router } from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { TokenserviceService } from '../services/tokenservice.service';
import { user } from '../model/user';
import { CategoryService } from '../services/category.service';
import { category } from '../model/category';
import { ProductcardComponent } from '../productcard/productcard.component';
import { DatashareService } from '../services/datashare.service';

@Component({
  selector: 'app-slidemenu',
  templateUrl: './slidemenu.component.html',
  styleUrls: ['./slidemenu.component.css']
})
export class SlidemenuComponent implements OnInit, AfterViewInit,AfterContentInit{

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;
  public user:user;
  public role:string;
  public username:string;
  public islogin:boolean;
  public isadmin:boolean;
  public isuser:boolean;
  public name:string;
  public category:category[];
  constructor(private observer: BreakpointObserver, private router: Router,private tokenservice:TokenserviceService,private categoryservice:CategoryService,private datashareserveice:DatashareService) {
    this.user=new user();
   
  }

  ngAfterViewInit() {
    this.observer
      .observe(['(max-width: 800px)'])
      .pipe(delay(1), untilDestroyed(this))
      .subscribe((res) => {
        if (res.matches) {
          this.sidenav.mode = 'over';
          this.sidenav.close();
        } else {
          this.sidenav.mode = 'side';
          this.sidenav.open();
        }
      });

    this.router.events
      .pipe(
        untilDestroyed(this),
        filter((e) => e instanceof NavigationEnd)
      )
      .subscribe(() => {
        if (this.sidenav.mode === 'over') {
          this.sidenav.close();
        }
      });
    
  }
  ngOnInit(): void {
    this.categoryservice.getAllCategory().subscribe(data=>this.category=data);
    this.datashareserveice.isadmin.subscribe(data=>this.isadmin=data)
    this.datashareserveice.islogin.subscribe(data=>this.islogin=data)
    this.datashareserveice.isuser.subscribe(data=>this.isuser=data)
  }   
   logout(){
     this.tokenservice.logout();
     this.datashareserveice.islogin.next(false);
     this.datashareserveice.isadmin.next(false);
     this.datashareserveice.isuser.next(false);
     window.location.replace("/#/login")
   }
   ngAfterContentInit():void{
    this.user=JSON.parse(this.tokenservice.getUser());
    this.islogin=this.tokenservice.isAuthenticated()
    
       if(this.user.roles.pop()=='user'){
         this.isuser=true;
         this.isadmin=false;}
         else{
           this.isadmin=true;
           this.isuser=false;
         }
      //this.datashareserveice.isadmin.subscribe(data=>this.isadmin=data)
     // this.datashareserveice.islogin.subscribe(data=>this.islogin=data)
     // this.datashareserveice.isuser.subscribe(data=>this.isuser=data)
   }
   public search(){

   }
   change(cat){}
}
