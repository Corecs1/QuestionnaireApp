package com.questionnaires.questionnaireapp.service;

import com.questionnaires.questionnaireapp.dao.QuestionnaireRepository;
import com.questionnaires.questionnaireapp.entity.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public List<Questionnaire> getQuestionnaires() {
        return questionnaireRepository.findAll();
    }

    @Override
    public Questionnaire getQuestionnaire(int id) {
        Questionnaire questionnaire = null;
        Optional<Questionnaire> optional = questionnaireRepository.findById(id);
        if (optional.isPresent()) {
            questionnaire = optional.get();
        }
        return questionnaire;
    }

    @Override
    public void saveQuestionnaire(Questionnaire questionnaire) {
        questionnaireRepository.save(questionnaire);
    }

    @Override
    public void deleteQuestionnaire(int id) {
        questionnaireRepository.deleteById(id);
    }
}
