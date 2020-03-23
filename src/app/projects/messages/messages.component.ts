import { Component, OnInit} from '@angular/core';
import { UserService } from 'src/app/shared/services/user.service';
import { Text } from 'src/app/shared/classes/text';
import { TextService } from 'src/app/shared/services/text.service';
import { CommentService } from '../services/comment.service';
import { ProjectComment } from '../beans/project-comment';
<<<<<<< HEAD
import { Project } from '../beans/project';
import { ProjectsService } from '../services/projects.service';
=======
>>>>>>> 8e7857827017e482d01d3ab31277e4f5e75aee82

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  project: Project;
  projects: Project[];
  comments: ProjectComment[];
  comment: ProjectComment;
  public userComment: string;
  constructor(
    private userService: UserService,
    private commentService: CommentService,
    private projectService: ProjectsService
  ) { }

  ngOnInit(): void {
  this.projectService.getProjects().subscribe(
    (p) => {
      this.projects = p;
      this.project = this.projects[0];
      console.log(this.project)
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
    this.commentService.submitProjectMessage(this.comment).subscribe(
      resp => {
        this.project;
        this.comment = new ProjectComment();
        this.comments.push(resp);
      }
    )
  }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }

}
