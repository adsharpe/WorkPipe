import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import { LoginComponent } from './shared/login/login.component';
import { ServicesComponent } from './shared/services/services.component';
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { ProjectsComponent } from './projects/projects.component';
import { TasksComponent } from './projects/tasks/tasks.component';
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


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ServicesComponent,
    NavBarComponent,
    ProjectsComponent,
    TasksComponent,
    NotificationsComponent,
    MainToolBarComponent,
    DragDropTasksComponent,
    SubNavComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

    MatToolbarModule, 
    MatCardModule, 
    MatMenuModule,
    MatGridListModule,
    MatIconModule,
    DragDropModule,
    MatNativeDateModule,
    RouterModule.forRoot([
      {
        path: "login",
        component: LoginComponent
      },
      {
        path: "projects",
        component: ProjectsComponent
      },
      {
        path: "tasks",
        component: TasksComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent,MainToolBarComponent,DragDropTasksComponent,]
})

export class AppModule { }
