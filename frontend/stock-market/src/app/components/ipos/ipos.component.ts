import { Component, OnInit } from '@angular/core';
import { Ipo } from 'src/app/models/Ipo';
import { IpoService } from 'src/app/services/ipo.services';

@Component({
  selector: 'app-ipos',
  templateUrl: './ipos.component.html',
  styleUrls: ['./ipos.component.css']
})
export class IposComponent implements OnInit {

  ipos : Ipo[]|undefined;
  constructor(private ipoService: IpoService) { }
  isAdmin = false;
  ngOnInit(): void {
    if (history.state.type=="admin")
    this.isAdmin = true;

    this.ipoService.getIpos()
      .subscribe(response => {
        this.ipos = response;
      });
    
  }

}
