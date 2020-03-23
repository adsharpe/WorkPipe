import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import {MatDialog} from '@angular/material/dialog';
import {Task} from '../tasks/Beans/task';
import { TaskService } from '../services/task.service';
import { UserService } from '../../shared/services/user.service';
import { Employee } from '../../shared/classes/employee';
import { Currentuser } from '../../shared/classes/currentUser'

@Component({
  selector: 'app-drag-drop-tasks',
  templateUrl: './drag-drop-tasks.component.html',
  styleUrls: ['./drag-drop-tasks.component.css'],
})

export class DragDropTasksComponent implements OnInit {
  
  employee: Employee;
  public loggedUser: Currentuser;
  //Swap out for tasks
  // tasks: Task[];
  
  constructor(
    private taskService: TaskService,
    private userService: UserService
  ) {}

  //Drag-and-Drop
  todo: Task[];
  done : Task[];
  review: Task[];

  ngOnInit(): void {
    //complete task drag and drop
    this.employee = this.userService.getEmployee();
    
    this.todo = [];
    this.done = [];
    // this.unassignedTask = new Task();
    
    this.taskService.getTasks().subscribe(
      (t) => {
        t.forEach( (task) => {
           console.log(task.status.statLevel)
           if(task.status.statLevel === "Not Assigned"){
            this.todo.push(task)
            return
           }
           //
           if(task.status.statLevel === "completed"){
             //comeback and fix
             return
           }
           if(this.employee.id === task.employee.id){
            this.done.push(task)
           }
        });

        //assign all task with pending status to #todo
        //assign users task to done/doing
        //when task is tragged to users doing/done it changes the pending to assigned 
        // console.log(t)  
      }
    )

  }

  getEmployee(): Employee {
    return this.employee;
  }
  //Drag and Drop functionality
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
