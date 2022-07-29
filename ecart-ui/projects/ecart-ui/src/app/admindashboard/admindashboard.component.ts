import { Component, OnInit } from '@angular/core';
import { AdmindashboardserviceService } from '../services/admindashboardservice.service';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  constructor(private adservice:AdmindashboardserviceService) { }
public ordercount;
public usercount;
public productcount;
  ngOnInit(): void {
    this.adservice.getOrderCount().subscribe(data=> this.ordercount=data);
    this.adservice.getUSerCount().subscribe(data=>this.usercount=data);
    this.adservice.getProductCount().subscribe(data=>this.productcount=data);
  }

}
