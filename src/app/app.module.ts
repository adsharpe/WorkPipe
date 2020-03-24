import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import { LoginComponent } from './shared/login/login.component';
import { ServicesComponent } from './shared/services/services.component';
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { ProjectsComponent } from './projects/projects.component';
import { TasksComponent } from './projects/tasks/tasks.component';
import { TaskService } from './projects/services/task.service';
import { NotificationsComponent } from './projects/notifications/notifications.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatGridListModule } from '@angular/material/grid-list';
import {  MatIconModule } from '@angular/material/icon';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { DragDropTasksComponent } from './projects/drag-drop-tasks/drag-drop-tasks.component';
import { MainToolBarComponent } from './shared/main-tool-bar/main-tool-bar.component';
import {MatNativeDateModule} from '@angular/material/core';
import { SubNavComponent } from './shared/sub-nav/sub-nav.component';
import { MainNavComponent } from './shared/main-nav/main-nav.component';
import { UserService } from './shared/services/user.service';
import { UrlService } from './shared/url.service';
import { HomeComponent } from './projects/Home/home/home.component';
import { ActivitiesComponent } from './projects/Activities/activities/activities.component';
import { DiscussionsComponent } from './projects/Discussions/discussions/discussions.component';
import { EventsComponent } from './projects/Events/events/events.component';
import { FilesComponent } from './projects/Files/files/files.component';
import { MessagesComponent } from './projects/messages/messages.component';
import { TeamsComponent } from './projects/Teams/teams/teams.component';
import { fileURLToPath } from 'url';
import { BlankComponent } from './projects/Home/blank/blank.component';
import { ProjectsService } from './projects/services/projects.service';
import { TextService } from './shared/services/text.service';
import { ProjectFormComponent } from './projects/project-form/project-form.component';
import { WorkersComponent } from './projects/workers/workers.component';
import { CommentService } from './projects/services/comment.service';
import { StaffingService } from './projects/services/staffing.service';
import { ButtonsModule } from '@progress/kendo-angular-buttons';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProjectComponent } from './projects/project/project.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ServicesComponent,
    NavBarComponent,
    ProjectsComponent,
    TasksComponent,
    NotificationsComponent,
    SubNavComponent,
    MainNavComponent,
    MainToolBarComponent,
    DragDropTasksComponent,
    SubNavComponent,
    DragDropTasksComponent,
    HomeComponent,
    ActivitiesComponent,
    DiscussionsComponent,
    EventsComponent,
    FilesComponent,
    MessagesComponent,
    TeamsComponent,
    ProjectFormComponent,
    WorkersComponent,
    ProjectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatToolbarModule,
    MatCardModule,
    MatMenuModule,
    MatGridListModule,
    MatIconModule,
    DragDropModule,
    MatNativeDateModule,
    MatNativeDateModule,

    RouterModule.forRoot([
      {
        path: "home",
        component: HomeComponent
      },
      {
        path: "project/:id",
        component: ProjectComponent
      },
      {
        path: "projects",
        component: ProjectsComponent
      },
      {
        path: "tasks/:id",
        component: TasksComponent
      },
      { 
        path: "discussions/:id",
        component: DiscussionsComponent
      },
      {
        path: "teams",
        component: TeamsComponent
      },
      {
        path: "messages/:id",
        component: MessagesComponent
      },
      {
        path: "files/:id",
        component: FilesComponent
      },
      {
        path: "activities/:id",
        component: ActivitiesComponent
      },
      {
        path: "events/:id",
        component: EventsComponent
      },
      {
        path: "logout",
        component: HomeComponent
      },
      //creating the link to the project-form component
      {
        path: "project-form",
        component: ProjectFormComponent
      },
      {
        path: "workers",
        component: WorkersComponent
      }
    ]),

    ButtonsModule,

    BrowserAnimationsModule

  ],
  providers: [UserService, UrlService, ProjectsService, TextService,  TaskService, CommentService, StaffingService],
  bootstrap: [AppComponent]
})

export class AppModule { }
