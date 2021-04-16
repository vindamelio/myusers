import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditeComponent } from './add-edite.component';

describe('AddEditeComponent', () => {
  let component: AddEditeComponent;
  let fixture: ComponentFixture<AddEditeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
