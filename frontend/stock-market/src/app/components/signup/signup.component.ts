import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public state: string;
  user = {
    username: '',
    password: '',
    email: '',
    mobile: ''
  };
  constructor(private authService: AuthService) {
    this.state = authService.getState();
  }

  ngOnInit(): void {
  }
  onSubmit({value}: {value: any}) {
    
    console.log(value);
  }

}
