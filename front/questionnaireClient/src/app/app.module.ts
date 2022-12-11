import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {AythLayuotComponent} from './shared/layouts/ayth-layuot/ayth-layuot.component';
import {SiteLayuotComponent} from './shared/layouts/site-layuot/site-layuot.component';
import {RegistrationPageComponent} from './registration-page/registration-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    AythLayuotComponent,
    SiteLayuotComponent,
    RegistrationPageComponent
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
