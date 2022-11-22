package com.questionnaires.questionnaireapp.service;

import com.questionnaires.questionnaireapp.entity.Questionnaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionnaireService {

    List<Questionnaire> getQuestionnaires();

    Questionnaire getQuestionnaire(int id);

    void saveQuestionnaire(Questionnaire questionnaire);

    void deleteQuestionnaire(int id);


}
