import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditdComponent } from './add-editd.component';

describe('AddEditdComponent', () => {
  let component: AddEditdComponent;
  let fixture: ComponentFixture<AddEditdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
