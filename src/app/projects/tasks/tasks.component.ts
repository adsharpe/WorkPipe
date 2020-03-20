import { Component, OnInit } from '@angular/core';
import {Task} from '../tasks/Beans/task';
import { TaskService } from '../services/task.service';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  tasks: Task[];
  task: Task;
  constructor(
    private taskService: TaskService,
    private userService: UserService
  ) { }

  ngOnInit(): void {
    this.task = new Task();
    this.taskService.getTasks().subscribe(
      (t) => {
        this.tasks = t;
      }
    )
  }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }
  isSupervisor(): boolean {
    return this.userService.isSupervisor();             
  }

//this method add and updates task, by checking if submited task has ID
  submit(): void {
    this.taskService.updateTask(this.task).subscribe(
      resp => {
        this.task = new Task();
        this.tasks.push(resp);
        console.log("submitted task: " + resp );
      }
    );
  }
}
