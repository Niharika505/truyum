import { Component, OnInit, Input, EventEmitter } from '@angular/core';
import { fooditem } from 'src/app/fooditem';
import { FoodService } from '../food.service';
import { MenuItems, HttpClientService } from 'src/app/site/httpclient.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  @Input() fooditem:fooditem[];
  isAdmin:boolean;
  @Input() menuItem : fooditem[];


  constructor(private _foodservice:FoodService,private httpClient : HttpClientService,private authService : AuthServiceService) { }
  
  addToCartclicked = new EventEmitter();
  ngOnInit() {
    this.isAdmin=this._foodservice.isAdmin;
    if(this.isAdmin)
    {

      this._foodservice.getFoodItem().subscribe(fooditem => this.fooditem=fooditem)

      this._foodservice.getSubject().subscribe(data =>{
        this.fooditem=this._foodservice.getItem(data)

      })

    }
    else{

      this._foodservice.getFoodItemsCust().subscribe(fooditem => this.fooditem=fooditem)

    this._foodservice.getSubject().subscribe(data =>{
      this.fooditem=this._foodservice.getItem(data)
    })

    
  }
  this.httpClient.getEmployees().subscribe(
    data => {
      this.menuItem = data;
    });
  }

  ifAdmin(): boolean{
    if(this.authService.isUserLoggedIn()){
      return true;
    }
    return false;
  }

  addToCart(itemId:number){

    this._foodservice.addToCart(itemId);
  }

}
