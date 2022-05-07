import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddfooditemsComponent } from './addfooditems.component';

describe('AddfooditemsComponent', () => {
  let component: AddfooditemsComponent;
  let fixture: ComponentFixture<AddfooditemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddfooditemsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddfooditemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
