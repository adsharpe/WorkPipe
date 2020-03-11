import { User } from './user';

export class Employee extends User {
    first: string;
    last: string;
    title: string;
    supervisor: Employee;

}