import { Employee } from 'src/app/shared/classes/employee';

export class Project {
  //user bean has id as a string
    id: number;
    projectName: string;
    lead: Employee; /*teamlead_ID*/
    startdate: Date;
    enddate: Date;
}
