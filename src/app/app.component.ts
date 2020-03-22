import { Component } from '@angular/core';
import { Employee } from './shared/classes/employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'WorkPipe-FontEnd';
  public loggedUser: Employee;
}
