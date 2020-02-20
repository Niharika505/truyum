import { Injectable, Output, EventEmitter } from '@angular/core';
import { cart } from './cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  @Output() cartUpdated = new EventEmitter();


  cart:cart={fooditem:[],total:0};


  constructor() { }

  getAllcart():cart{
    return this.cart;
  }
  calculateTotal()
  {
    this.cart.total=0;
    for(let i=0;i<this.cart.fooditem.length;i++)
    {
      this.cart.total += this.cart.fooditem[i].price;
    }
    this.cartUpdated.emit;
  }
}
