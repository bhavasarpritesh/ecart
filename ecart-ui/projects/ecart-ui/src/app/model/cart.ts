import { OProduct } from "./oproduct";
import { OrderProduct } from "./orderproduct";
import { productcard } from "./productcard"

export class Cart{
    orderProducts: OProduct[];
    quantityOfItems:number;
    totalPrice: number;
}