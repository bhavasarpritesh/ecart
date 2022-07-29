import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Route, Router } from '@angular/router';
import { Cart } from '../model/cart';
import { OrderProduct } from '../model/orderproduct';
import { product } from '../model/product';
import { CartserviceService } from '../services/cartservice.service';
import { TokenserviceService } from '../services/tokenservice.service';
import { SuccessalertComponent } from '../successalert/successalert.component';
@Component({
  selector: 'app-cartdialog',
  templateUrl: './cartdialog.component.html',
  styleUrls: ['./cartdialog.component.css']
})
export class CartdialogComponent implements OnInit {
constructor(private dialog: MatDialog,private cartDialog: MatDialog, private router: Router,private cartService: CartserviceService,private tokenservice:TokenserviceService){
}
  public op:product;
  public o:OrderProduct;
  cart: Cart = {
    orderProducts:[],
    quantityOfItems: 0,
    totalPrice: 0
  };

ngOnInit(): void {
  this.cart=this.cartService.getCartData();
  this.cartService.cartDataChanged$.subscribe(cart=> this.cart=cart);
}
increase(product: OrderProduct): void{
  this.op=this.cart.orderProducts.find(p=>p.product==product.product).product;
  this.o=this.cart.orderProducts.find(p=>p==product);

  if(this.op.quantity>this.o.quantity){
  this.cartService.increaseQuantity(product);
  this.cartService.setTotalPrice();}
  else{
    this.dialog.open(SuccessalertComponent,{data:{msg:"Out Of Stock"}});
  }
}
decrease(product:OrderProduct): void{
 this.cartService.decreaseQuantity(product);
  this.cartService.setTotalPrice();
}
clearCart(): void{
 this.cartService.clearCart();
this.cartService.setTotalPrice();
}
closeDialog(): void{
  this.cartDialog.closeAll();
}
openCheckout(): void {
 
  if(this.tokenservice.isAuthenticated()){
  this.closeDialog();
  this.router.navigate(['/proceedpage']);}
  else{
    this.closeDialog();
    this.router.navigate(['/login']);}
  }
}

