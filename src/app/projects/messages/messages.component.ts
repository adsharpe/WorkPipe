import { Component, OnInit} from '@angular/core';
import { UserService } from 'src/app/shared/services/user.service';
import { Text } from 'src/app/shared/classes/text';
import { TextService } from 'src/app/shared/services/text.service';
import { CommentService } from '../services/comment.service';
import { ProjectComment } from '../beans/project-comment';
import { ProjectsService } from '../services/projects.service';
import { Project } from '../beans/project';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  comments: ProjectComment[];
  comment: ProjectComment;
  project: Project;
  public userComment: string;
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private commentService: CommentService,
    private projectsService: ProjectsService,

  ) { }

  ngOnInit(): void {
   this.comment = new ProjectComment();
   this.commentService.getProjectMessages().subscribe(
     (c) => {
       this.comments = c;
       console.log(this.comments);
     }
   )
   const id = +this.route.snapshot.paramMap.get('id');
   this.projectsService.getProject(id).subscribe(
     (p) => {
       this.project = p;
       console.log(p);
     }
   )
  }


  // submit(){
  //   this.commentService.submitProjectMessage(this.comment).subscribe(
  //     resp => {
  //       this.comment = new Text();
  //       this.
  //     }
  //   )
  // }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }

}
