import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Excel_data } from "../models/Excel_data";

@Injectable({providedIn: 'root'})
export class StockPriceService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = 'http://localhost:9191/company/StockPrice';
  }

  getStockExchanges(): Observable<[]> {
    return this.http.get<[]>(this.url);
  }


  addStockPrice(stockPrices: Excel_data[]) {
    this.http.post<Excel_data[]>(this.url, stockPrices)
      .subscribe((responseData) => {
        this.router.navigate(['/import-data']);
      });
  }

  
}