import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Company } from "../models/Company";
import { Stock_exchange } from "../models/Stock_exchange";

@Injectable({providedIn: 'root'})
export class StockExchangeService {

  url: string;
  url2: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = 'http://localhost:9191/stockexchange/stockexchanges';
    this.url2 = 'http://localhost:9191/company/stockExchange/';
  }

  getStockExchanges(): Observable<Stock_exchange[]> {
    return this.http.get<Stock_exchange[]>(this.url);
  }

  getStockExchange(id: string): Observable<Stock_exchange> {
    return this.http.get<Stock_exchange>(this.url + id);
  }

  getStockExchangeCompanies(id: string): Observable<Company[]> {
    return this.http.get<Company[]>(this.url2 +id);
  }

  addStockExchange(stockExchange: Stock_exchange) {
    this.http.post<Stock_exchange>(this.url, stockExchange)
      .subscribe((responseData) => {
        this.router.navigate(['/stock-exchanges']);
      });
  }

  updateStockExchange(stockExchange: Stock_exchange) {
    this.http.put(this.url, stockExchange)
      .subscribe(response => {
        this.router.navigate(['/stock-exchanges']);
      });
  }

  deleteStockExchange(id: string) {
    this.http.delete(this.url +"/" +id)
      .subscribe(response => {
        this.router.navigate(['/stock-exchanges']);
      });
  }
}