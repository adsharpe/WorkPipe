import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../beans/project';
import { map } from 'rxjs/operators';
import { UrlService } from 'src/app/shared/url.service';

@Injectable({
  providedIn: 'root'
})
export class ProjectFormService {
  private appUrl  = this.url.getUrl() + 'projects';
  //url = "http://localhost:8080/workpipe";
  private headers = new HttpHeaders({
    'Content-Type': 'application/json', //x-www-form-urlencoded',
    'Access-Control-Allow-Origin':'*',
    'Access-Control-Allow-Methods':['POST','GET','PUT','DELETE']
  });

  constructor(private url: UrlService, private http: HttpClient) { }

  createProject(project): Observable<Project> {

    console.log("creating a project...");

    // const body = `projectName=${project.projectName}&lead=${project.lead}&startdate=${project.startdate}&enddate=${project.enddate}`;
    const body = JSON.stringify(project);
    console.log("this is body" +body)
     console.log("this is project" +project)
    return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true}).pipe(map(resp => resp as Project));
  }
}
