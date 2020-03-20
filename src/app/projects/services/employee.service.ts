import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/shared/classes/employee';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  url = "http://localhost:8080/workpipe";

  constructor(private http: HttpClient) { }
  //make the HTTP call

  //make a new method to get the employees
  //create the observable we can subscribe to in the project-form component.ts file
  getEmployeeList(): Observable<Array<Employee>> {

    //this logs, so we know we're getting to the service
    //what about the backend?
    console.log("employee service ts log");

    //return this.http.get<Employee[]>(this.url);

    return this.http.get(this.url + '/employee', {withCredentials: true}).pipe(
      map(resp => resp as Employee[])
   );
  }
}
