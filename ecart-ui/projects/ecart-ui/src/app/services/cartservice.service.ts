import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Cart } from '../model/cart';
import { OrderProduct } from '../model/orderproduct';
import { product } from '../model/product';
@Injectable({
  providedIn: 'root'
})
export class CartserviceService {

  cart: Cart = {
    orderProducts:[] = new Array<OrderProduct>(),
    quantityOfItems: 0,
    totalPrice: 0
  };

  constructor() {
  }

  private cartData$ = new BehaviorSubject<Cart>(this.cart);
  cartDataChanged$ = this.cartData$.asObservable();

  addToCart(piece:product): void {
 const item=new OrderProduct();

 item.product=piece;
 item.quantity=1;
 item.price=piece.price;
 const product=this.cart.orderProducts.find(p=>p.product.productname===item.product.productname);
  if(product !==undefined){
    
    product.quantity++;
  }else{
   
    item.quantity=item.quantity++;
    this.cart.orderProducts?.push(item);
  }

this.setQuantityOfItems();
this.setTotalPrice();
//alert(this.cart.orderProducts?.length)
}

  setQuantityOfItems() {
    if(this.cart.orderProducts?.length==1){
    this.cart.orderProducts.find(p=>this.cart.quantityOfItems=p.quantity)
    return this.cart.quantityOfItems;
  }
   this.cart.orderProducts?.map(a=>a.quantity).reduce((a,b)=>{
    const quantity=a+b;
    console.log(quantity.valueOf());
    return this.cart.quantityOfItems=quantity;
  });
  return this.cart.quantityOfItems   
  }

  getCartData(): Cart {
    return this.cart;
  }
  increaseQuantity(prods:OrderProduct): void{


    this.cart.orderProducts.find(a=>a===prods).quantity++;
    
   this.cart.quantityOfItems++;
   this.setTotalPrice();
  }

  decreaseQuantity(prods:OrderProduct): void{
    if(this.cart.orderProducts.filter(a=>a===prods).find(a=>a.quantity===1)){
       var i=0;
      for(var c=0;c<this.cart.orderProducts.length;c++){
        if(this.cart.orderProducts[c]==prods){
            i=c;
           // alert(i);
            break;
        }
      }
      this.cart.orderProducts.splice(i,1)
     // alert(i)
      if(this.cart.orderProducts.length===0){
        this.clearCart();
      }
    } else{
      this.cart.orderProducts.filter(a=>a===prods).map(a=>a.quantity===a.quantity--);
      this.cart.quantityOfItems--;
    }
    this.setTotalPrice();
  }

  setTotalPrice():number {
     if(this.cart.orderProducts.length!==0){
       return this.cart.totalPrice=this.cart.orderProducts.map(a=>a.product.price * a.quantity).reduce((a,b)=>{
         const price=a+b;
         return this.cart.totalPrice=price;
       });
     }
     return this.cart.totalPrice=0;
  }

  clearCart() {
    this.cart.orderProducts = [];
    this.cart.quantityOfItems = 0;
    this.cart.totalPrice = 0;
  }
  cartTotalItem(){
    return this.cart.orderProducts.length;
  }
}
