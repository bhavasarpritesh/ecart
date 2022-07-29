import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ConfirmPasswordValidator} from '../providers/customvalidator';
import { AuthserviceService } from '../services/authservice.service';
import {MatDialog} from '@angular/material/dialog';
import { SuccessalertComponent } from '../successalert/successalert.component';

import { UserService } from '../services/userservice.service';
import { OtpdialogComponent } from '../otpdialog/otpdialog.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public myForm: FormGroup;
  public errorMessage;
  constructor(private service:AuthserviceService,private router: Router,private dialog: MatDialog,private userserive:UserService) {
    this.myForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.maxLength(20)]),
      email: new FormControl('', [Validators.required,Validators.email]),
      mobile: new FormControl('', [Validators.required,Validators.pattern("^[7-9][0-9]{9}$")]),
      password: new FormControl('', [Validators.required, Validators.minLength(6),Validators.maxLength(10)]),
      cpassword: new FormControl('', [Validators.required]),
      roles:new FormControl('user')
    }
    );
   }
  hide = true;
  public myError = (controlName: string, errorName: string) =>{
    return this.myForm.controls[controlName].hasError(errorName);
    }

  ngOnInit(): void {
    
  }
    get F(){
      return this.myForm.controls;
    }
    confirmpassword(){
     
      if(this.myForm.get('password')?.value==this.myForm.get('cpassword')?.value){
        
         this.myForm.get('cpassword')?.setErrors(null);
         
      }
      else{
        this.myForm.get('cpassword')?.setErrors({ confirmPasswordValidator: true })
      }

    }
    onSubmit(){
      if (this.myForm.valid) {

        this.myForm.patchValue({'roles':['user']})
         this.userserive.generateOtpForSignUp(this.myForm.get("email").value).subscribe(data=>{this.dialog.open(OtpdialogComponent,{data:{otp:data.msg,user:this.myForm.value}})},err=>{this.dialog.open(SuccessalertComponent,{data:{msg:err.error.msg}})})
        
         
     }
     
    
      
    }
}
