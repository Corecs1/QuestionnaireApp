import {Component, OnInit} from '@angular/core';
import {QuestionnairesService} from "../shared/services/questionnaires.service";
import {Questionnaire} from "../shared/interfaces";
import {Observable} from "rxjs";

@Component({
  selector: 'app-questionnaires-page',
  templateUrl: './questionnaires-page.component.html',
  styleUrls: ['./questionnaires-page.component.scss']
})
export class QuestionnairesPageComponent implements OnInit {

  questionnaires$: Observable<Questionnaire[]>

  constructor(private questionnairesService: QuestionnairesService) {
  }

  ngOnInit() {
    this.questionnaires$ = this.questionnairesService.fetch()
  }
}
