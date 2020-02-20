import { Component, OnInit } from '@angular/core';
import { fooditem } from 'src/app/fooditem';
import { FoodService } from '../../food.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { HttpClientService } from 'src/app/site/httpclient.service';

@Component({
  selector: 'app-food-item-edit-component',
  templateUrl: './food-item-edit-component.component.html',
  styleUrls: ['./food-item-edit-component.component.css']
})
export class FoodItemEditComponentComponent implements OnInit {


   fooditem:fooditem;// {id: null, name: null, price: null, active: null, DateOfLaunch:new Date('2017-02-02'), category: null, freedelivery: null, image: null};
   menuItem :fooditem;
   form:FormGroup;
   id : number;
  categories=["Main course","Starters","Dessert","Drink"];

  constructor(private fb: FormBuilder,private foodservice:FoodService,private route : ActivatedRoute,private httpClient : HttpClientService,private router : Router) {

   }

  ngOnInit() {

    const foodItemId=this.route.snapshot.paramMap.get('id');
    this.id = parseInt(foodItemId.toString());
    this.httpClient.getMenuItem(this.id).subscribe(
      data => {
        this.menuItem = data;
      }
    )
    this.fooditem=this.foodservice.getfooditems(+foodItemId);
    this.fooditem.DateOfLaunch.setDate(this.fooditem.DateOfLaunch.getDate()+1);
    this.form=this.fb.group({
      title:[this.fooditem.name,[Validators.required,Validators.maxLength(200)]],
      photoURL:[this.fooditem.image,[Validators.required]],
      price:[this.fooditem.price,[Validators.required]],
      DateOfLaunch:[this.fooditem.DateOfLaunch.toISOString().substring(0,10),[Validators.required]],
      category:[this.fooditem.category,[Validators.required]],
      active:[this.fooditem.active,[Validators.required]],
      freeDelivery:[this.fooditem.freedelivery]
    })

  }

  get title(){
    return this.form.get('title');
  }

  get photoURL(){
    return this.form.get('photoURL');
  }
  get price(){
    return this.form.get('price');
  }
  get DateOfLaunch(){
    return this.form.get('DateOfLaunch');
  }
  get category(){
    return this.form.get('category');
  }
  get active(){
    return this.form.get('active');
  }
  get freeDelivery(){
    return this.form.get('freeDelivery');
  }

  onSubmit(){
    console.log(this.menuItem);
    this.httpClient.ModifyMenuItem(this.menuItem).subscribe(
      data =>{
        alert('Edited successfully');
      }
    );
    this.router.navigate(['menu']);
  }

  }

