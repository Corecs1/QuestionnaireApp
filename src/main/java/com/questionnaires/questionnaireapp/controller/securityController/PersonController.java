package com.questionnaires.questionnaireapp.controller.securityController;

import com.questionnaires.questionnaireapp.entity.securityEntity.Person;
import com.questionnaires.questionnaireapp.entity.securityEntity.Role;
import com.questionnaires.questionnaireapp.service.securityService.PersonService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getUsers() {
        return ResponseEntity.ok().body(personService.getPersons());
    }

    @PostMapping("/persons/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(personService.savePerson(person));
    }

    @PostMapping("role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(personService.saveRole(role));
    }

    @PostMapping("role/addtoperson")
    public ResponseEntity<?> addRoleToPerson(@RequestBody RoleToPersonForm form) {
        personService.addRoleToPerson(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToPersonForm {
    private String username;
    private String roleName;
}
