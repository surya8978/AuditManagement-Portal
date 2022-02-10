import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuditQuestionsComponent } from './audit-questions/audit-questions.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorProviders } from './services/auth.interceptor';
import { AuthGuardService } from './services/auth-guard';
import { AuditResponseComponent } from './audit-response/audit-response.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    AuditQuestionsComponent,
    AuditResponseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [authInterceptorProviders,AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
