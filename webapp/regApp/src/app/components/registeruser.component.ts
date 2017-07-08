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

  registerUserService: RegisterUserService;
  rForm: FormGroup;
  reqAlert: string = 'This fiels is required!';

  id: number = 0;
  userName: string = "";
  firstName: string = "";
  lastName: string = "";
  email: string = "";
  password: string = "";
  confirmed: boolean = false;
  roles: string[] = ["USER"];
  theUser: User;

    constructor(private fb: FormBuilder){
      this.rForm = fb.group({
         'userName': [null, Validators.required],
         'email': [null, Validators.required],
         password: [null, Validators.required],
         'firstName': '',
         'lastName': ''
    });
    }

  registerUser(user)
    {
      this.theUser = new User(user.userName, user.firstName, user.lastName, user.email, user.password, "false");
      console.log(JSON.stringify(this.theUser));
      this.registerUserService.registerUser(this.theUser)
        .subscribe(
        //  data => alert(data),
          error => alert(error),
         // () => console.log("Getusers finished!")
        );


    }
}
