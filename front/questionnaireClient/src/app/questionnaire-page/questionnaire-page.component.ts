import {Component, OnInit} from '@angular/core';
import {QuestionnairesService} from "../shared/services/questionnaires.service";
import {Questionnaire} from "../shared/interfaces";

@Component({
  selector: 'app-questionnaire-page',
  templateUrl: './questionnaire-page.component.html',
  styleUrls: ['./questionnaire-page.component.scss']
})
export class QuestionnairePageComponent implements OnInit {

  loading = false
  questionnaires: Questionnaire[]

  constructor(private questionnairesService: QuestionnairesService) {
  }

  ngOnInit() {
    this.loading = true
    this.questionnairesService.fetch().subscribe(questionnaires => {
      this.loading = false
      this.questionnaires = questionnaires
      console.log('Questionnaires', questionnaires)
    })
  }
}
