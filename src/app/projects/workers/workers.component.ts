import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { ProjectsService } from '../services/projects.service';
import { StaffingService } from '../services/staffing.service';
import { Employee } from '../../shared/classes/employee';
import { Project } from '../beans/project';
import { ButtonsModule } from '@progress/kendo-angular-buttons';

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
  availableWorkers = new Array<Employee>();
  allocatedWorkers = new Array<Employee>();
  projects = new Array<Project>();

  constructor(private employeeService: EmployeeService, private projectsService: ProjectsService, private staffingService: StaffingService) { }

  ngOnInit(): void {
    //get the data from that call into the employee obejct
   this.employeeService.getEmployeeList().subscribe( val => {
              this.employees = val;
              this.availableWorkers = val;
    });

    //get the data from that call into the project obejct
   this.projectsService.getProjects().subscribe( val => {
              this.projects = val;
              console.log("Projects[0].id: " + val[0].id);
              console.log("Projects[0].projectName: " + val[0].projectname);
              console.log("Projects[0].lead.first: " + val[0].lead.first);
              console.log("Projects[0].lead.last: " + val[0].lead.last);
              console.log("Projects[0].lead.title: " + val[0].lead.title);
              console.log("Projects[0].startdate: " + val[0].startdate);
              console.log("Projects[0].enddate: " + val[0].enddate);
    });
  }

  toggleSelection(item) {
    item.selected = !item.selected;
  }

  unselect(item) {
    if(item.selected)
      item.selected = !item.selected;
  }

  moveSelected(direction) {
    if (direction === 'left') {
      this.allocatedWorkers.forEach(item => {
        // if (item.selected) {
        //   this.availableWorkers.push(item);
        // }
      });
      // this.allocatedWorkers = this.allocatedWorkers.filter(i => !i.selected);
      this.availableWorkers.forEach(i => this.unselect(i));
    } else {
      this.availableWorkers.forEach(item => {
        // if (item.selected) {
        //   this.allocatedWorkers.push(item);
        // }
      });
      // this.availableWorkers = this.availableWorkers.filter(i => !i.selected);
      this.allocatedWorkers.forEach(i => this.unselect(i));
    }
  }

  moveAll(direction) {
    if (direction === 'left') {
      this.availableWorkers = [...this.availableWorkers, ...this.allocatedWorkers];
      this.allocatedWorkers = [];
    } else {
      this.allocatedWorkers = [...this.allocatedWorkers, ...this.availableWorkers];
      this.availableWorkers = [];
    }
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
