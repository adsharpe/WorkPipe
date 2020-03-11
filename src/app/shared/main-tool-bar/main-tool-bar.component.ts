import { Component, OnInit } from '@angular/core';
import {MatMenuModule} from '@angular/material/menu';

@Component({
  selector: 'app-main-tool-bar',
  templateUrl: './main-tool-bar.component.html',
  styleUrls: ['./main-tool-bar.component.css']
})
export class MainToolBarComponent implements OnInit, MatMenuModule {

  constructor() { }

  ngOnInit(): void {
  }

}
