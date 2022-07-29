import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { UserService } from '../services/userservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Component({
  selector: 'app-recoverpassword',
  templateUrl: './recoverpassword.component.html',
  styleUrls: ['./recoverpassword.component.css']
})
export class RecoverpasswordComponent implements OnInit {

  public myForm: FormGroup;
  public otp:number;
  public isEnable:boolean;
  public isTxtEnable:boolean;

  constructor(private userservice:UserService,private dialog:MatDialog) {
    this.myForm = new FormGroup({
      email: new FormControl('', [Validators.required,Validators.email]),
      otp: new FormControl('', [Validators.required,Validators.maxLength(6)]),
      password: new FormControl('', [Validators.required, Validators.minLength(6),Validators.maxLength(10)]),
      cpassword: new FormControl('', [Validators.required]),
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
       var  data={
          email:this.myForm.get("email").value,
           password:this.myForm.get("password").value
        }
         this.userservice.resetPassword(data).subscribe(data=>{ this.dialog.open(SuccessalertComponent,{data:{msg:' Password updated sucssefully '}})})
         this.myForm.reset()
         this.isEnable=false;
         this.isTxtEnable=false;
     }
     
    
      
    }
    sendOtp(){
    
       this.userservice.generateOtp(this.myForm.get("email").value).subscribe((data)=>{this.otp=data.msg,this.isEnable=true},(error)=>{this.isEnable=false,this.dialog.open(SuccessalertComponent,{data:{msg:' Email/Username Does Not Exits '}})});
    
     
    }
    verifyOtp(){
      if(this.myForm.get("otp").value==this.otp){
        this.isTxtEnable=true;
        this.dialog.open(SuccessalertComponent,{data:{msg:' OTP Verified Sucssefully '}})
      }
      else{
        this.isTxtEnable=false;
        this.dialog.open(SuccessalertComponent,{data:{msg:' Please Enter Valid OTP '}})
      }
    }
}
