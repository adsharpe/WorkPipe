import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { UrlService } from '../../shared/url.service';
import { Observable } from 'rxjs';
import { ProjectEmployee } from '../beans/project-employee';
import { Project } from '../beans/project';
import { map } from 'rxjs/operators';


@Injectable()
export class StaffingService {
  private appUrl = this.urlService.getUrl() + "staffing";
  private headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin':'*',
    'Access-Control-Allow-Methods':['POST, GET, PUT, DELETE, OPTIONS'],
    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
  });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  createProjectEmployee(projectEmployee : ProjectEmployee) : Observable<ProjectEmployee> {
    console.log('Creating projectEmployee');
    const body = JSON.stringify(projectEmployee);
    return this.http.post(this.appUrl, body, {
              headers: this.headers,
              withCredentials: true
    }).pipe(map(resp => resp as ProjectEmployee));
  }

  // getProjectEmployees() : Observable<ProjectEmployee[]>{
  //   console.log('Getting all projectEmployees');
  //   return this.http.get(this.appUrl, { withCredentials: true})
  //    .pipe(map(resp => resp as ProjectEmployee[]));
  // }

  getProjectEmployees(): Observable<ProjectEmployee[]>{
    console.log('Getting all projectEmployees');
    return this.http.get(this.appUrl, {
              headers: this.headers,
              withCredentials: true
    }).pipe(map(resp => resp as ProjectEmployee[]));
  }

  updateProjectEmployee(projectEmployee : ProjectEmployee) {
    console.log('Updating projectEmployee');
    return this.http.put(this.appUrl, projectEmployee, { withCredentials: true });
  }

  deleteProjectEmployee(projectEmployee : ProjectEmployee) {
    console.log('Deleting projectEmployee');
    return this.http.delete(this.appUrl, { withCredentials: true });
  }
}
