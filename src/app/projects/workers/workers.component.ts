import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { ProjectsService } from '../services/projects.service';
import { Employee } from 'src/app/shared/classes/employee';
import { Project } from '../beans/project';

@Component({
  selector: 'app-workers',
  templateUrl: './workers.component.html',
  styleUrls: ['./workers.component.css']
})
export class WorkersComponent implements OnInit {
  public projectName: string;
  public leadName: string;
  public project: Project;
  public employee: Employee;

  employees = new Array<Employee>();
  projects = new Array<Project>();

  constructor(private employeeService: EmployeeService, private projectsService: ProjectsService) { }

  ngOnInit(): void {
    //get the data from that call into the employee obejct
   this.employeeService.getEmployeeList().subscribe( val => { this.employees = val; });

    //get the data from that call into the project obejct
   this.projectsService.getProjects().subscribe( val => { this.projects = val; console.log("Projects: " + val[0].lead.first); });
  }

  submitForm(): void {
    //this.project.lead is a number
    //this.lead.id is a string
    //this.project.lead=Number(this.teamLead.id);
    //this.project.projectName=this.projectName;
    //this.project.startdate is a date
    //this.startdate is a string
    //this.project.startdate=new Date(this.startdate);
    //this.project.enddate=new Date(this.enddate);
    //this.projectFormService.createProject(this.project).subscribe( val => {

    //})
  }
}
