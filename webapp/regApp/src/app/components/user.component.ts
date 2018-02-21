import { Component } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
    selector: 'user',
    templateUrl: './user.component.html',
    styleUrls: ['./registeruser.component.css'],
    providers: [UserService]
})
export class UserComponent {
    users: UserInt[];

    constructor(private userService: UserService) {
        this.userService.getUsers().subscribe(users => {
            this.users = users,
            error => alert(error),
            () => console.log("GetUsers finished!");
        });
    }
}


interface address {
  street: string;
  city: string;
 postcode: string;
}

interface UserInt {
    id: number;
    userName: string;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    confirmed: boolean;
    roles: string[];
}

