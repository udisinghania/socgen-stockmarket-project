import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { SectorsComponent } from './components/sectors/sectors.component';
import { IposComponent } from './components/ipos/ipos.component';
import { StockExchangesComponent } from './components/stock-exchanges/stock-exchanges.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UserNavbarComponent } from './components/user-navbar/user-navbar.component';
import { AdminNavbarComponent } from './components/admin-navbar/admin-navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ImportExcelComponent } from './components/import-excel/import-excel.component';
import { ComparisonChartsComponent } from './components/comparison-charts/comparison-charts.component';
import { CreateCompanyComponent } from './components/companies/create-company/create-company.component';
import { CreateIpoComponent } from './components/ipos/create-ipo/create-ipo.component';
import { CreateStockExchangeComponent } from './components/stock-exchanges/create-stock-exchange/create-stock-exchange.component';
import { CreateSectorComponent } from './components/sectors/create-sector/create-sector.component';
import { AgGridModule } from 'ag-grid-angular';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { EditSectorComponent } from './components/sectors/edit-sector/edit-sector.component';
import { EditStockExchangeComponent } from './components/stock-exchanges/edit-stock-exchange/edit-stock-exchange.component';
import { EditCompanyComponent } from './components/companies/edit-company/edit-company.component';
import { EditIpoComponent } from './components/ipos/edit-ipo/edit-ipo.component';
@NgModule({
  declarations: [
    AppComponent,
    CompaniesComponent,
    SectorsComponent,
    IposComponent,
    StockExchangesComponent,
    NavbarComponent,
    UserNavbarComponent,
    AdminNavbarComponent,
    ImportExcelComponent,
    ComparisonChartsComponent,
    CreateCompanyComponent,
    CreateIpoComponent,
    CreateStockExchangeComponent,
    CreateSectorComponent,
    EditSectorComponent,
    EditStockExchangeComponent,
    EditCompanyComponent,
    EditIpoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgMultiSelectDropDownModule.forRoot(),
    AgGridModule.withComponents([CompaniesComponent,
      SectorsComponent,
      IposComponent,
      StockExchangesComponent])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
