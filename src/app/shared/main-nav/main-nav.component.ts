import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../classes/currentUser';
import { UserService } from '../services/user.service';
import { Employee } from '../classes/employee';

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css']
})
export class MainNavComponent implements OnInit {
  public loggedUser: Employee;
  public username: string;
  public password: string;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.login(null,null).subscribe(
      resp => {
        this.loggedUser = resp;
      },
      error => {
        this.loggedUser = null;
      }
    );
  }

  login() {
    console.log("Calling the login method");
    console.log(this.username);
    console.log(this.password);
    this.userService.login(this.username, this.password).subscribe(
      resp => {
          this.loggedUser = resp;
      }
    );
  }

  logout() {
    this.userService.logout().subscribe(
      resp => {
        this.loggedUser = null;
      }
    )
  }
}
