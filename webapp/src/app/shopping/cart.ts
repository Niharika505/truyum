import { fooditem } from "../fooditem";

export interface cart
{
    fooditem:fooditem[];
    total:number;
}