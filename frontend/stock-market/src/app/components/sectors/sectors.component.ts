import { Component, OnInit } from '@angular/core';
import { SectorService } from 'src/app/services/sector.service';
import { Sector } from 'src/app/models/Sector';

@Component({
  selector: 'app-sectors',
  templateUrl: './sectors.component.html',
  styleUrls: ['./sectors.component.css']
})
export class SectorsComponent implements OnInit {

  isAdmin = false;
  sectors : Sector[] | undefined;

  constructor(private sectorService: SectorService) { }

  

  ngOnInit(): void {

    if (history.state.type=="admin")
    this.isAdmin = true;

    this.sectorService.getSectors()
      .subscribe(response => {
        this.sectors = response;
      });
  }

  onDeleteClick(id: string) {
    this.sectorService.deleteSector(id);
  }

}
