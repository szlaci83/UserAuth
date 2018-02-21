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

  private APIUrl = 'http://localhost:8080/register';


  public registerUser(body: User) {
    const headers  = new Headers({ 'Content-Type': 'application/json' });
    headers.append('Access-Control-Allow-Origin', '*');
    const originHeader = new Headers({ 'Content-Type': 'application/json' });
    const options  = new RequestOptions({ headers: headers });

    return this.http.post(this.APIUrl, body, options)
      .map(err => console.log(err),
        res  => console.log(res));
  }

  //
  // extractData(res: Response) {
  //   let body = res.json();
  //   return body || {};
  // }
  //
  // handleErrorPromise (error: Response | any) {
  //   console.error(error.message || error);
  //   return Promise.reject(error.message || error);
  // }
}
