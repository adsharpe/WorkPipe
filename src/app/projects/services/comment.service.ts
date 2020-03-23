import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from 'src/app/shared/url.service';
import { ProjectComment } from '../beans/project-comment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ProjectsComponent } from '../projects.component';
import { TextService } from 'src/app/shared/services/text.service';
import { Text } from '@angular/compiler/src/i18n/i18n_ast';
import { Project } from '../beans/project';

@Injectable()
export class CommentService {
 private projectCommentUrl = this.urlService.getUrl() + "messages";
 private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getProjectMessages(): Observable<ProjectComment[]>{
    return this.http.get(this.projectCommentUrl, {withCredentials: true})
     .pipe(map(
       resp => resp as ProjectComment[]
     ));
  }

  submitProjectMessage(text: ProjectComment): Observable<ProjectComment>{
    const body = JSON.stringify(text);
    console.log(body);
      return this.http.post(this.projectCommentUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map( resp => resp as ProjectComment )
      );
  }
}
