import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { address } from '../model/address';
import { Cart } from '../model/cart';
import { order } from '../model/order';
import { user } from '../model/user';
import { AddresserviceService } from '../services/addresservice.service';
import { CartserviceService } from '../services/cartservice.service';
import { OrderserviceService } from '../services/orderservice.service';
import { TokenserviceService } from '../services/tokenservice.service';

@Component({
  selector: 'app-proceedpage',
  templateUrl: './proceedpage.component.html',
  styleUrls: ['./proceedpage.component.css']
})
export class ProceedpageComponent implements OnInit {
  public myForm: FormGroup;
  public rzp1;
  public user: user;
  public cart: Cart;
  public type;
  public address: {
    id: number;
    landmark: string;
    streetname: string;
    city: string;
    pincode: number;
    addresstype: string;
  };
  public order: order;
  public paymentId;
  constructor(private orderservice: OrderserviceService, private tokenservice: TokenserviceService, private cartservice: CartserviceService, private addservice: AddresserviceService, private router: Router) {
    this.myForm = new FormGroup({
      addresstype: new FormControl(''),
      streetname: new FormControl('', [Validators.required, Validators.maxLength(20)]),
      landmark: new FormControl('', [Validators.required, Validators.maxLength(20)]),
      pincode: new FormControl('', [Validators.required, Validators.maxLength(10)]),
      city: new FormControl('', [Validators.required, Validators.maxLength(10)]),
      paymentmode: new FormControl('')
    }
    );
  }
  hide = true;
  public myError = (controlName: string, errorName: string) => {
    return this.myForm.controls[controlName].hasError(errorName);
  }

  ngOnInit(): void {
    this.user = JSON.parse(this.tokenservice.getUser());
    this.cart = this.cartservice.getCartData();
  }
  public options = {
    "key": "rzp_test_GDbKLVOFUh8BSb", // Enter the Key ID generated from the Dashboard
    "amount": "2222",
    "currency": "INR",
    "description": "Acme Corp",
    "image": "https://s3.amazonaws.com/rzp-mobile/images/rzp.png",
    "prefill":
    {
      "email": "gaurav.kumar@example.com",
      "contact": +919900000000,
    },
    config: {
      display: {
        blocks: {
          hdfc: { //name for HDFC block
            name: "Pay using HDFC Bank",
            instruments: [
              {
                method: "card",
                issuers: ["HDFC"]
              },
              {
                method: "netbanking",
                banks: ["HDFC"]
              },
            ]
          },
          other: { //  name for other block
            name: "Other Payment modes",
            instruments: [
              {
                method: "card",
                issuers: ["ICIC"]
              },
              {
                method: 'netbanking',
              }
            ]
          }
        },
        hide: [
          {
            method: "upi"
          }
        ],
        sequence: ["block.hdfc", "block.other"],
        preferences: {
          show_default_blocks: false // Should Checkout show its default blocks?
        }
      }
    },
    "handler": this.makeOrder.bind(this),
    "modal": {
      "ondismiss": function () {
        if (confirm("Are you sure, you want to close the form?")) {
          // txt = "You pressed OK!";
          console.log("Checkout form closed by the user");
        } else {
          // txt = "You pressed Cancel!";
          console.log("Complete the Payment")
        }
      }
    }
  };


  public makeOrder(respone) {

    this.order = {
      id: null,
      user: this.user,
      products: this.cart.orderProducts,
      quantity: this.cart.quantityOfItems,
      price: this.cart.totalPrice,
      orderdate: null,
      paymentMode: { id: 1, paymentMode: 'upi' },
      address: this.address,
      orderStatus: { id: 1, orderStatus: 'palced' },
      paymentId: respone.razorpay_payment_id
    }
    var data = JSON.stringify(this.order);

    this.orderservice.makeOrder(data).subscribe(data => window.location.replace("/#/orderhistory"))

  }

  get F() {
    return this.myForm.controls;
  }

  public pay() {


    this.options.amount = this.cart.totalPrice * 100 + "";
    this.options.prefill.email = this.user.email;
    this.options.prefill.contact=this.user.mobile;
    this.rzp1 = new this.orderservice.nativeWindow.Razorpay(this.options);




    this.rzp1.open();

  }
  public show(type) {
    this.addservice.getAddressByType(this.user.id, type).subscribe((data: address) => this.address = data)
    this.addservice.getAddressByType(this.user.id, type).subscribe((data: address) => this.myForm.patchValue({
      addresstype: data.addresstype,
      streetname: data.streetname,
      landmark: data.landmark,
      pincode: data.pincode,
      city: data.city
    }));

  }

}

