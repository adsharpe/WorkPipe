import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import {MatDialog} from '@angular/material/dialog';
import {Task} from '../tasks/Beans/task';
import { TaskService } from '../services/task.service';
import { UserService } from '../../shared/services/user.service';
import { Employee } from '../../shared/classes/employee';
import { Currentuser } from '../../shared/classes/currentUser'
import { ProjectsService } from '../services/projects.service';
import { Project } from '../beans/project';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-drag-drop-tasks',
  templateUrl: './drag-drop-tasks.component.html',
  styleUrls: ['./drag-drop-tasks.component.css'],
})

export class DragDropTasksComponent implements OnInit {
  project: Project;
  employee: Employee;
  public loggedUser: Currentuser;
  //Swap out for tasks
  // tasks: Task[];
  
  constructor(
    private taskService: TaskService,
    private userService: UserService,
    private projectsService: ProjectsService,
    private route: ActivatedRoute,
  ) {}

  //Drag-and-Drop
  todo: Task[];
  done : Task[];
  review: Task[];

  ngOnInit(): void {
    //complete task drag and drop
    this.employee = this.userService.getEmployee();
    console.log("this is the employee id: "+this.employee.id)
    this.project
    this.todo = [];
    this.done = [];
    // this.unassignedTask = new Task();
    
    this.taskService.getTasks().subscribe(
      (t) => {
        t.forEach( (task) => {
          if(task.projId === this.project.id){
            if(task.status.statLevel === "Not Assigned" ){
              this.todo.push(task)
              return
             }
             //
             if(task.status.statLevel === "completed"){
               //comeback and fix
               return
             }
             if(task.employee.id === this.employee.id){
              this.done.push(task)
              return
             }
          }

        });

        //assign all task with pending status to #todo
        //assign users task to done/doing
        //when task is tragged to users doing/done it changes the pending to assigned 
        // console.log(t)  
      }
    )
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.projectsService.getProject(id).subscribe(
      (p) => {
        this.project = p;
        console.log("this is current project id: "+ this.project.id);
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
          console.log(event.item.data);
          // this.taskService.updateTask();
    }
  }
}
