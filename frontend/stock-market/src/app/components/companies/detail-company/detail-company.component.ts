import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { Ipo } from 'src/app/models/Ipo';
import { Sector } from 'src/app/models/Sector';
import { CompanyService } from 'src/app/services/company.service';
import { SectorService } from 'src/app/services/sector.service';

@Component({
  selector: 'app-detail-company',
  templateUrl: './detail-company.component.html',
  styleUrls: ['./detail-company.component.css']
})
export class DetailCompanyComponent implements OnInit {

  sector: Sector={
    id:'',
    name:'',
    brief:'',
  };
  ipo: Ipo={
    id:'',
    companyId:'',
    stockExchangeId:'',
    dateTime:0,
    price:0,
    shares:0,
    remarks:''
  };
  company!: Company;
  
  constructor(private sectorService:SectorService, private companyService : CompanyService) { }

  ngOnInit(): void {
    console.log(history.state);
    this.company=history.state;

    this.sectorService.getSector(history.state.sectorId)
    .subscribe(response => {
      this.sector = response;
    });

    this.companyService.getCompanyIpoDetails(history.state.id)
    .subscribe(response => {
      this.ipo = response;
    });

  }

}
