/**
 * Created by laci on 06/07/2017.
 */
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
//import { RegisterUserService} from '../services/registeruser.service';


@Component({
  selector: 'register',
  templateUrl: './registeruser.component.html',
  styleUrls: ['./registeruser.component.css']
 // providers: [RegisterUserService]
})


export class RegisterUserComponent {

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
         'userName': [null, Validators.required],
         'email': [null, Validators.required],
         password: [null, Validators.required],
         'firstName': '',
         'lastName': ''
    });
    }

   // private registerUserService: RegisterUserService;




    registerUser(user){
      this.userName = user.userName;
      this.email = user.email;
      console.log(user);

     // RegisterUserService.registerUser(User);
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
