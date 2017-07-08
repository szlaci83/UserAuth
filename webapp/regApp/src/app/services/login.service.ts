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

  Login(cr: Credential) {
    let headers  = new Headers({ 'Content-Type': 'text/plain' } );
    let options  = new RequestOptions({ headers: headers });

    return this.http.post('http://localhost:8080//authorise/' + cr.email +"/" + cr.password, "", options)
      .map((res  => res.json()));
  }
}
