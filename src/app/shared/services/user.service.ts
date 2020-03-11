import { Injectable } from '@angular/core';
import { UrlService } from '../url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
<<<<<<< HEAD
=======
import { TeamLeader } from './classes/teamLeader';
>>>>>>> c614c3b1c53ceb7dbc5b8e5a0e7b24850a7097aa
import { Employee } from '../classes/employee';
import { Currentuser } from '../classes/currentuser';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class UserService {
  private appUrl  = this.url.getUrl() + 'login';
  private headers = new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  });
  private employee: Employee;

  constructor(
    private url: UrlService,
    private http: HttpClient
  ) { }

  login(username: string, password: string): Observable<Currentuser> {
    if (username && password) {
      // we are attempting to log in
      const body = `user=${username}&pass=${password}`;
      return this.http.post(this.appUrl, body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const user: Currentuser = resp as Currentuser;
          if (user) {
            this.employee = user.employee;
          }
          return user;
        })
      );
    } else {
      // checking to see if we're logged in
      return this.http.get(this.appUrl, {withCredentials: true}).pipe(
        map( resp => {
          const user: Currentuser = resp as Currentuser;
          if (user) {
            this.employee = user.employee;
          }
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
  isEmployee(): boolean {
    return (this.employee !== undefined && this.employee !== null);
  }
}