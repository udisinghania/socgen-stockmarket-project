import { Component, OnInit } from '@angular/core';
import { Sector } from 'src/app/models/Sector';
import { SectorService } from 'src/app/services/sector.service';

@Component({
  selector: 'app-edit-sector',
  templateUrl: './edit-sector.component.html',
  styleUrls: ['./edit-sector.component.css']
})
export class EditSectorComponent implements OnInit {

  sector: Sector = 
  { id: '',
    name: '',
    brief: ''
  }
  
  constructor(private sectorService: SectorService) { }

  ngOnInit(): void {
    console.log(history.state);
    this.sector.id = history.state.id;
    this.sector.name = history.state.name;
  }

  onSubmit({value}: {value: Sector}) {
    console.log(value);
    this.sectorService.updateSector(value);
  }

}
