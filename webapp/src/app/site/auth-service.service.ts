import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { HttpClientService } from './httpclient.service';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  constructor(private httpClient:HttpClient,private httpService : HttpClientService) { }
  username : String;
  authenticate(username, password) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    console.log(headers);
    return this.httpClient.get('http://localhost:8062/authentication-service/authenticate',{headers}).pipe(
    map(
      userData => {
       sessionStorage.setItem('username',username);
       let authString = 'Basic ' + btoa(username + ':' + password);
       sessionStorage.setItem('basicauth', authString);
       return userData;
      }
    )
 
   );
 }
   isUserLoggedIn() :boolean{
     let user = sessionStorage.getItem('username')
     this.username = user;
     return !(user === null)
   }
 
   logOut() {
     sessionStorage.removeItem('username')
   }
   isAdmin() :boolean{
     if(sessionStorage.getItem('username') == 'admin'){
      return true;
     }
     return false;
   }

   addCart(id : number){
    this.httpService.addCartItem(this.username,id);
   }
}
