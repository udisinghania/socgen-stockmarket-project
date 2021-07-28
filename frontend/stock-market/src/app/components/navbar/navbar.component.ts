import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isUnAuth=true;
  state:String='';

  constructor(private authService: AuthService) { 

    this.state = authService.getState();
    console.log(this.state);
     if (this.state=='unauth')
     {
       this.isUnAuth=true;
     }
     else
     {
       this.isUnAuth=false;
     }
    
  }

  ngOnInit(): void {
  }

}
