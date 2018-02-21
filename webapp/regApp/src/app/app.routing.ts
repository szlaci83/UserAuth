/**
 * Created by laci on 06/07/2017.
 */
import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {UserComponent} from './components/user.component';
import {RegisterUserComponent} from './components/registeruser.component';
import {LoginComponent} from './components/login.component';

const appRoutes: Routes = [
  {
    path:"users",
    component: UserComponent
  },
  {
    path:"register",
    component: RegisterUserComponent
  },
  {
    path:"login",
    component: LoginComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
