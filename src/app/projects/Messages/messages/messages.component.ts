import { Component, OnInit} from '@angular/core';
import { UserService } from 'src/app/shared/services/user.service';
import { Text } from 'src/app/shared/classes/text';
import { TextService } from 'src/app/shared/services/text.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  texts: Text[];
  text: Text;
  constructor(
    private userService: UserService,
    private textService: TextService,
  ) { }

  ngOnInit(): void {
   this.text = new Text();
   this.textService.getTexts().subscribe(
    (t) => {
      this.texts = t;
      this.texts.sort( (t1, t2) => t1.id - t2.id);
    });
  }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }

}
