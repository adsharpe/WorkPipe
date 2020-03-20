import { Injectable } from '@angular/core';
import { UrlService } from '../url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class TextService {
private appUrl = this.urlService.getUrl() + "messages";
private headers = new HttpHeaders({
  'Content-Type': 'application/json'
});
  constructor(
    private urlService: UrlService,
    private http: HttpClient
  ) { }

  getTexts(): Observable<Text[]>{
    return this.http.get(this.appUrl, {withCredentials: true} ).pipe(
      map( resp => resp as Text[] )
    );
  }

  getText(id: number): Observable<Text>{
    const url: string = this.appUrl + '/' + id;
    return this.http.get(url, {withCredentials: true}).pipe(
      map(resp => resp as Text)
    );
  }
}
