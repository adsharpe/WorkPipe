import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Task } from '../../projects/tasks/Beans/task';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from '../../shared/url.service';

// @Injectable({
//   providedIn: 'root'
// })
@Injectable()
export class TaskService {
  private appUrl = this.urlService.getUrl() + 'tasks';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin':'*',
    // 'Access-Control-Allow-Methods':['POST', 'GET', 'PUT', 'DELETE']
   });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getTasks(): Observable<Task[]>{
    return this.http.get(this.appUrl, { withCredentials: true })
    .pipe(map(resp => resp as Task[]));
  }
  getTask(id: number): Observable<Task> {
    return this.http.get(this.appUrl + '/' +id, {withCredentials:true})
    .pipe(map(resp => resp as Task))
  }
  updateTask(updatedTask: Task): Observable<Task> {
    const body = JSON.stringify(updatedTask);
    return this.http.put(this.appUrl, body, {
        headers: this.headers,
        withCredentials: true
        }).pipe(
          map(resp => resp as Task)
        );
    }
  createTask(task: Task): Observable<Task> {
  const body = JSON.stringify(task);
  console.log("task is " +task);
  console.log("body is " +body);
  return this.http.post(this.appUrl, body, {
      headers: this.headers,
      withCredentials: true
      }).pipe(
        map(resp => resp as Task)
      );
  }



  // updateTask(updatedTask: Task): Observable<Task>{
  //   let body = JSON.stringify(updatedTask);
  //   console.log("from drag and drop function"+body);
  //   return this.http.put(this.appUrl, body, { headers: this.headers, withCredentials: true})
  //    .pipe(map(resp => resp as Task));
  // }

  //old
  // updateTask(updatedTask: Task): Observable<Task>{
  //   console.log(updatedTask.id)
  //   let url = this.appUrl + 'tasks/' + updatedTask.id;
  //   const body = JSON.stringify(updatedTask);
  //   // console.log("this is the body"+body)
  //   return this.http.put(url, body, {headers: this.headers, withCredentials: true}).pipe(map(resp => resp as Task))
  // }
  // updateTask(task: Task): Observable<Task>{
  //   const body = JSON.stringify(task);
  //   if(!task.id){
  //     return this.http.post(this.appUrl, body,
  //       {headers: this.headers, withCredentials: true})
  //       .pipe(map(resp => resp as Task));
  //   } else {
  //     const url = this.appUrl + '/' + task.id;
  //     return this.http.put(url, body, {headers: this.headers, withCredentials: true})
  //     .pipe(map(resp => resp as Task))
  //   }
  // }
}
