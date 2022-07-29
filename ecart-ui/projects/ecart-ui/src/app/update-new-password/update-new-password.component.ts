import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TokenserviceService } from '../services/tokenservice.service';
import { UserService } from '../services/userservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Component({
  selector: 'app-update-new-password',
  templateUrl: './update-new-password.component.html',
  styleUrls: ['./update-new-password.component.css']
})
export class UpdateNewPasswordComponent implements OnInit {
  public myForm: FormGroup;
  public otp:number;
  public isEnable:boolean;
  public isTxtEnable:boolean;
  public user;
  constructor(private service:TokenserviceService,private router: Router,private dialog: MatDialog,private userserive:UserService) {
    this.user=JSON.parse(service.getUser());
    this.myForm = new FormGroup({
      email: new FormControl(this.user.email, [Validators.required,Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6),Validators.maxLength(10)]),
      newpassword: new FormControl('', [Validators.required, Validators.minLength(6),Validators.maxLength(10)]),
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
  confirmpassword(){
   
    if(this.myForm.get('newpassword')?.value==this.myForm.get('cpassword')?.value){
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
        password:this.myForm.get("password").value,
        newPassword:this.myForm.get("newpassword").value
      }
       this.userserive.updatePassword(data).subscribe(data=>{ this.dialog.open(SuccessalertComponent,{data:{msg:' Password updated sucssefully '}})},err=>{this.dialog.open(SuccessalertComponent,{data:{msg:' Currunt Password is wrong '}})})
       this.router.navigate(["/"])
       
   }
}}
