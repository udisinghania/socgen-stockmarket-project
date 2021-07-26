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
  companies : Company[] | undefined;

  ngOnInit(): void {
    console.log(history.state);
    if (history.state.type=="admin")
    this.isAdmin = true;

    this.companyService.getCompanies()
    .subscribe(response => {
      this.companies = response;
    });

  }

  onDeleteClick(id:string){
    this.companyService.deleteCompany(id);
  }

}
