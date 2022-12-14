package com.questionnaires.questionnaireapp.restController.questionnaireRestController;

import com.questionnaires.questionnaireapp.entity.questionnaireEntity.Questionnaire;
import com.questionnaires.questionnaireapp.service.questionnaireService.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeRestController {

    private final QuestionnaireService questionnaireService;

    @GetMapping("/questionnaires")
    @PreAuthorize("hasAnyAuthority('questionnaires:read')")
    public ResponseEntity<List<Questionnaire>> showAllQuestionnaires() {
        List<Questionnaire> questionnaires = questionnaireService.getQuestionnaires();
        return new ResponseEntity<>(questionnaires, HttpStatus.OK);
    }

    @GetMapping("/questionnaires/{id}")
    @PreAuthorize("hasAnyAuthority('questionnaires:read')")
    public ResponseEntity<Questionnaire> showQuestionnaire(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireService.getQuestionnaire(id);
        return new ResponseEntity<>(questionnaire, HttpStatus.OK);
    }

    @PostMapping("/questionnaires/add")
    @PreAuthorize("hasAnyAuthority('questionnaires:write')")
    public ResponseEntity<Questionnaire> addQuestionnaire(@RequestBody Questionnaire questionnaire) {
        Questionnaire newQuestionnaire = questionnaireService.saveQuestionnaire(questionnaire);
        return new ResponseEntity<>(newQuestionnaire, HttpStatus.CREATED);
    }

    @PutMapping("/questionnaires/update")
    @PreAuthorize("hasAnyAuthority('questionnaires:write')")
    public ResponseEntity<Questionnaire> updateQuestionnaire(@RequestBody Questionnaire questionnaire) {
        Questionnaire updateQuestionnaire = questionnaireService.updateQuestionnaire(questionnaire);
        return new ResponseEntity<>(updateQuestionnaire, HttpStatus.OK);
    }

    @DeleteMapping("/questionnaires/delete/{id}")
    @PreAuthorize("hasAnyAuthority('questionnaires:write')")
    public ResponseEntity<?> updateQuestionnaire(@PathVariable Long id) {
        questionnaireService.deleteQuestionnaire(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
