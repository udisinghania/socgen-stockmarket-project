import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { Sector } from 'src/app/models/Sector';
import { CompanyService } from 'src/app/services/company.service';
import { SectorService } from 'src/app/services/sector.service';

@Component({
  selector: 'app-edit-company',
  templateUrl: './edit-company.component.html',
  styleUrls: ['./edit-company.component.css']
})
export class EditCompanyComponent implements OnInit {

  company: Company = 
  { id : '' ,
    code : '',
   name : '',
   turnover : 0,
   ceo : '',
   description : '',
   boardOfDirectors : '',
   sector_id : '',
   stockExchangeNames:''
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
