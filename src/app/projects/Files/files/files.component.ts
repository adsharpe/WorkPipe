import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/shared/services/user.service';
import { TaskService } from '../../services/task.service';
import { ProjectsService } from '../../services/projects.service';
import { Project } from '../../beans/project';

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html',
  styleUrls: ['./files.component.css']
})
export class FilesComponent implements OnInit {
  project: Project;
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private taskService: TaskService,
    private projectsService: ProjectsService
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.projectsService.getProject(id).subscribe(
      (p) => {
        this.project = p;
        console.log(p);
      }
    )
  }

}
