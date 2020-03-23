import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from 'src/app/shared/url.service';
import { Observable } from 'rxjs';
import { Project } from '../beans/project';
import { map } from 'rxjs/operators';

@Injectable()
export class ProjectsService {
  private appUrl = this.urlService.getUrl() + "projects";
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  public project: Project;

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getProjects(): Observable<Project[]>{
    return this.http.get(this.appUrl, { withCredentials: true})
     .pipe(map(
       resp => resp as Project[]
     ));
  }

  getProject(): Project{
    return this.project;
  }
}
