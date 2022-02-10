import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthGuardService } from './services/auth-guard';
import { AuditQuestionsComponent } from './audit-questions/audit-questions.component';
import { AuditResponseComponent } from './audit-response/audit-response.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent, canActivate:[AuthGuardService] },
  { path: 'login', component: LoginComponent },
  { path: 'auditresponse', component:AuditResponseComponent, canActivate:[AuthGuardService]},
  { path: 'auditquestions', component: AuditQuestionsComponent, canActivate:[AuthGuardService] },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
