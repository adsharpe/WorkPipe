import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { ProjectsService } from '../services/projects.service';
import { StaffingService } from '../services/staffing.service';
import { Employee } from '../../shared/classes/employee';
import { Project } from '../beans/project';
import { ProjectEmployee } from '../beans/project-employee';

@Component({
  selector: 'app-workers',
  templateUrl: './workers.component.html',
  styleUrls: ['./workers.component.css']
})
export class WorkersComponent implements OnInit {
  public projectName: string;
  public leadName: string;
  public currentProject: Project;
  public currentEmployee: Employee;

  employees = new Array<Employee>();
  availableWorkers = new Array<Employee>();
  allocatedWorkers = new Array<Employee>();
  projects = new Array<Project>();

  constructor(private employeeService: EmployeeService, private projectsService: ProjectsService, private staffingService: StaffingService) { }

  ngOnInit(): void {
    //get the data from that call into the employee obejct
   this.employeeService.getEmployeeList().subscribe( val => {
              val.forEach(emp => {
                this.employees.push(emp);
                this.availableWorkers.push(emp);
              })
    });

    //get the data from that call into the project obejct
   this.projectsService.getProjects().subscribe( val => {
              val.forEach(proj => {
                this.projects.push(proj);
              })
    });
  }

  projectChange(event): void {
    const value = event.target.value;
    console.log("project=" + value);

    this.projects.forEach(proj => {
      if(value == proj.id) {
        this.currentProject = proj;
      }
    });

    this.staffingService.getProjectEmployees().subscribe( val => {
      this.allocatedWorkers = [];
      console.log('val.length=' + val.length)
      console.log('val[0].id=' + val[0].id)
      console.log('val[0].project.id=' + val[0].project.id)
      console.log('val[0].employee.id=' + val[0].employee.id)
      console.log('val[1].id=' + val[1].id)
      console.log('val[0].project.id=' + val[1].project.id)
      console.log('val[0].employee.id=' + val[1].employee.id)
      console.log('val[2].id=' + val[2].id)
      console.log('val[0].project.id=' + val[2].project.id)
      console.log('val[0].employee.id=' + val[2].employee.id)
      console.log('val[3].id=' + val[3].id)
      console.log('val[0].project.id=' + val[3].project.id)
      console.log('val[0].employee.id=' + val[3].employee.id)
      val.forEach(projEmp => {
        console.log('projEmp.id=' + projEmp.id);


        /*if(this.currentProject.id == projEmp.project.id) {
          this.projects.push(projEmp.project);
          this.allocatedWorkers.push(projEmp.employee);
        }*/
      });
    });
  }

  employeeChange(event): void {
    const value = event.target.value;
    let employee: Employee;
    console.log("employee=" + value);

    this.employees.forEach( emp => {
      if(value == emp.id) {
        employee = emp;
        return;
      }
    });

    if(!this.allocatedWorkers.includes(employee)) {
      this.allocatedWorkers.push(employee);
      this.allocatedWorkers.forEach(i => this.unselect(i));
    }

    if(this.availableWorkers.includes(employee)) {
      let index: number = this.availableWorkers.indexOf(employee);
      if(index !== -1) {
        this.availableWorkers.splice(index, 1);
      }
    }

    this.currentProject.lead = employee;

    this.currentEmployee = employee;
  }

  toggleSelection(item, list) {
    item.selected = !item.selected;
  }

  unselect(item) {
    if(item.selected)
      item.selected = !item.selected;
  }

  moveSelected(direction) {
    if (direction === 'left') {
      this.allocatedWorkers.forEach(item => {
        if (item.selected) {
          this.availableWorkers.push(item);
        }
      });
      this.allocatedWorkers = this.allocatedWorkers.filter(i => !i.selected);
      this.availableWorkers.forEach(i => this.unselect(i));
    } else {
      this.availableWorkers.forEach(item => {
        if (item.selected) {
          this.allocatedWorkers.push(item);
        }
      });
      this.availableWorkers = this.availableWorkers.filter(i => !i.selected);
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
    this.allocatedWorkers.forEach(emp => {
            let projEmp = new ProjectEmployee();
            projEmp.employee = emp;
            projEmp.project = this.currentProject;

            this.staffingService.createProjectEmployee(projEmp);
    });

    this.availableWorkers.forEach(emp => {
            let projEmp = new ProjectEmployee();
            projEmp.employee = emp;
            projEmp.project = this.currentProject;

            this.staffingService.deleteProjectEmployee(projEmp);
    });

    this.projectsService.updateProject(this.currentProject);
  }
}
