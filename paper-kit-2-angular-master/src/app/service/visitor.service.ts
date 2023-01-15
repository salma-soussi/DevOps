import { HttpClient } from "@angular/common/http";
import { Visitor } from "@angular/compiler";
import { Injectable } from "@angular/core";
import { Category } from "app/model/category";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class VisitorService {
  host = "http://localhost:8090/api/visitor";
  constructor(private client: HttpClient) {}

  public add(fd: FormData): Observable<Visitor> {
    return this.client.post<Visitor>(this.host + "/add", fd);
  }

  public getPlant(id: number): Observable<Visitor> {
    return this.client.get<Visitor>(this.host + "/one/" + id);
  }
  public login(fd: FormData): Observable<Visitor> {
    return this.client.post<Visitor>(this.host + "/login", fd);
  }
}
