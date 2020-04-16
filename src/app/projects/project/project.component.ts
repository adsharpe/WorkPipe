import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/services/user.service';
import { TaskService } from '../services/task.service';
import { ProjectsService } from '../services/projects.service';
import { Project } from '../beans/project';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/shared/classes/employee';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  
  project: Project;
  employee: Employee;
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private taskService: TaskService,
    private projectsService: ProjectsService
  ) { }

  ngOnInit(): void {
    this.employee = this.userService.getEmployee();
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.projectsService.getProject(id).subscribe(
      (p) => {
        this.project = p;
        console.log("this is current project id: "+p);
      }
    )
  }
}
