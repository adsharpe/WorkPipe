import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from 'src/app/shared/classes/employee';
import { ProjectFormService } from '../services/project-form.service';
import { Project } from '../beans/project';
import { UserService } from 'src/app/shared/services/user.service';

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
  employee: Employee;
  //constructor needs ALL services that are connected to the component
  //in this case, it needs the employee service and the projectForm service
  constructor(private employeeService: EmployeeService, private projectFormService: ProjectFormService, private userService: UserService) { }

  ngOnInit(): void {
    //get the data from that call into the employee obejct
   this.employeeService.getEmployeeList().subscribe( val => {
     //this.employees;
     this.employees = val;
     console.log(this.employees);
     this.employee=this.userService.getEmployee();
    });
  }
  updateTeamLead(id: string) {
    console.log(id);
    this.teamLead = this.employees.find((emp) => emp.id == id);
    console.log(this.project.lead);
  }
  submitForm(): void {
    //this.project.lead is a number
    //this.lead.id is a string
    console.log(this.employee);
    console.log(this.teamLead);
    this.project.lead=this.teamLead;

    console.log(this.project.lead);

    this.project.projectName=this.projectName;
    console.log(this.project.projectName); // this is working fine

    // //this.project.startdate is a date
    // //this.startdate is a string
    this.project.startdate=new Date(this.startdate);
    console.log(this.project.startdate);

    this.project.enddate=new Date(this.enddate);
    console.log(this.project.enddate);
    console.log("this.project 1 is " +JSON.stringify(this.project));
    this.projectFormService.createProject(this.project).subscribe( resp => {
      //this.project = new Project();
      resp=this.project;
      console.log("this.project 2 is " +this.project);
      console.log("this is resp "+resp);
    })
  }
}
