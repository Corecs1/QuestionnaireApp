package com.questionnaires.questionnaireapp.service.securityService;

import com.questionnaires.questionnaireapp.dao.securityDao.RoleRepository;
import com.questionnaires.questionnaireapp.dao.securityDao.PersonRepository;
import com.questionnaires.questionnaireapp.entity.securityEntity.Person;
import com.questionnaires.questionnaireapp.entity.securityEntity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToPerson(String username, String roleName) {
        Person person = personRepository.findByUserName(username);
        Role role = roleRepository.findByName(roleName);
        person.getRoles().add(role);
    }

    @Override
    public Person getPerson(String username) {
        return personRepository.findByUserName(username);
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
