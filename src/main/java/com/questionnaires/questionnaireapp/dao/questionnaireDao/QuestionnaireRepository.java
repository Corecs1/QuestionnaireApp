package com.questionnaires.questionnaireapp.dao.questionnaireDao;

import com.questionnaires.questionnaireapp.entity.questionnaireEntity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
}
