import { Component, inject, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FaIconLibrary, FaConfig } from '@fortawesome/angular-fontawesome';
import { fontAwesomeIcons } from './shared/font-awesome-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { Navbar } from "./layout/navbar/navbar";
import { Footer } from './layout/footer/footer';

@Component({
  imports: [RouterModule, FontAwesomeModule, Navbar, Footer],
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.scss',
})
export class App implements OnInit {
  
  private faIconLibrary = inject(FaIconLibrary);
  private faConfig = inject(FaConfig);

  ngOnInit(): void {
      this.initFontAwesome();
  }

  private initFontAwesome() {
    this.faConfig.defaultPrefix = 'far';
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }
}
