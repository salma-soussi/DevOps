import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Category } from "app/model/category";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CategoryService {
  host = "http://localhost:8090/api/category";
  constructor(private client: HttpClient) {}

  public getAllCategorys(): Observable<Category[]> {
    return this.client.get<Category[]>(this.host + "/all");
  }
}
