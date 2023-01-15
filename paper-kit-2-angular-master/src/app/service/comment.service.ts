import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CommentService {
  host = "http://localhost:8090/api/comment";
  constructor(private client: HttpClient) {}

  public getAllComment(id: number): Observable<Comment[]> {
    return this.client.get<Comment[]>(this.host + "/allByPlant/" + id);
  }

  public add(fd: FormData): Observable<Comment> {
    return this.client.post<Comment>(this.host + "/add", fd);
  }
}
