import { Component, OnInit } from '@angular/core';
import { Project } from '../../beans/project';
import { ActivatedRoute } from '@angular/router';
import { ProjectsService } from '../../services/projects.service';

@Component({
  selector: 'app-discussions',
  templateUrl: './discussions.component.html',
  styleUrls: ['./discussions.component.css']
})
export class DiscussionsComponent implements OnInit {
  project: Project;
  constructor(
    private route: ActivatedRoute,
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
