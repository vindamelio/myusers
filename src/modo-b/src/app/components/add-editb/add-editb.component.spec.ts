import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditbComponent } from './add-editb.component';

describe('AddEditbComponent', () => {
  let component: AddEditbComponent;
  let fixture: ComponentFixture<AddEditbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditbComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
