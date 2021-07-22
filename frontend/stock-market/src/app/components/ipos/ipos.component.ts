import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ipos',
  templateUrl: './ipos.component.html',
  styleUrls: ['./ipos.component.css']
})
export class IposComponent implements OnInit {

  constructor() { }
  isAdmin = false;
  ngOnInit(): void {
    if (history.state.type=="admin")
    this.isAdmin = true;
  }

}
