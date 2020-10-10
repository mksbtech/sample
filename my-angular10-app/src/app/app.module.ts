import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SampleComponentComponent } from './sample-component/sample-component.component';
import { PostComponent } from './post/post.component';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {TableModule} from 'primeng/table';
import { RestaurantComponent } from './strapi/restaurant/restaurant.component';

@NgModule({
  declarations: [
    AppComponent,
    SampleComponentComponent,
    PostComponent,
    RestaurantComponent
    // TableModule
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    TableModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
