import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {
    userId: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
 

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService , private router :Router) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  onSubmit(): void {
    const { userId, password } = this.form;

    this.authService.login(userId, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.authToken);
        this.tokenStorage.saveUser(data);
         //console.log(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  onAudit(){
   this.router.navigate(['./home']);
  }
  

  reloadPage(): void {
    window.location.reload();
   }

   
}

