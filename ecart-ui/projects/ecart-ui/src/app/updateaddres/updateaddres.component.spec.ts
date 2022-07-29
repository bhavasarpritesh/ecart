import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateaddresComponent } from './updateaddres.component';

describe('UpdateaddresComponent', () => {
  let component: UpdateaddresComponent;
  let fixture: ComponentFixture<UpdateaddresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateaddresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateaddresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
