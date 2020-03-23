import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../beans/project';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProjectFormService {
  url = "http://localhost:8080/workpipe";

  constructor(private http: HttpClient) { }

  createProject(project): Observable<Project> {

    console.log("creating a project...");

    const body = `projectname=${project.projectName}&lead=${project.lead}&startdate=${project.startdate}&enddate=${project.enddate}`;
      return this.http.post(this.url + '/projects', body, {withCredentials: true}).pipe(
        map(resp => resp as Project)
      );
  }
}
