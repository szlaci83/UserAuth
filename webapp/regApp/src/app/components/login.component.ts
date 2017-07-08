/**
 * Created by laci on 07/07/2017.
 */
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Md5} from 'ts-md5/dist/md5';
import { Credential } from '../components/Credential';
import { LoginService} from '../services/login.service'

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./registeruser.component.css'],
  providers: [LoginService]
})

export class LoginComponent {

  rForm: FormGroup;
  reqAlert: string = 'This fiels is required!';
  credentials: Credential;
  private loginService: LoginService;

  constructor(private fb: FormBuilder){
    this.rForm = fb.group({
      'email': [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  loginUser(user){
    //this.credentials = new Credential(user.email,  Md5.hashStr(user.password).toString());
    this.credentials = new Credential(user.email, user.password);
    //console.log(this.credentials);
    this.loginService.Login(this.credentials).subscribe(
      data => alert(data),
      error => alert(error)
    );


  }

}

