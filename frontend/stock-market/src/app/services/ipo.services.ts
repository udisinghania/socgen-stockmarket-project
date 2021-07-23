import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Ipo } from "../models/Ipo";

@Injectable({providedIn: 'root'})
export class IpoService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = 'http://localhost:9191/company/ipo/';
  }

  public getIpos(): Observable<Ipo[]> {
    return this.http.get<Ipo[]>(this.url);
  }

  getIpo(id: string): Observable<Ipo> {
    return this.http.get<Ipo>(this.url + id);
  }

  addIpo(ipo: Ipo) {
    this.http.post<Ipo>(this.url, ipo)
      .subscribe((responseData) => {
        this.router.navigate(['/ipos']);
      });
  }

  updateIpo(ipo: Ipo) {
    this.http.put(this.url, ipo)
      .subscribe(response => {
        this.router.navigate(['/ipos']);
      });
  }

  deleteIpo(id: string) {
    this.http.delete(this.url + id)
      .subscribe(response => {
        this.router.navigate(['/ipos']);
      });
  }
}