import { Employee } from 'src/app/shared/classes/employee';
import { Text } from '../../../shared/classes/text'

export class Task {
    id: number;
    status: Status;
    employee: Employee;
    description: Text;
    projId: number;
}
export class Status {
    id: number;
    statLevel: string;
}