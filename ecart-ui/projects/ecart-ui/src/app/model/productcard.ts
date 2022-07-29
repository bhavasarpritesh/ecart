export interface productcard{
    id: number;
    productname: string;
    price: number;
    description: string;
    quantity: number;
    status: number;
    category: {id:number,category:string};
    image: string;
    

}