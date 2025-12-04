import { Component, OnInit } from '@angular/core';
import { BackendService } from '../services/backend.service';

declare let L: any;

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  startDate: string = '';
  endDate: string = '';
  selectedLocation: { lat: number; lon: number } | null = null;
  temperatures: Array<{ date: string; temperature: number }> = [];

  constructor(private backend: BackendService) {}

  ngOnInit(): void {
    this.initMap();
  }

  initMap(): void {
    const map = L.map('map').setView([51.3, 10.1], 6);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map);

    map.on('click', (event: any) => {
      this.selectedLocation = {
        lat: event.latlng.lat,
        lon: event.latlng.lng
      };
    });
  }

  loadTemperatures(): void {
    if (!this.selectedLocation || !this.startDate || !this.endDate) return;

    this.backend
      .getTemperatureData(
        this.selectedLocation.lat,
        this.selectedLocation.lon,
        this.startDate,
        this.endDate
      )
      .subscribe((data) => (this.temperatures = data));
  }
}
