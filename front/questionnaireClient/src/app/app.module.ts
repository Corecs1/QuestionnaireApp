import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {AythLayuotComponent} from './shared/layouts/ayth-layuot/ayth-layuot.component';
import {SiteLayoutComponent} from './shared/layouts/site-layuot/site-layout.component';
import {RegistrationPageComponent} from './registration-page/registration-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { QuestionnairePageComponent } from './questionnaire-page/questionnaire-page.component';
import {TokenInterceptor} from "./shared/classes/token.interceptor";
import { CompletedQuestionnairesPageComponent } from './completed-questionnaires-page/completed-questionnaires-page.component';
import { AddPageComponent } from './add-page/add-page.component';
import { LoaderComponent } from './shared/components/loader/loader/loader.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    AythLayuotComponent,
    SiteLayoutComponent,
    RegistrationPageComponent,
    QuestionnairePageComponent,
    CompletedQuestionnairesPageComponent,
    AddPageComponent,
    LoaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      multi: true,
      useClass: TokenInterceptor
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
