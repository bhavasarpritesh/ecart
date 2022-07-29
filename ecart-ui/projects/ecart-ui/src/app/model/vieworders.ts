import { OrderProduct } from "./orderproduct";
import { paymentmode } from "./paymentmode";
import { user } from "./user";

export interface vieworders{
    id: number;
    username: user;
    product: OrderProduct;
    quantity: number;
    totalamount: number;
    orderdate: Date;
    paymentmode: paymentmode;
}