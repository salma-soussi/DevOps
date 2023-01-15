import { Visitor } from "@angular/compiler";
import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { VisitorService } from "app/service/visitor.service";

@Component({
  selector: "register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  test: Date = new Date();
  focus;
  focus1;
  file!: File;
  constructor(private service: VisitorService, private router: Router) {}

  ngOnInit(): void {}

  onSubmit(f: NgForm) {
    let fd = new FormData();
    let visitor = {
      name: f.value.name,
      lastName: f.value.lastName,
      email: f.value.email,
      password: f.value.password,
    };
    let address = {
      num: f.value.num,
      rue: f.value.rue,
      ville: f.value.ville,
      codePostal: f.value.codePostal,
    };
    fd.append("photo", this.file);
    fd.append("visitor", JSON.stringify(visitor));
    fd.append("address", JSON.stringify(address));
    this.service.add(fd).subscribe((data) => {
      if (data) {
        console.log(data);
        localStorage.setItem("id", data + "");
        localStorage.setItem("name", visitor.name);
        localStorage.setItem("lastname", visitor.lastName);
        this.router.navigate(["/list"]);
      } else {
        console.log("wrong");
      }
    });
  }

  selectImage(x: any) {
    this.file = x.target.files[0];
  }
}
