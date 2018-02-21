/**
 * Created by laci on 09/07/2017.
 */
import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map';
import {Credential} from "../components/Credential";

@Injectable()
export class LoginService {
  constructor(private http: Http) {
    console.log('Login service started...');
  }

  APIUrl = 'http://localhost:8080/authorise/';

  Login(cr: Credential) {
    let headers  = new Headers({ 'Content-Type': 'application/json' } );
    headers.append('Access-Control-Allow-Origin', '*');
    let options  = new RequestOptions({ headers: headers });

    console.log(cr);
    return this.http.post(this.APIUrl, cr, options)
      .map((res  => console.log(res)));
  }
}
