import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  constructor(private companyService:CompanyService) { }

  isAdmin = false;
  companies !: Company[] ;
  allCompaneies !: Company[];
  page = 1;
  pageSize = 1;
  searchTerm!: string;
  collectionSize!: number;

  ngOnInit(): void {
    console.log(history.state);
    if (history.state.type=="admin")
    this.isAdmin = true;

    this.companyService.getCompanies()
    .subscribe(response => {
      this.companies = response;
      this.collectionSize = this.companies.length;
      this.allCompaneies = this.companies;
    });

  }
  search(value: string): void {
    
    this.collectionSize = this.companies.length;
  }

  onDeleteClick(id:string){
    this.companyService.deleteCompany(id);
  }

}
