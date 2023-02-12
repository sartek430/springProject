import { Component, OnInit } from '@angular/core';
import { UnicornService } from '../services/unicorn.service';
import { Unicorn } from '../model/unicorn.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

public unicornList :Unicorn[];

  constructor(
    private unicorn: UnicornService
  ) { }

  ngOnInit(): void {
    this.unicorn.getAll().subscribe((data =>this.unicornList = data))
    console.log(this.unicornList);
  }

}
