import { Visitor } from "@angular/compiler";
import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { VisitorService } from "app/service/visitor.service";

@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.scss"],
})
export class SignupComponent implements OnInit {
  test: Date = new Date();
  focus;
  focus1;
  constructor(private service: VisitorService, private router: Router) {}

  ngOnInit() {}

  onSubmit(f: NgForm) {
    let fd = new FormData();
    fd.append("email", f.value.email);
    fd.append("password", f.value.password);
    this.service.login(fd).subscribe((data: any) => {
      if (data) {
        console.log(data);
        localStorage.setItem("id", data.id + "");
        localStorage.setItem("name", data.name + "");
        localStorage.setItem("lastname", data.lastName);
        this.router.navigate(["/list"]);
      } else {
        console.log("wrong");
      }
    });
  }
}
