import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { category } from '../model/category';
import { CategoryService } from '../services/category.service';
import { ProductserviceService } from '../services/productservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  public myForm: FormGroup;
  public cat:category[];
  public formData: FormData = new FormData();
  public currentFileUpload: File;
  constructor(private service:ProductserviceService,private router: Router,private dialog: MatDialog,private cservice:CategoryService) {
    this.myForm = new FormGroup({
      productname: new FormControl('', [Validators.required, Validators.maxLength(20)]),
      price: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
      status: new FormControl(''),
      category: new FormControl(''),
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
       
        this.service.postProduct(this.formData).subscribe(
          data => {
            
            this.dialog.open(SuccessalertComponent,{data:{msg:data.msg}});
            this.router.navigateByUrl('viewproduct');
          
          },
          err => {
            this.dialog.open(SuccessalertComponent,{data:{msg:err.error.msg}});
             
          })
         
     }
     
    }
}
