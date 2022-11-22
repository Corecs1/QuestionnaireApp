package com.questionnaires.questionnaireapp.service;

import com.questionnaires.questionnaireapp.dao.QuestionnaireRepository;
import com.questionnaires.questionnaireapp.entity.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    @Override
    public List<Questionnaire> getQuestionnaires() {
        return questionnaireRepository.findAll();
    }

    @Override
    public Questionnaire getQuestionnaire(Long id) {
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
    public void deleteQuestionnaire(Long id) {
        questionnaireRepository.deleteById(id);
    }
}
