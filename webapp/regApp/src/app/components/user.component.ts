import { Component } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
    selector: 'user',
    template: `
  <h1>
    Hello
    {{name}}
    </h1>
    <p>
      Email : {{email}}
    </p>

    <p>
   Address : {{address.street}}
              {{address.city}}
            {{address.postcode}}

    </p>
    <button (click)="toggleRoles()">{{showRoles ? "Hide Roles!" : "Show Roles!"}}</button>
    <div *ngIf="showRoles">
    <ul>
        <li *ngFor="let role of roles; let i = index">
            {{role}} <button (click) = "deleteRole(i)">X</button>
         </li>
    </ul>

   <form (submit)="addRole(role.value)">
     <label>Add role: </label> <br />
     <input type="text" #role/> <br />
    </form>  

    </div>
    <h3> Edit user</h3>
    <form>
        <label>Name: </label> <br />
        <input type="text" name = "name" [(ngModel)]="name"/> <br />
        
        <label>Email: </label> <br />
        <input type="text" name = "email" [(ngModel)]="email"/> <br />

        <label>City: </label> <br />
        <input type="text" name = "address.city" [(ngModel)]="address.city"/> <br />

        <label>Postcode</label> <br />
        <input type="text" name = "address.postcode" [(ngModel)]="address.postcode"/> <br />

    </form>

    <h3> Users from Spring boot app </h3>
        <div *ngFor="let user of users">
            <h3>{{user.userName}}</h3>
            <h3>{{user.email}}</h3>
        </div>

  `,
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

