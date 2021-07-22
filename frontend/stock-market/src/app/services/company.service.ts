import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Company } from "../models/Company";
import { Ipo } from "../models/Ipo";

@Injectable({providedIn: 'root'})
export class CompanyService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = 'http://localhost:9191/company/company/';
  }

  getCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(this.url);
  }

  getCompany(id: string): Observable<Company> {
    return this.http.get<Company>(this.url + id);
  }

  getCompanyIpoDetails(id: string): Observable<Ipo> {
    return this.http.get<Ipo>(this.url + id + "/ipos");
  }

  addCompany(company: Company) {
    this.http.post<Company>(this.url, company)
      .subscribe((responseData) => {
        this.router.navigate(['/companies']);
      });
  }

  updateCompany(company: Company) {
    this.http.put(this.url, company)
      .subscribe(response => {
        this.router.navigate(['/companies']);
      });
  }

  deleteCompany(id: string) {
    this.http.delete(this.url + id)
      .subscribe(response => {
        this.router.navigate(['/companies']);
      });
  }
}