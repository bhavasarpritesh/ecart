import { Component, OnInit } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { vieworders } from '../model/vieworders';
import { ProductdialougeComponent } from '../productdialouge/productdialouge.component';
import { OrderserviceService } from '../services/orderservice.service';
import { OrderstatusService } from '../services/orderstatus.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Component({
  selector: 'app-vieworders',
  templateUrl: './vieworders.component.html',
  styleUrls: ['./vieworders.component.css']
})

  export class ViewordersComponent implements OnInit, AfterViewInit {
    public val:string="";
      public displayedColumns = ['index','username.name', 'quantity', 'price', 'orderDate', 'paymentId','orderStatus', 'product','action','deliever'];
      public b=[];
      public dataSource= new MatTableDataSource<vieworders>();
      public ordersatus=[];
      public satusid;
     @ViewChild(MatSort) sort!: MatSort;
     @ViewChild(MatPaginator) paginator!: MatPaginator;
      constructor(private orderservice:OrderserviceService,private osservice:OrderstatusService,private dialog: MatDialog,private router: Router){
       
      }
      ngOnInit() {
        this.osservice.getAllOrderSatus().subscribe(data=>this.ordersatus=data)
        this.orderservice.findAllOrder().subscribe(data=>this.dataSource.data=data)
      
      }
      ngAfterViewInit(): void {
        this.dataSource.sort=this.sort;
        this.dataSource.paginator=this.paginator;
      }
      public redirectToUpdate = (id: string) => {
        
      }
      public redirectToDelete = (id: string) => {
        
      }
      public updateStatus(oid){
      
        this.orderservice.updateOrderSatus(this.satusid,oid).subscribe(
          data => {
            
            this.dialog.open(SuccessalertComponent,{data:{msg:data.msg}});
           location.reload();
         
          })
         
      }
      public doFilter = () => {
        this.dataSource.filter = this.val.trim().toLocaleLowerCase();
        }

        public showProduct(id){
          this.dialog.open(ProductdialougeComponent,{data:{id:id}})
        }
        public show(a){
          this.satusid=a;
        }
    }
    
    