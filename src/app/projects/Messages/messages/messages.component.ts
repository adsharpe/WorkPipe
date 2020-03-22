import { Component, OnInit} from '@angular/core';
import { UserService } from 'src/app/shared/services/user.service';
import { Text } from 'src/app/shared/classes/text';
import { TextService } from 'src/app/shared/services/text.service';
import { CommentService } from '../../services/comment.service';
import { ProjectComment } from '../../beans/project-comment';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  comments: ProjectComment[];
  comment: ProjectComment;
  public userComment: string;
  constructor(
    private userService: UserService,
    private commentService: CommentService,
  ) { }

  ngOnInit(): void {
   this.comment = new ProjectComment();
   this.commentService.getProjectMessages().subscribe(
     (c) => {
       this.comments = c;
       console.log(this.comments);
     }
   )
  }


  submit(){
    this.commentService.submitProjectMessage(this.comment).subscribe(
      resp => {
        this.comment = new Text();
        this.
      }
    )
  }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }

}
