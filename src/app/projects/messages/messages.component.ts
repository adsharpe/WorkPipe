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
import { ProjectsComponent } from '../projects.component';
import { ProjectComponent } from '../project/project.component';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  public comments: ProjectComment[];
  public comment: ProjectComment;
  public project: Project;
  public employee: Employee;
  public userComment: string;
  text = new Text();

  newComment = new ProjectComment();
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private commentService: CommentService,
    private projectsService: ProjectsService,

  ) { }

  ngOnInit(): void {
    this.project = new Project();
    this.comment = new ProjectComment();
    this.employee = this.userService.getEmployee();
    this.comment.projects = new Project();
    
   const id = +this.route.snapshot.paramMap.get('id');
   this.projectsService.getProject(id).subscribe(
     (p) => {
       this.project = p;
       console.log(p);
     }
   )

   //Displays comments only related to project id
   this.comment = new ProjectComment();
   this.commentService.getProjectMessages().subscribe(
     (c) => {
       c.forEach( (comment) => {
         if(comment.projects.id == +this.route.snapshot.paramMap.get('id')){
           this.comments = c;
         }
       })
       //Sort comments by desc order (lastest -> most recent)
       this.comments.sort( (c1, c2) => c1.id - c2.id);
     }
   )
  }


  submit(): void{
    this.project.id = +this.route.snapshot.paramMap.get('id');
    console.log("This project id is " + this.project.id);
    this.comment.projects.id = this.project.id;

    this.comment.empId.id = this.employee.id;

    this.text.textstring = this.userComment
    this.comment.textId = this.text; 
    console.log("New Comment info: " + JSON.stringify(this.comment));
    this.commentService.submitProjectMessage(this.comment).subscribe(
      resp => {
        resp = this.comment;
      }
    )
  }
}
