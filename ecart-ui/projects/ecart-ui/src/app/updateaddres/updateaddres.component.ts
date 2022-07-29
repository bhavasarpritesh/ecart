import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AddresserviceService } from '../services/addresservice.service';
import { TokenserviceService } from '../services/tokenservice.service';

@Component({
  selector: 'app-updateaddres',
  templateUrl: './updateaddres.component.html',
  styleUrls: ['./updateaddres.component.css']
})
export class UpdateaddresComponent implements OnInit {

  
  public myForm: FormGroup;
  public type;

  public address: {
    id: number;
    landmark: string;
    streetname: string;
    city: string;
    pincode: number;
    addresstype: string;
  };
  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private dialog:MatDialog,private service :AddresserviceService) { 
    
    this.myForm = new FormGroup({
      id: new FormControl(this.data.add.id),
      addresstype: new FormControl(this.data.add.addresstype),
      streetname: new FormControl(this.data.add.streetname, [Validators.required, Validators.maxLength(20)]),
      landmark: new FormControl(this.data.add.landmark, [Validators.required, Validators.maxLength(20)]),
      pincode: new FormControl(this.data.add.pincode, [Validators.required, Validators.maxLength(10)]),
      city: new FormControl(this.data.add.city, [Validators.required, Validators.maxLength(10)]),
      user: new FormControl({id:this.data.user.id})
    }
    );
  }
public show(a){

}
hide = true;
  public myError = (controlName: string, errorName: string) =>{
    return this.myForm.controls[controlName].hasError(errorName);
    }
  public update(){
    this.service.updateAddress(this.myForm.value).subscribe(data=>{window.location.reload()})
  }


  ngOnInit(): void {
  }

}
