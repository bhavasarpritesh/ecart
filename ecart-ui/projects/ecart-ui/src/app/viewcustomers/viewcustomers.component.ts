import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { userlist } from '../model/userlist';
import { UserService } from '../services/userservice.service';

@Component({
  selector: 'app-viewcustomers',
  templateUrl: './viewcustomers.component.html',
  styleUrls: ['./viewcustomers.component.css']
})
export class ViewcustomersComponent implements OnInit {

  public val:string="";
  public displayedColumns = ['index','name', 'email', 'mobile','roles'];
 
  public dataSource= new MatTableDataSource<userlist>();
 @ViewChild(MatSort) sort!: MatSort;
 @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(private uservice:UserService){
    
  }
  ngOnInit() {
    this.uservice.getAllUser().subscribe(data=>this.dataSource.data=data)
   
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
}
