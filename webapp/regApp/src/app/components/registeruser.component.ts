/**
 * Created by laci on 06/07/2017.
 */
import { Component } from '@angular/core';
import { RegisterUserService} from '../services/registeruser.service';

@Component({
  selector: 'register',
  templateUrl: './registeruser.component.html',
  providers: [RegisterUserService]
})


export class RegisterUserComponent {
    user: User;
    private registerUserService: RegisterUserService;




    registerUser(User){
      RegisterUserService.registerUser(User);
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
