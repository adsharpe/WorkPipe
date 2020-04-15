import { Component, OnInit, AfterViewInit,ViewEncapsulation, ElementRef, Renderer2 } from '@angular/core';
import { UserService } from 'src/app/shared/services/user.service';
import { TaskService } from '../../services/task.service';
import { ProjectsService } from '../../services/projects.service';
import { Employee } from 'src/app/shared/classes/employee';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit, AfterViewInit {
  allTasks = [];
  notAssigned = [];
  waitingApproval = [];
  employeeTasks =[];
  employee: Employee;
  constructor(
    private userService: UserService,
    private taskService: TaskService,
    private projectsService: ProjectsService,
    private el: ElementRef,
    private renderer:Renderer2
  ) { }
  ngAfterViewInit(){
    //find steps to add imgages to file/folder
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'backgroundImage', "url(' https://static.wixstatic.com/media/61973f_1fd8d9f3026d4ae6bb7552f17f87dd71~mv2.png/v1/fill/w_660,h_497,al_c,q_95/undraw_data_trends_b0wg.webp')");
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'background-repeat', 'no-repeat');
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'background-attachmen', 'fixed');
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'background-position', 'center');
  }
  ngOnInit(): void {
    //add service for task, project, emplyees
    //all tasks
    this.employee = this.userService.getEmployee();
    console.log(this.employee)
    this.taskService.getTasks().subscribe(
      (t) => {
        // console.log(t)
        t.forEach( (task) => {
          if(task.status.statLevel === "Waiting Approval"){
            this.waitingApproval.push(task)
            console.log("waiting approval"+task)
            return
           }

           if(task.status.statLevel === "Not Assigned"){
            this.notAssigned.push(task)
            console.log("not assigned"+task)
            return
           }
           if(task.employee.id === this.employee.id){
            this.employeeTasks.push(task)
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
