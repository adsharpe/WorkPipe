import { Employee } from 'src/app/shared/classes/employee';

export class Project {
  //user bean has id as a string
    id: number;
    projectName: string;
    //changing lead from a string into an Employee
    lead: Employee; /*teamlead_ID*/
    startdate: Date;
    enddate: Date;
}
