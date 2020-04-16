import { User } from './user';
import { Task } from '../../projects/tasks/Beans/task';

export class Employee extends User {
    first: string;
    last: string;
    title: string;
    tasks: Task[];
    supervisor: Employee;
    selected: boolean;
}