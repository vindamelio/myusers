import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProvaComponent } from './components/prova/prova.component';
const routes: Routes = [
  {path:"", redirectTo: '/home', pathMatch:'full'},
  {path:'home', component: HomeComponent},
  {path:'home/:id', component: HomeComponent},
  {path:'prova', component: ProvaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
