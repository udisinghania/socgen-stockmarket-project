import { Component, OnInit } from '@angular/core';
import { StockChart } from 'angular-highcharts';

@Component({
  selector: 'app-comparison-charts',
  templateUrl: './comparison-charts.component.html',
  styleUrls: ['./comparison-charts.component.css']
})
export class ComparisonChartsComponent implements OnInit {
  stock!: StockChart;
  constructor() { }

  ngOnInit(): void {
   
  }

}
