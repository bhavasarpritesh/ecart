import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DisplayProduct } from '../model/displayproduct';
import { product } from '../model/product';
import { ProductserviceService } from '../services/productservice.service';
import { UpdateproductComponent } from '../updateproduct/updateproduct.component';

@Component({
  selector: 'app-viewproduct',
  templateUrl: './viewproduct.component.html',
  styleUrls: ['./viewproduct.component.css']
})
export class ViewproductComponent implements OnInit, AfterViewInit {
public val:string="";
  public products:product[]=[];
  public displayedColumns =['index','productname', 'image','category', 'description', 'quantity', 'price', 'status','edit','delete'];
 
  public dataSource= new MatTableDataSource<product>();
 @ViewChild(MatSort) sort!: MatSort;
 @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(private pservice:ProductserviceService,private dialog: MatDialog){
   
    this.pservice.findAllProducts().subscribe(data=> this.dataSource.data=data);

  }
  ngOnInit() {

  }
  ngAfterViewInit(): void {
    this.dataSource.sort=this.sort;
    this.dataSource.paginator=this.paginator;
   
  }
  public redirectToUpdate = (product) => {
    this.dialog.open(UpdateproductComponent,{data:{msg:product}});
  }
  public redirectToStatus = (sid,id) => {
     sid=sid==0?1:0;
    this.pservice.updateProductStatus(sid,id).subscribe(data=>window.location.reload());
  }

  public doFilter = () => {

    this.dataSource.filter = this.val.trim().toLocaleLowerCase();
    
    }
    
}
