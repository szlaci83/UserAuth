import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { ReactiveFormsModule  } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { UserComponent } from './components/user.component';
import { RegisterUserComponent } from './components/registeruser.component';
import {LoginComponent} from './components/login.component';

import { routing} from './app.routing';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    RegisterUserComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
