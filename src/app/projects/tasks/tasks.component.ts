import { Component, OnInit } from '@angular/core';
import {Task} from '../tasks/Beans/task';
import { Project} from '../../projects/beans/project'
import { Employee } from '../../shared/classes/employee'
import { TaskService } from '../services/task.service';
import { ProjectsService } from '../services/projects.service';
import { UserService } from '../../shared/services/user.service';
import { ActivatedRoute } from '@angular/router';
import { Text } from '../../shared/classes/text';
import { Status } from './Beans/status';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  public projects: Project[];
  public project: Project;
  public tasks: Task[];
  public task: Task;
  public employee: Employee;
  public description: string;
  //public status: Status;
  //task = new Task();
  text = new Text();
  status = new Status();

  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private taskService: TaskService,
    private projectsService: ProjectsService
  ) { }

  ngOnInit(): void {
    this.task = new Task();
    this.employee = this.userService.getEmployee();


    this.taskService.getTasks().subscribe(
      (t) => {
        this.tasks = t;
        console.log(t)
      }
    )
    const id = +this.route.snapshot.paramMap.get('id');
    this.projectsService.getProject(id).subscribe(
      (p) => {
        this.project = p;
        console.log(p);
      }
    )
      this.projectsService.getProjects().subscribe(
        (p) => {
          //may need to change to forEach, refer to task-drag-and-drop
          this.projects = p;
          // console.log(this.projects.id)
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
    this.task.projId = +this.route.snapshot.paramMap.get('id');
    console.log("this.task.projId is " +this.task.projId)
    this.text.text = this.description
    console.log(this.description+" is description");
    console.log(this.text.text);
    this.task.description = this.text
    console.log("this.task.description. is " +JSON.stringify(this.task.description));
    // let id = 1;
    this.status.id = 1;
    // this.status.statLevel = 'Not Assigned';
    this.task.status = this.status;
    console.log(JSON.stringify(this.status) +" is this.status")
    this.taskService.createTask(this.task).subscribe(
      resp => {
        //this.task = new Task();
        console.log(resp+" before this.task resp")
        resp=this.task;
        //this.tasks.push(resp);
        console.log("submitted task: " + resp );
      }
    );
  }
}
