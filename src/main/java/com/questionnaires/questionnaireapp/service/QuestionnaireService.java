package com.questionnaires.questionnaireapp.service;

import com.questionnaires.questionnaireapp.entity.Questionnaire;

import java.util.List;

public interface QuestionnaireService {

    List<Questionnaire> getQuestionnaires();

    Questionnaire getQuestionnaire(Long id);

    void saveQuestionnaire(Questionnaire questionnaire);

    void deleteQuestionnaire(Long id);


}
