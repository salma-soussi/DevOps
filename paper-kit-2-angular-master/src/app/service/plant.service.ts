import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Plant } from "app/model/plant";
import { Observable } from "rxjs";
import { Photos } from "app/model/photos";

@Injectable({
  providedIn: "root",
})
export class PlantService {
  host = "http://localhost:8090/api/plant";
  
  constructor(private client: HttpClient) {}

  public getAllPlants(): Observable<Plant[]> {
    return this.client.get<Plant[]>(this.host + "/all");
  }

  public getPlant(id: number): Observable<Plant> {
    return this.client.get<Plant>(this.host + "/one/" + id);
  }

  public getPlantPhoto(id: number): Observable<Photos> {
    return this.client.get<Photos>(this.host + "/photo/" + id);
  }
}
