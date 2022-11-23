package com.questionnaires.questionnaireapp.dao.securityDao;

import com.questionnaires.questionnaireapp.entity.securityEntity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUserName(String username);
}
