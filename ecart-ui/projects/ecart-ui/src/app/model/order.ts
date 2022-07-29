import { address } from "./address";
import { OProduct } from "./oproduct";
import { OrderProduct } from "./orderproduct";
import { orderstatus } from "./ordersatus";
import { paymentmode } from "./paymentmode";
import { user } from "./user";

export interface order{
    id: number;
    user: user;
    products: OProduct[];
    quantity: number;
    price: number;
    orderdate: Date;
    paymentMode: paymentmode;
    address:address;
    orderStatus:orderstatus;
    paymentId:string

}