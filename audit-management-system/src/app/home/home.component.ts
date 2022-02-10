import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content?: string;
  form: any = {
    projectname: null,
    projectmanager: null,
    applicationowner: null,
    audittype:null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';

  constructor( private tokenStorage: TokenStorageService ,  private router :Router) { }

  ngOnInit(): void {
     
    }
    onSubmit(): void {
          //console.log(this.form);
          this.tokenStorage.saveProjectDetails(this.form);
          this.router.navigate(['./auditquestions']);
    
  }
}
