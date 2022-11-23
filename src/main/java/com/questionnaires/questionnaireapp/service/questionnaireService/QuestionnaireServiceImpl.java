package com.questionnaires.questionnaireapp.service.questionnaireService;

import com.questionnaires.questionnaireapp.dao.questionnaireDao.QuestionnaireRepository;
import com.questionnaires.questionnaireapp.entity.questionnaireEntity.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
    public Questionnaire saveQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    @Override
    public Questionnaire updateQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    @Override
    public void deleteQuestionnaire(Long id) {
        questionnaireRepository.deleteById(id);
    }
}
