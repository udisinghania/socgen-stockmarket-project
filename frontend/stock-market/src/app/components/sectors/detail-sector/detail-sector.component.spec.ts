import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailSectorComponent } from './detail-sector.component';

describe('DetailSectorComponent', () => {
  let component: DetailSectorComponent;
  let fixture: ComponentFixture<DetailSectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailSectorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailSectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
