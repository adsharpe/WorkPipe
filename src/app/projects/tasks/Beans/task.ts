import { Employee } from 'src/app/shared/classes/employee';
import { Text } from '../../../shared/classes/text'
import { Project } from '../../beans/project';

export class Task {
    id: number;
    status: Status;
    employee: Employee;
    description: Text;
    project: Project;
}
export class Status {
    id: number;
    statLevel: string;
}
