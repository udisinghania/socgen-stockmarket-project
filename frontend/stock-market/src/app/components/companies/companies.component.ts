import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  constructor() { }

  isAdmin = false;

  ngOnInit(): void {
    console.log(history.state);
    if (history.state.type=="admin")
    this.isAdmin = true;

  }

}
