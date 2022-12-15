export interface User {
  email: string
  password: string
  first_name: string
  last_name: string
}

export interface Questionnaire {
  id?: number
  name: string
  questions: [{
    id?: number
    question: string
    answers: [{
      id?: number
      answer: string
    }]
  }
  ]
}



