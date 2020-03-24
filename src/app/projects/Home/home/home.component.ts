import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/services/user.service';
import { TaskService } from '../../services/task.service';
import { ProjectsService } from '../../services/projects.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  allTasks = [];
  notAssigned = [];
  waitingApproval = [];
  constructor(
    private userService: UserService,
    private taskService: TaskService,
    private projectsService: ProjectsService
  ) { }

  ngOnInit(): void {
    //add service for task, project, emplyees
    //all tasks
    this.taskService.getTasks().subscribe(
      (t) => {
        t.forEach( (task) => {
           console.log(task.status.statLevel)
           if(task){
            this.allTasks.push(task)
            return
           }
           if(task.status.statLevel === "Not Assigned"){
            this.notAssigned.push(task)
            return
           }
           //
           if(task.status.statLevel === "Waiting Approval"){
            this.waitingApproval.push(task)
             return
           }
          //  if(this.employee.id === task.employee.id){
          //   this.done.push(task)
          //  }
        });

        //assign all task with pending status to #todo
        //assign users task to done/doing
        //when task is tragged to users doing/done it changes the pending to assigned 
        // console.log(t)  
      }
    )
    }
}
