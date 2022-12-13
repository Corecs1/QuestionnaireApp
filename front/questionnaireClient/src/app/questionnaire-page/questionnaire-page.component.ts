import {Component} from '@angular/core';

class Answer {
  id: number
  question: string
}

class Question {
  id: number
  question: string
  answers: [Answer]
}

class Questionnaire {
  id: number
  name: string
  questions: [Question]
}

@Component({
  selector: 'app-questionnaire-page',
  templateUrl: './questionnaire-page.component.html',
  styleUrls: ['./questionnaire-page.component.scss']
})
export class QuestionnairePageComponent {
  questionnaire: Questionnaire
}
