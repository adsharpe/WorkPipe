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

  createProject(project : Project) : Observable<Project> {
    return this.http.post(this.appUrl, project, { withCredentials: true})
     .pipe(map(
       resp => resp as Project
     ));
  }

  getProjects() : Observable<Project[]>{
    return this.http.get(this.appUrl, { withCredentials: true})
     .pipe(map(
       resp => resp as Project[]
     ));
  }

<<<<<<< HEAD
  getProject(): Project{
    return this.project;
  }
=======
  getProject(projectID : Number): Observable<Project>{
    return this.http.get(this.appUrl + '/' + projectID,  { withCredentials: true})
     .pipe(map(
       resp => resp as Project
     ));
  }

  updateProject(project : Project) {
    return this.http.put(this.appUrl, project, { withCredentials: true});
  }
  
  /*
   * I'm not sure how to submit a delete request with an object that's supposed to be deleted.
   * Until that's figured out, this will remain commented out.
   * 
  deleteProject(project : Project) {
    return this.http.delete(this.appUrl, { withCredentials: true});
  }
   */
>>>>>>> 8e7857827017e482d01d3ab31277e4f5e75aee82
}
