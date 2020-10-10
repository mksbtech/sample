import { LocationStrategy, HashLocationStrategy, PathLocationStrategy } from '@angular/common';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PostComponent } from './post/post.component';
import { SampleComponentComponent } from './sample-component/sample-component.component';
import { RestaurantComponent } from './strapi/restaurant/restaurant.component';


const routes: Routes = [
  { path: '', component: SampleComponentComponent},
  { path: 'posts', component: PostComponent },
  { path: 'restaurants', component: RestaurantComponent },
   { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {paramsInheritanceStrategy: 'always', urlUpdateStrategy: 'deferred'})],
  exports: [RouterModule],
  providers: [{provide: LocationStrategy, useClass: PathLocationStrategy}]
})
export class AppRoutingModule { }
