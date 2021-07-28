import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/Address';
import { Stock_exchange } from 'src/app/models/Stock_exchange';
import { StockExchangeService } from 'src/app/services/stock-exchange.service';

@Component({
  selector: 'app-edit-stock-exchange',
  templateUrl: './edit-stock-exchange.component.html',
  styleUrls: ['./edit-stock-exchange.component.css']
})
export class EditStockExchangeComponent implements OnInit {

  address : Address = {
    id:'',
    houseNo:'',
    city:'',
    state:'',
    country:'',
    pin:''
  }
  stockExchange: Stock_exchange = 
  { id: '',
    name: '',
    brief: '',
    remarks:'',
    address: this.address
  }


  constructor(private stockExchangeService: StockExchangeService) { }

  ngOnInit(): void {
    console.log(history.state);
    this.stockExchange.id = history.state.id;
    this.stockExchange.name = history.state.name;
  }

  onSubmit({value}: {value: Stock_exchange}) {
    console.log(value);
    this.stockExchange = value;
    console.log(this.stockExchange);
    this.stockExchangeService.updateStockExchange(value);
  }

}
