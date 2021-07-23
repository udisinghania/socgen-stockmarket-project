import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminNavbarComponent } from './components/admin-navbar/admin-navbar.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { CreateCompanyComponent } from './components/companies/create-company/create-company.component';
import { EditCompanyComponent } from './components/companies/edit-company/edit-company.component';
import { ComparisonChartsComponent } from './components/comparison-charts/comparison-charts.component';
import { ImportExcelComponent } from './components/import-excel/import-excel.component';
import { CreateIpoComponent } from './components/ipos/create-ipo/create-ipo.component';
import { EditIpoComponent } from './components/ipos/edit-ipo/edit-ipo.component';
import { IposComponent } from './components/ipos/ipos.component';
import { CreateSectorComponent } from './components/sectors/create-sector/create-sector.component';
import { EditSectorComponent } from './components/sectors/edit-sector/edit-sector.component';
import { SectorsComponent } from './components/sectors/sectors.component';
import { CreateStockExchangeComponent } from './components/stock-exchanges/create-stock-exchange/create-stock-exchange.component';
import { EditStockExchangeComponent } from './components/stock-exchanges/edit-stock-exchange/edit-stock-exchange.component';
import { StockExchangesComponent } from './components/stock-exchanges/stock-exchanges.component';
import { UserNavbarComponent } from './components/user-navbar/user-navbar.component';

const routes: Routes = [
  {path: 'user-navbar', component: UserNavbarComponent},
  {path: 'admin-navbar', component: AdminNavbarComponent},
  {path: 'companies', component: CompaniesComponent},
  {path: 'create-company', component: CreateCompanyComponent},
  {path: 'edit-company', component: EditCompanyComponent},
  {path: 'ipos', component: IposComponent},
  {path: 'create-ipo', component: CreateIpoComponent},
  {path: 'edit-ipo', component: EditIpoComponent},
  {path: 'stock-exchanges', component: StockExchangesComponent},
  {path: 'create-stock-exchange', component: CreateStockExchangeComponent},
  {path: 'edit-stock-exchange', component: EditStockExchangeComponent},
  {path: 'sectors', component: SectorsComponent},
  {path: 'create-sector', component: CreateSectorComponent},
  {path: 'edit-sector', component: EditSectorComponent},
  {path: 'import-excel', component: ImportExcelComponent},
  {path: 'comparison-charts', component: ComparisonChartsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
