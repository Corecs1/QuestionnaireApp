package com.questionnaires.questionnaireapp.controller;

import com.questionnaires.questionnaireapp.entity.questionnaireEntity.Questionnaire;
import com.questionnaires.questionnaireapp.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    private final QuestionnaireService questionnaireService;

    @GetMapping("/questionnaires")
    public ResponseEntity<List<Questionnaire>> showAllQuestionnaires() {
        List<Questionnaire> questionnaires = questionnaireService.getQuestionnaires();
        return new ResponseEntity<>(questionnaires, HttpStatus.OK);
    }

    @GetMapping("/questionnaires/{id}")
    public ResponseEntity<Questionnaire> showQuestionnaire(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireService.getQuestionnaire(id);
        return new ResponseEntity<>(questionnaire, HttpStatus.OK);
    }

    @PostMapping("/questionnaires/add")
    public ResponseEntity<Questionnaire> addQuestionnaire(@RequestBody Questionnaire questionnaire) {
        Questionnaire newQuestionnaire = questionnaireService.saveQuestionnaire(questionnaire);
        return new ResponseEntity<>(newQuestionnaire, HttpStatus.CREATED);
    }

    @PutMapping("/questionnaires/update")
    public ResponseEntity<Questionnaire> updateQuestionnaire(@RequestBody Questionnaire questionnaire) {
        Questionnaire updateQuestionnaire = questionnaireService.updateQuestionnaire(questionnaire);
        return new ResponseEntity<>(updateQuestionnaire, HttpStatus.OK);
    }

    @DeleteMapping("/questionnaires/delete/{id}")
    public ResponseEntity<?> updateQuestionnaire(@PathVariable Long id) {
        questionnaireService.deleteQuestionnaire(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
