import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UrlService } from './url.service';
import { UserService } from './services/user.service';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
<<<<<<< HEAD
import { ToolbarComponent } from './toolbar/toolbar/toolbar.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { LayoutModule } from '@angular/cdk/layout';
import { MainToolBarComponent } from './main-tool-bar/main-tool-bar.component';
=======
import { SubNavComponent } from './sub-nav/sub-nav.component';
>>>>>>> 8cec10283083539fa43ec3f0ddb94320ecba64ae



@NgModule({
  declarations: [
    NavBarComponent,
    LoginComponent,
<<<<<<< HEAD
    ToolbarComponent,
    MainToolBarComponent
=======
    SubNavComponent
>>>>>>> 8cec10283083539fa43ec3f0ddb94320ecba64ae
  ],
  imports: [
    CommonModule,
    FormsModule,
    AppRoutingModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    LayoutModule
  ],
  providers: [
    UrlService,
    UserService
  ],
  exports: [
    NavBarComponent
  ]
})
export class SharedModule { }