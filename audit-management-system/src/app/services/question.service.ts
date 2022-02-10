import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

//const AUTH_API = 'http://service-lb-146430917.us-east-2.elb.amazonaws.com/checklist/';
//const AUTH_API = 'http://localhost:8081/checklist/';
const AUTH_API = 'http://localhost:8765/checklist/';


@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  constructor(private http: HttpClient,  private tokenStorage: TokenStorageService) { }

  getauditquestions(audittype:string): Observable<any> {
    const token = this.tokenStorage.getToken();
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authourization': token })
    };
    return this.http.get<[]>(AUTH_API + audittype,httpOptions);
  }
}
