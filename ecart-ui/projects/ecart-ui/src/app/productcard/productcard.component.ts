import { Component, OnInit } from '@angular/core';
import { productcard } from '../model/productcard';
import {MatDialog} from '@angular/material/dialog';
import { CartdialogComponent } from '../cartdialog/cartdialog.component';
import { CartserviceService } from '../services/cartservice.service';
import { Cart } from '../model/cart';
import { ProductserviceService } from '../services/productservice.service';
import { product } from '../model/product';
import { CategoryService } from '../services/category.service';
import { category } from '../model/category';
@Component({
  selector: 'app-productcard',
  templateUrl: './productcard.component.html',
  styleUrls: ['./productcard.component.css']
})
export class ProductcardComponent implements OnInit {
  public products:product[]=[];
  public category:category[];
  public name;
  public currentRate=3;

  constructor(private cartDialog: MatDialog,private cartservice: CartserviceService,private pservice:ProductserviceService,private categoryservice:CategoryService) { }
cartData: Cart={
  orderProducts:[],
  quantityOfItems: 0,
  totalPrice: 0
};
  ngOnInit(): void {
    this.cartservice.cartDataChanged$.subscribe(cartData=>this.cartData=cartData);
         this.pservice.findAllProducts().subscribe(data=>{this.products=data;});
         this.categoryservice.getAllCategory().subscribe(data=>this.category=data);
  }
  openCartDialog(): void{
    this.cartDialog.open(CartdialogComponent, {data: {}})
    .afterClosed().subscribe(()=>{return this.cartservice.cartDataChanged$.subscribe(cartData=>this.cartData=cartData)})
    ;
  }
  addToCart(product: product){
    this.cartservice.addToCart(product);
  }
  change(cat){
    if(cat=="all")
    this.pservice.findAllProducts().subscribe(data=>this.products=data);
    else
    this.pservice.findAllProductsByCategory(cat).subscribe(data=>this.products=data)
  }
  search(){
    if(this.name=="")
    this.pservice.findAllProducts().subscribe(data=>this.products=data);
    else
    this.pservice.findProductByName(this.name).subscribe(data=>this.products=data)
  }
  buyNow(product){
    this.cartservice.addToCart(product);
    this.openCartDialog()
  }
}
