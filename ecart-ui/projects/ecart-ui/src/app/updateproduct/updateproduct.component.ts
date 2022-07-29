import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { category } from '../model/category';
import { CategoryService } from '../services/category.service';
import { ProductserviceService } from '../services/productservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: ['./updateproduct.component.css']
})
export class UpdateproductComponent implements OnInit {

  public myForm: FormGroup;
  public cat:category[];
  public formData: FormData = new FormData();
  public currentFileUpload: File;
  
  constructor(private service:ProductserviceService,private router: Router,private dialog: MatDialog,private cservice:CategoryService,@Inject(MAT_DIALOG_DATA) public data: any) {
   
    this.myForm = new FormGroup({
      id: new FormControl(data.msg.id, [Validators.required, Validators.maxLength(20)]),
      productname: new FormControl(data.msg.productname, [Validators.required, Validators.maxLength(20)]),
      price: new FormControl(data.msg.price, [Validators.required]),
      description: new FormControl(data.msg.description, [Validators.required]),
      quantity: new FormControl(data.msg.quantity, [Validators.required]),
      status: new FormControl(data.msg.status),
      category: new FormControl(data.msg.category.id),
      image: new FormControl('')
    }
    );
    cservice.getAllCategory().subscribe(data=>{this.cat=data})
    
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
    selectFile(file): void{
      this.currentFileUpload = file.target.files[0];
    }
    onSubmit(){
      if (this.myForm.valid) {
       
      this.myForm.patchValue({category:{id:this.myForm.get("category").value}});
        
      
        this.formData.append('product', JSON.stringify(this.myForm.value));
        this.formData.append('image', this.currentFileUpload, this.currentFileUpload.name);
       
        this.service.updateProduct(this.formData).subscribe(
          data => {
          this.dialog.closeAll()
          this.dialog.open(SuccessalertComponent,{data:{msg:data.msg}});
           
           window.location.reload()
           
         },
          err => {
           this.dialog.open(SuccessalertComponent,{data:{msg:err.error.msg}});
              
          })
         
     }
      
    }

}
