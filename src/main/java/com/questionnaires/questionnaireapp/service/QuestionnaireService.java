package com.questionnaires.questionnaireapp.service;

import com.questionnaires.questionnaireapp.entity.questionnaireEntity.Questionnaire;

import java.util.List;

public interface QuestionnaireService {

    List<Questionnaire> getQuestionnaires();

    Questionnaire getQuestionnaire(Long id);

    Questionnaire saveQuestionnaire(Questionnaire questionnaire);

    Questionnaire updateQuestionnaire(Questionnaire questionnaire);

    void deleteQuestionnaire(Long id);


}
