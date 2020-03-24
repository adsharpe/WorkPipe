import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';
import { TaskService } from 'src/app/projects/services/task.service';
import { ProjectsService } from 'src/app/projects/services/projects.service';
import { Project } from 'src/app/projects/beans/project';

@Component({
  selector: 'app-sub-nav',
  templateUrl: './sub-nav.component.html',
  styleUrls: ['./sub-nav.component.css']
})
export class SubNavComponent implements OnInit {
  project: Project;
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private taskService: TaskService,
    private projectsService: ProjectsService
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.projectsService.getProject(id).subscribe(
      (p) => {
        this.project = p;
        console.log("this is current project id: "+p.id);
      }
    )
  }

}
