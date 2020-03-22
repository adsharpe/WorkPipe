import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from 'src/app/shared/classes/employee';
import { ProjectFormService } from '../services/project-form.service';
import { Project } from '../beans/project';

@Component({
  selector: 'app-project-form',
  templateUrl: './project-form.component.html',
  styleUrls: ['./project-form.component.css']
})
export class ProjectFormComponent implements OnInit {
  public projectName: string;
  public teamLead: Employee;
  public startdate: string;
  public enddate: string;

  project = new Project();

  employees = new Array<Employee>()

  //constructor needs ALL services that are connected to the component
  //in this case, it needs the employee service and the projectForm service
  constructor(private employeeService: EmployeeService, private projectFormService: ProjectFormService) { }

  ngOnInit(): void {
    //get the data from that call into the employee obejct
   this.employeeService.getEmployeeList().subscribe( val => {
     //this.employees;
     this.employees = val;
    });
  }
  submitForm(): void {
    //this.project.lead is a number
    //this.lead.id is a string
    this.project.lead=Number(this.teamLead.id);
    this.project.projectName=this.projectName;
    //this.project.startdate is a date
    //this.startdate is a string
    this.project.startdate=new Date(this.startdate);
    this.project.enddate=new Date(this.enddate);
    this.projectFormService.createProject(this.project).subscribe( val => {

    })
  }
}
