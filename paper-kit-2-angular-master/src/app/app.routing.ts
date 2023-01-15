import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";

import { ComponentsComponent } from "./components/components.component";
import { ProfileComponent } from "./examples/profile/profile.component";
import { SignupComponent } from "./examples/signup/signup.component";
import { LandingComponent } from "./examples/landing/landing.component";
import { NucleoiconsComponent } from "./components/nucleoicons/nucleoicons.component";
import { HomeComponent } from "./pages/home/home.component";
import { PlantListComponent } from "./pages/plant-list/plant-list.component";
import { PlantComponent } from "./pages/plant/plant.component";
import { ShoppingComponent } from "./pages/shopping/shopping.component";
import { RegisterComponent } from "./pages/register/register.component";

const routes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "home", component: HomeComponent },
  { path: "list", component: PlantListComponent },
  { path: "profile/:id", component: ProfileComponent },
  { path: "login", component: SignupComponent },
  { path: "register", component: RegisterComponent },
  { path: "plant/:id", component: PlantComponent },
  { path: "shopping", component: ShoppingComponent },
  { path: "test", component: ComponentsComponent },
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true,
    }),
  ],
  exports: [],
})
export class AppRoutingModule {}
