import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogBillComponent } from './dialog-bill.component';

describe('DialogBillComponent', () => {
  let component: DialogBillComponent;
  let fixture: ComponentFixture<DialogBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogBillComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DialogBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
