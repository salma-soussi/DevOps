import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Photos } from "app/model/photos";
import { Plant } from "app/model/plant";
import { CommentService } from "app/service/comment.service";
import { PlantService } from "app/service/plant.service";

@Component({
  selector: "plant",
  templateUrl: "./plant.component.html",
  styleUrls: ["./plant.component.css"],
})
export class PlantComponent implements OnInit {
  constructor(
    private ar: ActivatedRoute,
    private service: PlantService,
    private serviceComment: CommentService,
    private router: Router
  ) {}
  plant!: Plant;
  comments!: Comment[];
  photos!: Photos;
  page = 1;
  id = parseInt(localStorage.getItem("id"));
  ngOnInit() {
    let id = this.ar.snapshot.params["id"];
    this.service.getPlant(id).subscribe((data) => {
      this.plant = data;
    });
    this.service.getPlantPhoto(id).subscribe((data) => {
      this.photos = data;
      console.log(this.photos);
    });
    this.serviceComment.getAllComment(id).subscribe((data) => {
      this.comments = data;
      console.log(this.comments);
    });
  }

  onSubmit(f: NgForm) {
    let fd = new FormData();
    fd.append(
      "comment",
      JSON.stringify({
        text: f.value.text,
        visitor: { id: this.id },
        plant: { id: this.plant.id },
      })
    );
    this.serviceComment.add(fd).subscribe(() => {
      window.location.reload();
    });
  }
}
