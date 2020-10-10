import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subscription } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private restaurantListSubscription: Subscription;
  private readonly url: string = 'http://localhost:1337/restaurants';

  constructor(private httpClient: HttpClient) {
  }
  public getRestaurants(): Observable<any>{
    const headers =  {
      headers: new  HttpHeaders({
        'Content-Type': 'application/json',
      Accept : 'application/json'})
    };
    return this.httpClient.get<any>(this.url,
    headers);

  }
}
