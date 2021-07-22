import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stock-exchanges',
  templateUrl: './stock-exchanges.component.html',
  styleUrls: ['./stock-exchanges.component.css']
})
export class StockExchangesComponent implements OnInit {

  constructor() { }

  isAdmin = false;

  ngOnInit(): void {
    if (history.state.type=="admin")
    this.isAdmin = true;
  }

}
