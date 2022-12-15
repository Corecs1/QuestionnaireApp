import {Component} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-site-layuot',
  templateUrl: './site-layout.component.html',
  styleUrls: ['./site-layout.component.scss']
})
export class SiteLayoutComponent {

  links = [
    {url: '/questionnaires', name: 'Обзор анкет'},
    {url: '/completed_questionnaires', name: 'Пройденные анкеты'},
    {url: '/add', name: 'Добавить анкету'}
  ]

  constructor(private auth: AuthService,
              private router: Router) {
  }

  logout(event: Event) {
    event.preventDefault()
    this.auth.logout()
    this.router.navigate(['/login'])
  }
}
