import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TokenserviceService } from '../services/tokenservice.service';
import { UserService } from '../services/userservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Component({
  selector: 'app-viewprofile',
  templateUrl: './viewprofile.component.html',
  styleUrls: ['./viewprofile.component.css']
})
export class ViewprofileComponent implements OnInit {
  public myForm: FormGroup;
  public errorMessage;
  public user;
  public isEnable=true;
  constructor(private service:TokenserviceService,private router: Router,private dialog: MatDialog,private userserive:UserService) { 
    this.user=JSON.parse(service.getUser());
    this.myForm = new FormGroup({
      name: new FormControl(this.user.name, [Validators.required, Validators.maxLength(20)]),
      email: new FormControl(this.user.email, [Validators.required,Validators.email]),
      mobile: new FormControl(this.user.mobile, [Validators.required,Validators.pattern("^[7-9][0-9]{9}$")]),
     
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

      this.userserive.updateProdfile(this.myForm.value).subscribe(data=>{this.dialog.open(SuccessalertComponent,{data:{msg:"Profile Updated Succsefully" }})})
         
   }
    
  }
  edit(){
    this.isEnable=false;
  }
}
