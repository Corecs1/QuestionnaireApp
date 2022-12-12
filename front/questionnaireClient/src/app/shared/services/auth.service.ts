import {Injectable} from "@angular/core";
import {User} from "../interfaces";
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private email = ''
  private token = ''

  constructor(private http: HttpClient) {
  }

  setToken(token: string) {
    this.token = token
  }

  setEmail(email: string) {
    this.email = email;
  }

  getEmail(): string {
    return this.email
  }

  getToken(): string {
    return this.token
  }

  login(user: User): Observable<{ email: string, token: string }> {
    return this.http.post<{ email: string, token: string }>('/api/auth/login', user)
      .pipe(
        tap(
          ({email, token}) => {
            localStorage.setItem('user-email', email)
            localStorage.setItem('auth-token', token)
            this.setEmail(email)
            this.setToken(token)
          }
        )
      )
  }

  isAuthenticated(): boolean {
    return this.token != ''
  }

  logout() {
    this.setEmail('')
    this.setToken('')
    localStorage.clear()
  }

  register(user: User): Observable<User> {
    return this.http.post<User>('/api/auth/register', user)
  }
}
