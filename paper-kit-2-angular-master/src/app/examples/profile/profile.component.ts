import { Component, OnInit } from "@angular/core";
import { VisitorService } from "app/service/visitor.service";

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.scss"],
})
export class ProfileComponent implements OnInit {
  constructor(private service: VisitorService) {}

  ngOnInit() {}
}
