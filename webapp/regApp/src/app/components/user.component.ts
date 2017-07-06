import { Component } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
    selector: 'user',
    templateUrl: './user.component.html',
    providers: [UserService]
})
export class UserComponent {
    name: string;
    email: string;
    address: address;
    roles: string[];
    showRoles: boolean;
    users: UserInt[];

    constructor(private userService: UserService) {
        this.name = 'John Doe';
        this.email = 'john@gmail.com';
        this.address = {
            street: 'London road',
            city: 'Manchester',
            postcode: 'MAN12UJ'
        }

        this.roles = ['ADMIN', 'USER'];
        this.showRoles = false;

        this.userService.getUsers().subscribe(users => {
            this.users = users;
        });
    }

    addRole(role) {
        this.roles.push(role);

    }

    deleteRole(i) {
        this.roles.splice(i, 1);
    }

    toggleRoles() {
        this.showRoles = !this.showRoles;
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

