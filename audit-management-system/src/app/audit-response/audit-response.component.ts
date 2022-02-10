import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ResponseService } from '../services/response.service';
import { TokenStorageService } from '../services/token-storage.service';


@Component({
  selector: 'app-audit-response',
  templateUrl: './audit-response.component.html',
  styleUrls: ['./audit-response.component.css']
})
export class AuditResponseComponent implements OnInit {
  response = <any>{} ;
  executionstatus = false;
   date = formatDate(new Date(), 'yyyy-MM-dd', 'en-US');
   request = {
    projectName:"",
    managerName:"",
    ownerName:"",
    auditDetails:{
      auditType:"",
      auditDate:"",
      questionResponse:""
    }
  };
  constructor( private responseservice:ResponseService,private tokenStorageService :TokenStorageService) { }

  ngOnInit(): void {
    const projectDetails = this.tokenStorageService.getProjectDetails();
    this.request.projectName = projectDetails.projectname;
    this.request.auditDetails.auditType = projectDetails.audittype;
    this.request.managerName = projectDetails.projectmanager;
    this.request.ownerName = projectDetails.applicationowner;
    this.request.auditDetails.auditDate = this.date;

    this.request.auditDetails.questionResponse = this.tokenStorageService.getResponse();

    this.responseservice.getauditresponse(this.request).subscribe(responses =>{
      this.response = responses;
     // console.log(this.response);
      if(responses.executionStatus === 'Red'){
        this.executionstatus = true;
      }
    });
      
  }

}
