import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock_exchange } from 'src/app/models/Stock_exchange';
import { StockExchangeService } from 'src/app/services/stock-exchange.service';

@Component({
  selector: 'app-stock-exchanges',
  templateUrl: './stock-exchanges.component.html',
  styleUrls: ['./stock-exchanges.component.css']
})
export class StockExchangesComponent implements OnInit {

  isAdmin = false;
  stockExchanges!: Stock_exchange[];


  constructor(private stockExchangeService: StockExchangeService) {

    

   }
 
  
  ngOnInit(): void {
    if (history.state.type=="admin")
    this.isAdmin = true;
    this.stockExchangeService.getStockExchanges()
    .subscribe(response => {
      this.stockExchanges = response;
    });

    
    
   
  }
  
  onDeleteClick(id: string) {
    this.stockExchangeService.deleteStockExchange(id);
  }

}

