/**
 * Created by laci on 06/07/2017.
 */
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map';

@Injectable()

export class RegisterUserService {
  constructor(private http: Http) {
    console.log('User registration service started...');
  }


  static registerUser(User: any) {
      //sanity check
      //post request
      return null;
  }
}
