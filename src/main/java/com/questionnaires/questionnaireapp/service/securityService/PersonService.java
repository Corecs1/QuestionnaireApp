package com.questionnaires.questionnaireapp.service.securityService;

import com.questionnaires.questionnaireapp.entity.securityEntity.Person;
import com.questionnaires.questionnaireapp.entity.securityEntity.Role;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);

    Role saveRole(Role role);

    void addRoleToPerson(String username, String roleName);

    Person getPerson(String username);

    List<Person> getPersons();
}
