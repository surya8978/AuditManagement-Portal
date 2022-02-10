import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

const RESP_API = "http://localhost:8765/severity/executionStatus";
//const RESP_API = "http://localhost:8082/severity/executionStatus";
//const RESP_API = "http://service-lb-146430917.us-east-2.elb.amazonaws.com/severity/executionStatus";

@Injectable({
  providedIn: 'root'
})
export class ResponseService {
  constructor(private http: HttpClient,private tokenStorage:TokenStorageService) { }

    
   getauditresponse(request:any): Observable<any>{
    const token = this.tokenStorage.getToken();
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authourization': token})
    };
     return this.http.post(RESP_API, request, httpOptions);
   }
    

}
