import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'the app works!';
  email = 'john@gmail.com';
  address = {
      street: 'London road',
      city: 'Manchester',
      postcode: 'MAN12UJ'
  }
}
