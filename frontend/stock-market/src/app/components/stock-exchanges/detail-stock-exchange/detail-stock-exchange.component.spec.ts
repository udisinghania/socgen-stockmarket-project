import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailStockExchangeComponent } from './detail-stock-exchange.component';

describe('DetailStockExchangeComponent', () => {
  let component: DetailStockExchangeComponent;
  let fixture: ComponentFixture<DetailStockExchangeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailStockExchangeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailStockExchangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
