import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { Ipo } from 'src/app/models/Ipo';
import { Stock_exchange } from 'src/app/models/Stock_exchange';
import { CompanyService } from 'src/app/services/company.service';
import { StockExchangeService } from 'src/app/services/stock-exchange.service';

@Component({
  selector: 'app-create-ipo',
  templateUrl: './create-ipo.component.html',
  styleUrls: ['./create-ipo.component.css']
})
export class CreateIpoComponent implements OnInit {

  companies : Company[] | undefined;
  stockExchanges : Stock_exchange[] | undefined;
  ipo : Ipo =
  {
    id:'',
    dateTime : 0 ,
    price : 0,
    shares : 0,
    remarks : '',
    companyId : '',
    stockExchangeId : ''
  };
 
  constructor(private stockExchangeService: StockExchangeService, private companyService: CompanyService) { }

  ngOnInit(): void {
    
    this.companyService.getCompanies()
      .subscribe(response => {
        this.companies = response;
      });
    
    this.stockExchangeService.getStockExchanges()
      .subscribe(response => {
        this.stockExchanges = response;
      });
  }

  onSubmit({value}: {value: Ipo}) {
    console.log(value);
  }


}
