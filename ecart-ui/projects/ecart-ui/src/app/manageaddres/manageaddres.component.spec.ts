import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageaddresComponent } from './manageaddres.component';

describe('ManageaddresComponent', () => {
  let component: ManageaddresComponent;
  let fixture: ComponentFixture<ManageaddresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageaddresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageaddresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
