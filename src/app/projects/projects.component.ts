import { Component, OnInit, Input } from '@angular/core';
import { Project } from './beans/project';
import { UserService } from '../shared/services/user.service';
import { ProjectsService } from './services/projects.service';
import { Employee } from '../shared/classes/employee';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  public loggedUser: Employee;
  projects: Project[];
  project: Project;

  constructor(
    private projectsService: ProjectsService,
    private userService: UserService
  ) { }

  ngOnInit(): void {
    // this.project = new Project();
    this.projectsService.getProjects().subscribe(
      (p) =>{

        this.projects = p;
        this.projects.sort( (p1, p2) => p1.id - p2.id);
        console.log(p);
      }
    )
  }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }
}
