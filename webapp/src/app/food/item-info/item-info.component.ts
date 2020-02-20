import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { fooditem } from 'src/app/fooditem';
import { FoodService } from '../food.service';
import { HttpClientService, MenuItems } from 'src/app/site/httpclient.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/site/user-service.service';

@Component({
  selector: 'app-item-info',
  templateUrl: './item-info.component.html',
  styleUrls: ['./item-info.component.css']
})
export class AppFoodItemInfoComponent implements OnInit{
  

  @Input() item:fooditem;
  @Input() items:fooditem;
  @Output() addToCartclicked:EventEmitter<number> = new  EventEmitter<number>();
  isAdmin:boolean;
  name:String;
  list : Number;

  constructor(private _foodservice:FoodService,private authService : AuthServiceService,private httpClient : HttpClientService,private router : Router,private userService : UserServiceService){}

  ngOnInit(){
    this.isAdmin=this._foodservice.isAdmin;
  }


  onAddToCart(itemId:number){
    if(this.ifAdmin()){
    this.name = this.authService.username;
  this.httpClient.addCartItem(this.name,itemId).subscribe(
    data => {
      alert('Added');
    }
  )
    }
    else{
     this.userService.addCartlist(itemId);
      this.router.navigate(['login']);
    }
}

    ifAdmin() :boolean{
        if(this.authService.isUserLoggedIn()){
          if(this.authService.username == "admin"){
            this.isAdmin=true;
          }
          else{
            this.isAdmin=false;
          }
          return true;
        }
        return false;
    }

}
