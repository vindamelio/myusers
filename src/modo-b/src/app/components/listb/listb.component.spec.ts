import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListbComponent } from './listb.component';

describe('ListbComponent', () => {
  let component: ListbComponent;
  let fixture: ComponentFixture<ListbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListbComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
