import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddresserviceService } from '../services/addresservice.service';
import { TokenserviceService } from '../services/tokenservice.service';
import { UpdateaddresComponent } from '../updateaddres/updateaddres.component';

@Component({
  selector: 'app-manageaddres',
  templateUrl: './manageaddres.component.html',
  styleUrls: ['./manageaddres.component.css']
})
export class ManageaddresComponent implements OnInit {
  public address;
  public user;
  constructor(private addressservice:AddresserviceService,private tokenservice:TokenserviceService,private dialog:MatDialog) { }

  ngOnInit(): void {
    this.user=JSON.parse(this.tokenservice.getUser());
    this.addressservice.getAddressByUser(this.user.id).subscribe(data=>{this.address=data})
  }
  public updateAdd(add){
    this.dialog.open(UpdateaddresComponent,{data:{add:add,user:this.user}});
  }
}
