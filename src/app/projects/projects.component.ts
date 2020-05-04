import { Component, OnInit, AfterViewInit,ViewEncapsulation, ElementRef, Renderer2 } from '@angular/core';
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
  employee: Employee;
  projects: Project[];
  empProjects: Project[];
  project: Project;

  constructor(
    private projectsService: ProjectsService,
    private userService: UserService,
    private el: ElementRef,
    private renderer:Renderer2,
  ) { }
  ngAfterViewInit(){
    //find steps to add imgages to file/folder
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'backgroundImage', "url(' http://www.astmedicalbilling.org/wp-content/uploads/2019/07/undraw_group_chat_trans-1024x700-1.png')");
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'background-repeat', 'no-repeat');
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'background-attachmen', 'fixed');
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'background-position', 'center');
  }
  ngOnInit(): void {
    this.employee = this.userService.getEmployee();
    console.log(this.employee.title)
    this.project = new Project();
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
