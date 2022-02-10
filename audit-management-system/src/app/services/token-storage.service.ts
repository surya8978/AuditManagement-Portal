import { Injectable } from '@angular/core';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
const PROJECTDETAILS_KEY = 'audit-details'
const RESPONSE_KEY = 'audit-response';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  constructor() { }

  signOut(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null {
   // console.log(window.sessionStorage.getItem(TOKEN_KEY));
    return window.sessionStorage.getItem(TOKEN_KEY);

  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      //console.log(window.sessionStorage.getItem(USER_KEY));
      return JSON.parse(user);
    }

    return {};
  }

  public saveProjectDetails(PROJECTDETAILS: any): void {
    window.sessionStorage.removeItem(PROJECTDETAILS_KEY);
    window.sessionStorage.setItem(PROJECTDETAILS_KEY, JSON.stringify(PROJECTDETAILS));
  }

  public getProjectDetails(): any {
    const PROJECTDETAILS = window.sessionStorage.getItem(PROJECTDETAILS_KEY);
    if (PROJECTDETAILS) {
      //console.log(window.sessionStorage.getItem(PROJECTDETAILS_KEY));
      return JSON.parse(PROJECTDETAILS);
    }

    return {};
  }
   
  public saveResponse(response: any): void {
    window.sessionStorage.removeItem(RESPONSE_KEY);
    window.sessionStorage.setItem(RESPONSE_KEY, JSON.stringify(response));
  }

  public getResponse(): any {
    const response = window.sessionStorage.getItem(RESPONSE_KEY);
    if (response) {
     // console.log(window.sessionStorage.getItem(RESPONSE_KEY));
      return JSON.parse(response);
    }

    return {};
  }

  public isUserLoggedIn():any {
    let user = window.sessionStorage.getItem(USER_KEY);
    if (user === null) 
    {
      return false
    }
    return true
  }

  
}
