import { Employee } from 'src/app/shared/classes/employee';

export class Task {
    id: number;
    status: Status;
    employee: Employee;
    descriptionId: number;
    projId: number;
}
export class Status {
    id: number
    statLevel: string
}