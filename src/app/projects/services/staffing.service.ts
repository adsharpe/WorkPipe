import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { UrlService } from '../../shared/url.service';
import { Observable } from 'rxjs';
import { ProjectEmployee } from '../beans/project-employee';
import { map } from 'rxjs/operators';


@Injectable()
export class StaffingService {
  private appUrl = this.urlService.getUrl() + "staffing";
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  createProjectEmployee(projectEmployee : ProjectEmployee) : Observable<ProjectEmployee> {
    return this.http.post(this.appUrl, projectEmployee, { withCredentials: true})
     .pipe(map(resp => resp as ProjectEmployee));
  }

  getProjectEmployees() : Observable<ProjectEmployee[]>{
    return this.http.get(this.appUrl, { withCredentials: true})
     .pipe(map(resp => resp as ProjectEmployee[]));
  }

  getProjectEmployeeByProject(project : ProjectEmployee): Observable<ProjectEmployee[]>{
    let params = new HttpParams().set('project', encodeURIComponent(JSON.stringify(project)));
    console.log(params);
    return this.http.get(this.appUrl, { withCredentials: true})
     .pipe(map(resp => resp as ProjectEmployee[]));
  }

  updateProjectEmployee(projectEmployee : ProjectEmployee) {
    return this.http.put(this.appUrl, projectEmployee, { withCredentials: true});
  }
}
