import { User } from './user';
import { Task } from '../../projects/tasks/Beans/task';

export class Employee extends User {
    [x: string]: any;
    first: string;
    last: string;
    title: string;
    tasks: Task[];
    supervisor: Employee;
}