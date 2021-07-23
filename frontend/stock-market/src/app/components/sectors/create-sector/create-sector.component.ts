import { Component, OnInit } from '@angular/core';
import { Sector } from 'src/app/models/Sector';
import { SectorService } from 'src/app/services/sector.service';

@Component({
  selector: 'app-create-sector',
  templateUrl: './create-sector.component.html',
  styleUrls: ['./create-sector.component.css']
})
export class CreateSectorComponent implements OnInit {

  sector: Sector = 
  { id: '',
    name: '',
    brief: ''
  }

  constructor(private sectorService: SectorService) { }

  ngOnInit(): void {
  }

  onSubmit({value, valid}: {value: Sector, valid: boolean}) {
    if(valid) {
      console.log(value);
      this.sectorService.addSector(value);
    }
    
  }
}
