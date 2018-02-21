import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {
    constructor(private http: Http) {
        console.log('User service started...');
    }

    getUsers() {
      return this.http.get('http://localhost:8080/users')
           .map(res => res.json());
    }
}
