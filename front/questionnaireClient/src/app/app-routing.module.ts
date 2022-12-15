import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginPageComponent} from "./login-page/login-page.component";
import {AythLayuotComponent} from "./shared/layouts/ayth-layuot/ayth-layuot.component";
import {SiteLayoutComponent} from "./shared/layouts/site-layuot/site-layout.component";
import {RegistrationPageComponent} from "./registration-page/registration-page.component";
import {AuthGuard} from "./shared/classes/auth.guard";
import {QuestionnairePageComponent} from "./questionnaire-page/questionnaire-page.component";
import {
  CompletedQuestionnairesPageComponent
} from "./completed-questionnaires-page/completed-questionnaires-page.component";
import {AddPageComponent} from "./add-page/add-page.component";

const routes: Routes = [
  {
    path: '', component: AythLayuotComponent, children: [
      {path: '', redirectTo: 'login', pathMatch: 'full'},
      {path: 'login', component: LoginPageComponent},
      {path: 'registration', component: RegistrationPageComponent}
    ]
  },
  {
    path: '', component: SiteLayoutComponent, canActivate: [AuthGuard], children: [
      {path: 'questionnaires', component: QuestionnairePageComponent},
      {path: 'completed_questionnaires', component: CompletedQuestionnairesPageComponent},
      {path: 'add', component: AddPageComponent}
    ]
  },
]

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
