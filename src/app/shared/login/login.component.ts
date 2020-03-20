import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../classes/currentUser';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  implements OnInit{
  public loggedUser: Currentuser;
  public username: string;
  public password: string;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.login();
  }

  login() {
    console.log("Calling the login method");
    console.log(this.username);
    console.log(this.password);
    this.userService.login(this.username, this.password).subscribe(
      resp => {
        // if(Currentuser)
        console.log("wait a little bit");
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
