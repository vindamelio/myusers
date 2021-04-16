import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditcComponent } from './add-editc.component';

describe('AddEditcComponent', () => {
  let component: AddEditcComponent;
  let fixture: ComponentFixture<AddEditcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
