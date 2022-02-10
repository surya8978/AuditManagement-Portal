import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditQuestionsComponent } from './audit-questions.component';

describe('AuditQuestionsComponent', () => {
  let component: AuditQuestionsComponent;
  let fixture: ComponentFixture<AuditQuestionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuditQuestionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuditQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
