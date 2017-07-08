/**
 * Created by laci on 06/07/2017.
 */
import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { User } from '../components/User';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RegisterUserService {
  constructor(private http: Http) {
    console.log('register User service started...');
  }

  private APIUrl = 'http://localhost:8080//register';


  registerUser(body: User) {
    //let bodyString = JSON.stringify(body);
    let headers  = new Headers({ 'Content-Type': 'application/json' });
    let originHeader = new Headers({ 'Content-Type': 'application/json' });
    let options  = new RequestOptions({ headers: headers });

    return this.http.post(this.APIUrl, body, options)
      .map((res : Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));

  }
}
