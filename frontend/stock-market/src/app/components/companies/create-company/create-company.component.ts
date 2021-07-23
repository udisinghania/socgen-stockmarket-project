import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { Sector } from 'src/app/models/Sector';
import { CompanyService } from 'src/app/services/company.service';
import { SectorService } from 'src/app/services/sector.service';

@Component({
  selector: 'app-create-company',
  templateUrl: './create-company.component.html',
  styleUrls: ['./create-company.component.css']
})
export class CreateCompanyComponent implements OnInit {

  company: Company = 
 { id : 0 ,
  name : '',
  turnover : 0,
  ceo : '',
  description : '',
  boardOfDirectors : '',
  sector_id : ''
}
sectors : Sector[] | undefined;
  constructor(private sectorService: SectorService, private companyService: CompanyService) { }

  ngOnInit(): void {
    this.sectorService.getSectors()
      .subscribe(response => {
        this.sectors = response;
      });
  }

  onSubmit({value}: {value: Company}) {
    console.log(value);
  }

}
