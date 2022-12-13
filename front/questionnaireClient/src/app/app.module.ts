import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {AythLayuotComponent} from './shared/layouts/ayth-layuot/ayth-layuot.component';
import {SiteLayoutComponent} from './shared/layouts/site-layuot/site-layout.component';
import {RegistrationPageComponent} from './registration-page/registration-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { QuestionnairePageComponent } from './questionnaire-page/questionnaire-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    AythLayuotComponent,
    SiteLayoutComponent,
    RegistrationPageComponent,
    QuestionnairePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
