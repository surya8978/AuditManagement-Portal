import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditResponseComponent } from './audit-response.component';

describe('AuditResponseComponent', () => {
  let component: AuditResponseComponent;
  let fixture: ComponentFixture<AuditResponseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuditResponseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuditResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
