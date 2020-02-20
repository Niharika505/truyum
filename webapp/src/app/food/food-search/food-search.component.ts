import { Component, OnInit, Input } from '@angular/core';
import { FoodService } from '../food.service';
import { fooditem } from 'src/app/fooditem';
import { toBase64String } from '@angular/compiler/src/output/source_map';
import { HttpClientService } from 'src/app/site/httpclient.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-food-search',
  templateUrl: './food-search.component.html',
  styleUrls: ['./food-search.component.css']
})
export class FoodSearchComponent implements OnInit {

  constructor(private menuservice:FoodService,private httpClient : HttpClientService,private authService : AuthServiceService) { }
  @Input() filterlist:fooditem[];
  menu : fooditem[];
  subject = new Subject<string>(); 
  ngOnInit() {
  }
  search(event:any)
  {
    //this.menuservice.getItem(event.target.value).subscribe(filterlist => this.filterlist=filterlist)
    this.menuservice.getSubject().next(event.target.value)
    }
  
}
