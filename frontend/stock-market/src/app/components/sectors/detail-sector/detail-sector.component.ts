import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { SectorService } from 'src/app/services/sector.service';

@Component({
  selector: 'app-detail-sector',
  templateUrl: './detail-sector.component.html',
  styleUrls: ['./detail-sector.component.css']
})
export class DetailSectorComponent implements OnInit {

  companies:Company[]| undefined;

  constructor(private sectorService: SectorService) { }

  ngOnInit(): void {
    console.log(history.state);

    this.sectorService.getSectorCompanies(history.state.name)
    .subscribe(response => {
      this.companies = response;
    });
  }

}
