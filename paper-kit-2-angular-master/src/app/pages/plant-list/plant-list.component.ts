import { Component, OnInit } from "@angular/core";
import { Category } from "app/model/category";
import { Plant } from "app/model/plant";
import { CategoryService } from "app/service/category.service";
import { PlantService } from "app/service/plant.service";

@Component({
  selector: "plant-list",
  templateUrl: "./plant-list.component.html",
  styleUrls: ["./plant-list.component.css"],
})
export class PlantListComponent implements OnInit {
  plants!: Plant[];
  plantsSer!: Plant[];
  constructor(
    private service: PlantService,
    private serviceCategory: CategoryService
  ) {}
  category!: Category[];
  page = 4;
  page1 = 5;
  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};

  fill() {
    this.category.forEach((cat) => {
      return this.dropdownList.push({ id: cat.id, itemName: cat.name });
    });
  }
  ngOnInit() {
    this.service.getAllPlants().subscribe((data) => {
      this.plants = data;
    });
    this.serviceCategory.getAllCategorys().subscribe((data) => {
      this.category = data;
      if (this.category) {
        this.fill();
      }
    });
    this.selectedItems = [];
    this.dropdownSettings = {
      singleSelection: false,
      text: "Select Categories...",
      selectAllText: "Select All",
      unSelectAllText: "UnSelect All",
      enableSearchFilter: true,
      classes: "c-btn,selected-list,ng-star-inserted",
    };
  }
  ngOnChanges() {}
  ngDoCheck() {
    if (this.dropdownList.length == 0) {
      this.fill();
    }
  }
  onItemSelect(item: any) {
    console.log(item);
    console.log(this.selectedItems);
  }
  OnItemDeSelect(item: any) {
    console.log(item);
    console.log(this.selectedItems);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
  onDeSelectAll(items: any) {
    console.log(items);
  }
}
