import { Employee } from '../../shared/classes/employee';

export class Project {
  //user bean has id as a string
    id: number;
    projectname: string;
    //changing lead from a string into an Employee
    lead: Employee; /*teamlead_ID*/
    startdate: Date;
    enddate: Date;
}
