import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../classes/currentuser';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loggedUser: Currentuser;
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
