import { Project } from './project';
import { Employee } from 'src/app/shared/classes/employee';
import { Text } from 'src/app/shared/classes/text';
export class ProjectComment {
    id: number;
    projId: Project;
    empId: Employee;
    text: Text;
}
