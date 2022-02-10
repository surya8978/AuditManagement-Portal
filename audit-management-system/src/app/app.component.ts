import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from './services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLoggedIn = false;
  username?: string;

  constructor(private tokenStorageService: TokenStorageService,private router: Router) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.username = user.userId;
     this.auto_logout(this.tokenStorageService.getUser().jwtExpirationMs);
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
    this.router.navigate(['/login']);
  }
  auto_logout(logouttime:number){
     setTimeout(() => {
      this.logout();
    },logouttime);
}
}
