import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLoading = false;
  username!: string;
  password!: string;
  public state: string;


  constructor(private authService: AuthService, private router: Router) {
    this.state = authService.getState();
    console.log(this.state);
    this.username = "";
    this.password = "";
  }


  ngOnInit(): void {
  }

  
  onSubmit() {
    this.isLoading = true;
    this.authService.authenticate(this.username, this.password);
    this.state = this.authService.getState();
    console.log(this.state);
    if (this.state=="admin")
    {
      this.router.navigate(['/admin-navbar']);
    }
    else if(this.state=="user")
    {
      this.router.navigate(['/user-navbar']);
    }
    else{
      this.router.navigate(['/']);
    }
    
  }

}
