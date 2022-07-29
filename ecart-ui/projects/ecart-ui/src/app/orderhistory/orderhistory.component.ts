import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { orderhistory } from '../model/orderhistory';
import { user } from '../model/user';
import { vieworders } from '../model/vieworders';
import { ProductdialougeComponent } from '../productdialouge/productdialouge.component';
import { OrderserviceService } from '../services/orderservice.service';
import { OrderstatusService } from '../services/orderstatus.service';
import { TokenserviceService } from '../services/tokenservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';
@Component({
  selector: 'app-orderhistory',
  templateUrl: './orderhistory.component.html',
  styleUrls: ['./orderhistory.component.css']
})
export class OrderhistoryComponent implements OnInit {
  public user:user;
  public val:string="";
  public displayedColumns = ['index','username', 'quantity', 'totalamount', 'orderdate', 'paymentid', 'product','status','deliever'];
  public satusid=2;
  public dataSource= new MatTableDataSource<vieworders>();
 @ViewChild(MatSort) sort!: MatSort;
 @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(private orderservice:OrderserviceService,private osservice:OrderstatusService,private dialog: MatDialog,private router: Router,private tokenservice:TokenserviceService){
    
  }
  ngOnInit() {
    this.user=JSON.parse(this.tokenservice.getUser());

    this.orderservice.findAllOrderUser(this.user.id).subscribe(data=>this.dataSource.data=data)

  }
  ngAfterViewInit(): void {
    this.dataSource.sort=this.sort;
    this.dataSource.paginator=this.paginator;
  }
  public redirectToUpdate = (id: string) => {
    
  }
  public redirectToDelete = (id: string) => {
    
  }
  public doFilter = () => {

    this.dataSource.filter = this.val.trim().toLocaleLowerCase();
    
    }
    public showProduct(id){
      this.dialog.open(ProductdialougeComponent,{data:{id:id}})
    }
    public updateStatus(oid){
      
      this.orderservice.updateOrderSatus(this.satusid,oid).subscribe(
        data => {
          
          this.dialog.open(SuccessalertComponent,{data:{msg:data.msg}});
         location.reload();
        })
    }
}
