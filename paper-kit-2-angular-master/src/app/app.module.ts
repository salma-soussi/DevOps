import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { RouterModule } from "@angular/router";
import { AppRoutingModule } from "./app.routing";
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from "./app.component";
import { NavbarComponent } from "./shared/navbar/navbar.component";
import { FooterComponent } from "./shared/footer/footer.component";

import { ComponentsModule } from "./components/components.module";
import { ExamplesModule } from "./examples/examples.module";
import { HomeComponent } from "./pages/home/home.component";
import { PlantComponent } from "./pages/plant/plant.component";
import { PlantListComponent } from "./pages/plant-list/plant-list.component";
import { ProfileComponent } from "./pages/profile/profile.component";
import { AngularMultiSelectModule } from "angular2-multiselect-dropdown";
import { ShoppingComponent } from "./pages/shopping/shopping.component";
import { RegisterComponent } from "./pages/register/register.component";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    PlantComponent,
    PlantListComponent,
    ProfileComponent,
    ShoppingComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    ComponentsModule,
    ExamplesModule,
    AngularMultiSelectModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
