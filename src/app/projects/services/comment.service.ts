import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from 'src/app/shared/url.service';
import { ProjectComment } from '../beans/project-comment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class CommentService {
 private appUrl = this.urlService.getUrl() + "messages";
 private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getProjectMessages(): Observable<ProjectComment[]>{
    return this.http.get(this.appUrl, {withCredentials: true})
     .pipe(map(
       resp => resp as ProjectComment[]
     ));
  }

  getProjectMessagesbyID(id: number){
    const url: string = this.appUrl + '/' + id;
    console.log("The url is : " + url)
    return this.http.get(url, {withCredentials: true}
      ).pipe(map(
      resp => resp as ProjectComment[]
    ));
  }

  submitProjectMessage(projectComment: ProjectComment): Observable<ProjectComment>{
    const body = JSON.stringify(projectComment);
    console.log("The user comment is: " + JSON.stringify(projectComment))
    console.log(body);
      return this.http.post(this.appUrl, body,{ 
        headers: this.headers, 
        withCredentials: true 
      }).pipe(
        map( resp => resp as ProjectComment )
      );
  }
}
