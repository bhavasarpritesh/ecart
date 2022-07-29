import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { OrderProduct } from '../model/orderproduct';
import { OrderproductService } from '../services/orderproduct.service';
import { TokenserviceService } from '../services/tokenservice.service';

@Component({
  selector: 'app-productdialouge',
  templateUrl: './productdialouge.component.html',
  styleUrls: ['./productdialouge.component.css']
})

export class ProductdialougeComponent implements OnInit {
  public rate;
  public displayedColumns = ['name', 'image', 'quantity', 'price','rating'];
  public dataSource = new MatTableDataSource<OrderProduct>();
  public isUser;
  constructor(private productDialog: MatDialog,@Inject(MAT_DIALOG_DATA) public data: any,private opservice:OrderproductService,private tserivece:TokenserviceService) { }
   public orderproduct:OrderProduct[];
  ngOnInit(): void {
    this.opservice.findAllOrderProduct(this.data.id).subscribe(data=>{this.dataSource.data=data;})
    this.isUser=JSON.parse(this.tserivece.getUser()).roles.pop()=='user';
    
  }
  public rateProduct(rate){
    this.opservice.updateRating(rate).subscribe(data=>{})
  }

}
