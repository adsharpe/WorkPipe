import { Employee } from 'src/app/shared/classes/employee'
import { Project } from './project'

export class ProjectEmployee {
    id: number
    employees: Employee[] 
    projects: Project[]
}
