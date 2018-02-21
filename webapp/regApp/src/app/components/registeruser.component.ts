/**
 * Created by laci on 06/07/2017.
 */
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Md5} from 'ts-md5/dist/md5';
import { User } from '../components/User';
import { RegisterUserService} from '../services/registeruser.service';


@Component({
  selector: 'register',
  templateUrl: './registeruser.component.html',
  styleUrls: ['./registeruser.component.css'],
  providers: [RegisterUserService]
})


export class RegisterUserComponent {

  rForm: FormGroup;
  reqAlert = 'This field is required!';

  id = 0;
  userName = '';
  firstName = '';
  lastName = '';
  email = '';
  password = '';
  confirmed = false;
  //roles = '[USER]';
  theUser: User;

    constructor(private fb: FormBuilder, private registerUserService: RegisterUserService) {
      this.rForm = fb.group({
         'userName': [null, Validators.required],
         'email': [null, Validators.required],
         password: [null, Validators.required],
         'firstName': '',
         'lastName': ''
    });
    }

  registerUser(user) {
      this.theUser = new User(user.firstName, user.lastName, user.email, user.password, user.userName, 'false');
      console.log(JSON.stringify(this.theUser));
      this.registerUserService.registerUser(this.theUser).subscribe(res => {
        alert("Registration complete!");
      });
    }
}
