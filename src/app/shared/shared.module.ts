import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UrlService } from './url.service';
import { UserService } from './services/user.service';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { LayoutModule } from '@angular/cdk/layout';
import { MainToolBarComponent } from './main-tool-bar/main-tool-bar.component';
import { SubNavComponent } from './sub-nav/sub-nav.component';
@NgModule({
  declarations: [
    NavBarComponent,
    LoginComponent,
    MainToolBarComponent,
    SubNavComponent,
    MainToolBarComponent,
    SubNavComponent
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