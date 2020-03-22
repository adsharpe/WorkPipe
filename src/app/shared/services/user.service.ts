import { Injectable, EventEmitter } from '@angular/core';
import { UrlService } from '../url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../classes/employee';
import { Currentuser } from '../classes/currentUser';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable()
export class UserService {
  private appUrl  = this.url.getUrl() + 'login';
  private headers = new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded',
    'Access-Control-Allow-Origin':'*',
    'Access-Control-Allow-Methods':['POST', 'GET', 'PUT', 'DELETE']
  });

  public employee: Employee;

  isLoggedIn = new EventEmitter();

  constructor(
    private url: UrlService,
    private http: HttpClient
  ) { }

  login(username: string, password: string): Observable<Employee> {
    if (username && password) {
      // we are attempting to log in
      const body = `user=${username}&pass=${password}`;
      return this.http.post(this.appUrl, body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const user: Employee = resp as Employee;
          if (user) {
            this.employee = user;
          }
          return user;
        })
      );
    } else {
      // checking to see if we're logged in
      return this.http.get(this.appUrl, {withCredentials: true}).pipe(
        map( resp => {
          const user: Employee = resp as Employee;

            this.employee = user;

          return user;
        })
      );
    }
  }
  logout(): Observable<object> {
    return this.http.delete(this.appUrl, {withCredentials: true}).pipe(
      map(success => {
        this.employee = null;
        return success;
      })
    );
  }

  getEmployee(): Employee {
    return this.employee;
  }
  getLoggedInUser() {
    this.isLoggedIn.emit(this.employee);
  }
  isEmployee(): boolean {
    return (this.employee !== undefined && this.employee !== null);
  }
  isSupervisor(): boolean {
    return (this.employee !== undefined && this.employee !== null);
  }
}
