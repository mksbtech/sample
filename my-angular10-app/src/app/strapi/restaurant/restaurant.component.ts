import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Restaurant} from '../../services/restaurant';
import {RestaurantService} from '../../services/restaurant.service';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.scss']
})
export class RestaurantComponent implements OnInit {
  @Input()
  restaurantList = new Array<Restaurant>();

  @Input()
  cols: string[] = ['Id', 'Name', 'Description'];

  private count: number;
  private offset: number;

  private restaurantService: RestaurantService;


constructor(private route: ActivatedRoute, restaurantService: RestaurantService ) {
  this.restaurantService = restaurantService;
 this.route = route;
}

ngOnInit(): void {
 this.count = parseInt(this.route.snapshot.queryParamMap.get('count'), 10);
 this.offset = parseInt(this.route.snapshot.queryParamMap.get('offset'), 10);
 console.log('count = ' + this.count);
 console.log('offset = ' + this.offset);
 // tslint:disable-next-line: use-isnan

 this.restaurantService.getRestaurants().subscribe(response =>
     {
        this.restaurantList = response.map(item =>
         {
           return new Restaurant(
               item.id,
               item.Name,
               item.description
           );
         });
     });

}

}
