import { Component, OnInit } from '@angular/core';
import { cart } from '../cart';
import { CartService } from '../cart.service';
import { FoodService } from 'src/app/food/food.service';
import { HttpClientService } from 'src/app/site/httpclient.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {


  cart:cart;
  name:String;

  constructor(private authService : AuthServiceService,private _foodservice:FoodService,private httpClient :HttpClientService) {


   }

  ngOnInit() {

    this.httpClient.getCartItem(this.authService.username).subscribe(
      data => {
        this.cart = data;
        console.log(data);
      }
    )
  }

  removeFromCart(cartId :number){
    this.name=this.authService.username;
  this.httpClient.deleteCartItem(this.name,cartId).subscribe(
    data =>{
      this.cart = data;
      this. ngOnInit();
    }
  )};
}
