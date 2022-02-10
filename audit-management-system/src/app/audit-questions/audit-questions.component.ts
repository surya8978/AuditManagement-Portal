import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { QuestionService } from '../services/question.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-audit-questions',
  templateUrl: './audit-questions.component.html',
  styleUrls: ['./audit-questions.component.css']
})
export class AuditQuestionsComponent implements OnInit {
  formgroup = new FormGroup({});
   questions = [];
   audittype?: string;
   errorMessage = '';
   responses;
   auditresponse:string;
   form: any = { 
  }; 
  no:any=0

  constructor(private questionservice:QuestionService,private cdref: ChangeDetectorRef,
    private tokenStorage:TokenStorageService,private router:Router) { }

  ngOnInit(): void {
    const projectdetails =  this.tokenStorage.getProjectDetails();
     this.audittype = projectdetails.audittype;
      this.questionservice.getauditquestions(projectdetails.audittype).subscribe(responses =>{
          this.responses = responses;
          for (let index = 0; index < this.responses.length; index++) {
            const element = this.responses[index];
            this.formgroup.addControl(element.questionId,new FormControl());
          }
      });
  }
  ngAfterContentChecked() {
    this.cdref.detectChanges();
  }

 onSubmit(){
   //console.log(this.formgroup);
  
   for(let i=0; i<this.responses.length; i++){
     this.responses[i].response = this.formgroup.get(this.responses[i].questionId.toString()).value;
     if(this.responses[i].response === 'NO'){
        this.no++;
     }
   }
   this.tokenStorage.saveResponse(this.no);
  // console.log(this.no);
   //console.log(this.responses);
   
   this.router.navigate(['./auditresponse']);

 }
 }

