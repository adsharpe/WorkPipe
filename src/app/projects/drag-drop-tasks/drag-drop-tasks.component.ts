import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import {MatDialog} from '@angular/material/dialog';
import {Task} from '../tasks/Beans/task';
import { TaskService } from '../services/task.service';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-drag-drop-tasks',
  templateUrl: './drag-drop-tasks.component.html',
  styleUrls: ['./drag-drop-tasks.component.css'],
})

export class DragDropTasksComponent implements OnInit {
  task: Task;
  tasks: Task[];
  todo: Task[];
  constructor(
    private taskService: TaskService,
    private userService: UserService
  ) {}


  done = [
    'Get up',
    'Brush teeth',
    'Take a shower'
  ];

  review = [
    'Check e-mail',
    'Walk dog',
    'Go home',
    'Fall asleep'
  ];

  ngOnInit(): void {
    //complete task drag and drop
    this.tasks = [];
    this .task = new Task();
    this.taskService.getTasks().subscribe(
      (t) => {
        this.tasks = t;
        // this.task
      }
    )



    this.todo = [];
    let t = new Task();
    t.id = 1;
    this.todo.push(t);
    t = new Task();
    t.id = 2;
    this.todo.push(t);
  }

  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
          event.container.data,
          event.previousIndex,
          event.currentIndex);
    }
  }
}
// @Component({
//   selector: 'dialog-content-example-dialog',
//   templateUrl: 'dialog-content-example-dialog.html',
// })                                                                                                                                                                                                                                                        
// export class DialogContentExampleDialog {}
