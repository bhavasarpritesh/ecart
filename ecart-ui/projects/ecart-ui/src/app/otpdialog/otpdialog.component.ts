import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AuthserviceService } from '../services/authservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Component({
  selector: 'app-otpdialog',
  templateUrl: './otpdialog.component.html',
  styleUrls: ['./otpdialog.component.css']
})
export class OtpdialogComponent implements OnInit {

  public otp;  
  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private dialog:MatDialog,private service:AuthserviceService) { }

  public email;
  public isvalid=true;
  public show=false;
  public show1=true;
  ngOnInit(): void {
    this.email=this.data.user.email;
  }
   public verifyOtp(){
         if(this.otp==this.data.otp){
         
          this.service.register(this.data.user).subscribe(data=>{ this.show=true; this.show1=false})
          this.isvalid=true;
          this.show=true; this.show1=false;
         
         }
         else{
           this.isvalid=false;
         }
   }
   public close(){
       this.dialog.closeAll(); 
  }
}
