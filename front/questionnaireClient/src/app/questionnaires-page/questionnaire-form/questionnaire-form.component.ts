import {Component, OnInit} from '@angular/core';
import {QuestionnairesService} from "../../shared/services/questionnaires.service";
import {Questionnaire} from "../../shared/interfaces";
import {Observable, switchMap} from "rxjs";
import {ActivatedRoute, Params} from "@angular/router";
import {MaterialService} from "../../shared/classes/material.service";

@Component({
  selector: 'app-questionnaire-form',
  templateUrl: './questionnaire-form.component.html',
  styleUrls: ['./questionnaire-form.component.scss']
})
export class QuestionnaireFormComponent implements OnInit {

  questionnaire$: Observable<Questionnaire>

  constructor(private questionnaireService: QuestionnairesService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.questionnaire$ = this.route
      .params
      .pipe(
        switchMap(
          (params: Params) => {
            return this.questionnaireService.getQuestionnaire(params['id'])
          }
        )
      )
      // .subscribe(
      //   questionnaire => {
      //     if (questionnaire) {
      //
      //     }
      //   },
      //   error => MaterialService.toast(error.error))
  }

}
