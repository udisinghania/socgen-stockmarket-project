import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { StockExchangeService } from 'src/app/services/stock-exchange.service';

@Component({
  selector: 'app-detail-stock-exchange',
  templateUrl: './detail-stock-exchange.component.html',
  styleUrls: ['./detail-stock-exchange.component.css']
})
export class DetailStockExchangeComponent implements OnInit {

  companies:Company[]| undefined;

  constructor(private stockExchangeService : StockExchangeService) { }

  ngOnInit(): void {
    console.log(history.state);

    this.stockExchangeService.getStockExchangeCompanies(history.state.name)
    .subscribe(response => {
      this.companies = response;
    });
  }

}
