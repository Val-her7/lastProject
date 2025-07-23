import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';

@Component({
  selector: 'ecom-footer',
  imports: [CommonModule, FaIconComponent],
  templateUrl: './footer.html',
  styleUrl: './footer.scss',
})
export class Footer {}
