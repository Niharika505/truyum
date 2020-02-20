import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { fooditem } from '../fooditem';
import { cart } from '../shopping/cart';
import { environment } from 'src/environments/environment';


export class MenuItems{
  constructor(
    public id: number,
    public name:String,
    public price:number,
    public active:boolean,
    public dateOfLaunch:Date,
    public category:String,
    public freeDelivery:boolean,
    public image:String,
  ) {}
}
export interface User {
  username:String,
   password:String,
   firstname:String,
   lastname:String,
  confirmPassword:String,
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient:HttpClient
  ) { 
     }
     

     getEmployees() :Observable<fooditem[]>
  {
       return this.httpClient.get<fooditem[]>(environment.baseUrl);
  }

  getMenuItem(id : number) :Observable<fooditem>{
    return this.httpClient.get<fooditem>(environment.baseUrl+'/'+id);
  }

  ModifyMenuItem(menuItem : fooditem) {
    console.log(menuItem.name);
    return this.httpClient.put<fooditem>(environment.baseUrl ,menuItem);
  } 
  
  addCartItem(name :String, menuItemId : number){
    console.log(name+" "+menuItemId);
    return this.httpClient.post(environment.cartsUrl+name+'/'+menuItemId,menuItemId);
  }

  getCartItem(name : String) {
    console.log(name);
    return this.httpClient.get<cart>(environment.cartsUrl+name);
  }

  deleteCartItem(name :String, menuItemId : number){
    console.log(name+" " +menuItemId);
    return this.httpClient.delete<cart>(environment.cartsUrl+name+'/'+menuItemId);
  }
  addUser(userList : User) :Observable<User>{
    console.log(userList);
    return this.httpClient.post<User>(environment.users,userList);
  }
  
}