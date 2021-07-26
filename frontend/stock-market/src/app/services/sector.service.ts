import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Company } from "../models/Company";
import { Sector } from "../models/Sector";

@Injectable({providedIn: 'root'})
export class SectorService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = 'http://localhost:9191/sector/sectors/';
  }

  getSectors(): Observable<Sector[]> {
    return this.http.get<Sector[]>(this.url);
  }

  getSector(id: string): Observable<Sector> {
    return this.http.get<Sector>(this.url + id);
  }

  getSectorCompanies(name: string): Observable<Company[]> {
    return this.http.get<Company[]>(this.url + "/companies/"+name);
  }

  addSector(sector: Sector) {
    this.http.post<Sector>(this.url, sector)
      .subscribe((responseData) => {
        this.router.navigate(['/sectors']);
      });
  }

  updateSector(sector: Sector) {
    this.http.put(this.url, sector)
      .subscribe(response => {
        this.router.navigate(['/sectors']);
      });
  }

  deleteSector(id: string) {
    this.http.delete(this.url + id)
      .subscribe(response => {
        this.router.navigate(['/sectors']);
      });
  }
}