import { Component, OnInit } from '@angular/core';
import {Task} from '../tasks/Beans/task';
import { Project} from '../../projects/beans/project'
import { Employee } from '../../shared/classes/employee'
import { TaskService } from '../services/task.service';
import { ProjectsService } from '../services/projects.service';
import { UserService } from '../../shared/services/user.service';


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  projects: Project[];
  tasks: Task[];
  task: Task;
  currUser: Employee;
  constructor(
    private userService: UserService,
    private taskService: TaskService,
    private projectsService: ProjectsService
  ) { }

  ngOnInit(): void {
    this.task = new Task();
    this.taskService.getTasks().subscribe(
      (t) => {
        this.tasks = t;
      }
    )
      this.projectsService.getProjects().subscribe(
        (p) => {
          this.projects = p;
        }
      )
      // this.currUser = this.userService.getEmployee()
      console.log(this.userService.isEmployee());
      
  }

  getUser(): Employee {
    return this.userService.getEmployee();
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
