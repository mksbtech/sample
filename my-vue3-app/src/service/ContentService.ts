import axios from 'axios'
import Axios from  'axios-observable';
import { Observable } from 'rxjs';
import { Restaurant } from './dto/restaurant';

export default class CarService {

    private readonly url: string = 'http://localhost:1337/restaurants'
	getCMSContent() {
      return  axios.get(this.url);                            
	}

	public getRestaurants(): Observable<any>{			 
		return Axios.get<any>(this.url);
	
	}

	// getCarsMedium() {
	// 	return axios.get('demo/data/cars-medium.json').then(res => res.data.data);
	// }

	// getCarsLarge() {
	// 	return axios.get('demo/data/cars-large.json').then(res => res.data.data);
	// }
}