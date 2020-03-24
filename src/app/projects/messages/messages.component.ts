import { Component, OnInit} from '@angular/core';
import { UserService } from 'src/app/shared/services/user.service';
import { Text } from 'src/app/shared/classes/text';
import { TextService } from 'src/app/shared/services/text.service';
import { CommentService } from '../services/comment.service';
import { ProjectComment } from '../beans/project-comment';
import { ProjectsService } from '../services/projects.service';
import { Project } from '../beans/project';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/shared/classes/employee';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  comments: ProjectComment[];
  comment: ProjectComment;
  project = new Project();
  text = new Text();
  loggedUser: Employee;
  public userComment: string;

  newComment = new ProjectComment();
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private commentService: CommentService,
    private projectsService: ProjectsService,

  ) { }

  ngOnInit(): void {
   this.userService.login(null,null).subscribe(
    resp => {
      this.loggedUser = resp;
    },
    error => {
      this.loggedUser = null;
    }
  );

   const id = +this.route.snapshot.paramMap.get('id');
   this.projectsService.getProject(id).subscribe(
     (p) => {
       this.project = p;
       console.log(p);
     }
   )

   this.comment = new ProjectComment();
   this.commentService.getProjectMessages().subscribe(
     (c) => {
       this.comments = c;
       this.comments.sort( (c1, c2) => c1.id - c2.id);
       console.log(this.comments);
     }
   )
  }


  submit(){
    console.log(this.loggedUser);
    console.log(this.userComment);
    this.text.textstring = this.userComment;
    this.newComment.textId = this.text;
    this.project.id = +this.route.snapshot.paramMap.get('id');;
    this.newComment.projects = this.project;
    this.newComment.empId = this.loggedUser;
    console.log("New Comment info: " + this.newComment);
    this.commentService.submitProjectMessage(this.newComment).subscribe(
      resp => {
        resp = this.newComment;
      }
    )
  }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }

}
