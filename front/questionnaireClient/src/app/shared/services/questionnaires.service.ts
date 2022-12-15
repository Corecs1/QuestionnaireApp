import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Questionnaire} from "../interfaces";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class QuestionnairesService {

  constructor(private http: HttpClient) {
  }

  fetch(): Observable<Questionnaire[]> {
    return this.http.get<Questionnaire[]>('/api/questionnaires')
  }
}
