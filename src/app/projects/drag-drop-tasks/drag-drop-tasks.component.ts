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

  unassignedTask: Task[];
  todo: Task[];
  
  //add task assigned to user
  done : Task[];

  review: Task[];

  ngOnInit(): void {
    //complete task drag and drop
    
    this.todo = [];
    // this.unassignedTask = new Task();
    
    this.taskService.getTasks().subscribe(
      (t) => {
        this.todo = t;
        console.log(t)

        
        //Only returns ID
        // for(let i = 0; i < t.length; i++){
        //   var eachTask=[];
        //   if(t[i].status.statLevel == "Not Assigned"){
            
        //   }
        // }
        
      }
    )
    // this.employee = new Employee();
    this.employee = this.userService.getEmployee();
    
    console.log(this.employee);
    // console.log(this.loggedUser);
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
