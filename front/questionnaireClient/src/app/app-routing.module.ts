import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginPageComponent} from "./login-page/login-page.component";
import {AythLayuotComponent} from "./shared/layouts/ayth-layuot/ayth-layuot.component";
import {SiteLayuotComponent} from "./shared/layouts/site-layuot/site-layuot.component";
import {RegistrationPageComponent} from "./registration-page/registration-page.component";

const routes: Routes = [
  {
    path: '', component: AythLayuotComponent, children: [
      {path: '', redirectTo: 'login', pathMatch: 'full'},
      {path: 'login', component: LoginPageComponent},
      {path: 'registration', component: RegistrationPageComponent}
    ]
  },
  {
    path: '', component: SiteLayuotComponent, children: []
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
