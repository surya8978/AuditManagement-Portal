import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

//const AUTH_API = 'http://service-lb-146430917.us-east-2.elb.amazonaws.com/auth/login';
//const AUTH_API = 'http://localhost:8080/auth/login';
const AUTH_API = 'http://localhost:8765/auth/login';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  login(userId: string, password: string): Observable<any> {
    return this.http.post(AUTH_API, {
      "userId":userId,
      "password":password
    }, httpOptions);
  }
}
