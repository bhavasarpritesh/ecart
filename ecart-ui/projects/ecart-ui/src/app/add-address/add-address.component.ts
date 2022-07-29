import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { AddresserviceService } from '../services/addresservice.service';
import { TokenserviceService } from '../services/tokenservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css']
})
export class AddAddressComponent implements OnInit {
  public myForm: FormGroup;
  public user;
  constructor(private addressservice:AddresserviceService,private dialog: MatDialog,private tokenservice:TokenserviceService) {
    this.myForm = new FormGroup({
      streetname: new FormControl('', [Validators.required, Validators.maxLength(20)]),
      landmark: new FormControl('', [Validators.required, Validators.maxLength(20)]),
      pincode: new FormControl('', [Validators.required, Validators.maxLength(10)]),
      city: new FormControl('', [Validators.required, Validators.maxLength(10)]),
      addresstype: new FormControl('')

    }
    );
   }
  hide = true;
  public myError = (controlName: string, errorName: string) =>{
    return this.myForm.controls[controlName].hasError(errorName);
    }

  ngOnInit(): void {
    this.user=JSON.parse(this.tokenservice.getUser());
    
  }
    get F(){
      return this.myForm.controls;
    }
    onSubmit(){
      if (this.myForm.valid) {
      
        this.addressservice.saveAddress(this.myForm.value,this.user.id).subscribe(
          data => {
            
            this.dialog.open(SuccessalertComponent,{data:{msg:'Address saved Successful'}});
           
          },
          err => {
            this.dialog.open(SuccessalertComponent,{data:{msg:err.error.msg}});
           
          })
         
     }
      
    
      
    }
}
