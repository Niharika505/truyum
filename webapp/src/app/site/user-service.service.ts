import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from './auth-service.service';
import { user } from '../user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClientService, User } from './httpclient.service';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  userList = [
    {username:'admin',firstname:"admin",lastname:"admin",password:"admin123"},
    {username:'Niharika',firstname:"uppala",lastname:"Niharika",password:"Niharika"}
  ];
 
  
  constructor(private router:Router,private authService : AuthServiceService,private httpClient:HttpClientService) { }

  getUser(username:string){
    let user = this.userList.filter((user)=>(user.username==username));
    return user[0];
  }

  addCartlist(list : number){
    this.authService.addCart(list);
  }
  addUser(userList : User){
    console.log(userList);
    this.httpClient.addUser(userList).subscribe(
      data => {
        this.router.navigate(['login']);
      }
    );
  }
}
