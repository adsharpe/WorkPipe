import { Project } from './project';
import { Employee } from 'src/app/shared/classes/employee';
import { Text } from 'src/app/shared/classes/text';
export class ProjectComment {
    id: number;
    projects: Project;
    empId: Employee;
    textId: Text;
}
