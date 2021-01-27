// import axios from 'axios'
import Axios from  'axios-observable';
import { Observable } from 'rxjs';

// import { Observable } from 'rxjs';
import { Employee } from '../model/Employee';


export default class EmployeeService {
	
	private readonly url: string = 'http://localhost:8082/employee-service/employees'
	// private employeeList: Employee[]=new Array();

	// public getReactiveEmployees(): any{	
    //     const requestOptions = {
    //         method: "GET",
    //         headers: { "Accept": "text/event-stream" }
    //       };
    //       Axios.defaults.headers.common['Accept']="text/event-stream";
	// 	return Axios.get<any>(this.url);
	
		
	// }

	public getEmployees(): Observable<any>{
		// const requestOptions = {
        //     method: "GET",
        //     headers: { "Accept": "application/json" }
        //   };
		Axios.defaults.headers.common['Accept']="application/json";
		Axios.defaults.headers.common['Content-Type']="application/json";
		return Axios.get<any>(this.url);
	}

	public createEmployee(employee: Employee): Observable<any>{	
		Axios.defaults.headers.common['Accept']="application/json";
		Axios.defaults.headers.common['Content-Type']="application/json";
		return Axios.post<any>(this.url,employee);
	}
}