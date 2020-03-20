import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from 'src/app/shared/classes/employee';

@Component({
  selector: 'app-project-form',
  templateUrl: './project-form.component.html',
  styleUrls: ['./project-form.component.css']
})
export class ProjectFormComponent implements OnInit {

  employees = new Array<Employee>()

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    //get the data from that call into the employee obejct
   this.employeeService.getEmployeeList().subscribe( val => {
     this.employees;
    });
  }

}
