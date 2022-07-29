import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { user } from '../model/user';
import { AuthserviceService } from '../services/authservice.service';
import { DatashareService } from '../services/datashare.service';
import { TokenserviceService } from '../services/tokenservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public myForm: FormGroup;
  public user:user;
  constructor(private service:AuthserviceService,private dialog: MatDialog,private tokenservice:TokenserviceService, private router: Router,private datashareserveice:DatashareService) {
    this.myForm = new FormGroup({
      email: new FormControl('', [Validators.required,Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6),Validators.maxLength(10)])
    }
    );
    this.user=new user();
     
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
    
    onSubmit(){
      if (this.myForm.valid) {
         this.service.login(this.myForm.value).subscribe(data=>{
           this.tokenservice.saveToken(data.token)
            this.user.id=data.id;
            this.user.username=data.username;
            this.user.email=data.email;
            this.user.roles=data.roles;
            this.user.name=data.name;
            this.user.mobile=data.mobile;
            this.tokenservice.saveUser(JSON.stringify(this.user))
            this.datashareserveice.islogin.next(true);
            if(data.roles[0]=="user"){
              this.datashareserveice.isuser.next(true);
              //this.router.navigate(["/"])
            window.location.replace("/#/")
          }
            else if(data.roles[0]=="admin"){
              this.datashareserveice.isadmin.next(true);
              window.location.replace("/#/admindashboard")
             // this.router.navigate(["/admindashboard"])
            }
         },error=>{this.dialog.open(SuccessalertComponent,{data:{msg:' User Name Or Password is Incorrect '}});
        });
         
         
     }
    
      
    }
}
