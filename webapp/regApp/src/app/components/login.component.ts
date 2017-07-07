/**
 * Created by laci on 07/07/2017.
 */
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Md5} from 'ts-md5/dist/md5';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./registeruser.component.css']
})

export class LoginComponent {

  rForm: FormGroup;
  user:any;

  reqAlert: string = 'This fiels is required!';

  id: number = 0;
  userName: string = "";
  firstName: string = "";
  lastName: string = "";
  email: string = "";
  password: string = "";
  confirmed: boolean = false;
  roles: string[] = ["USER"];

  constructor(private fb: FormBuilder){
    this.rForm = fb.group({
      'email': [null, Validators.required],
      password: [null, Validators.required],
    });
  }


  loginUser(user){
    user.password = Md5.hashStr(user.password).toString();
    this.email = user.email;
    this.password = user.password;
    console.log(user);
  }

}

interface User{
  id: number;
  userName: string;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  confirmed: boolean;
  roles: string[];
}
