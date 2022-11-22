package com.questionnaires.questionnaireapp.controller;

import com.questionnaires.questionnaireapp.entity.Questionnaire;
import com.questionnaires.questionnaireapp.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final QuestionnaireService questionnaireService;

    @GetMapping("/questionnaires")
    public String showAllQuestionnaires(Model model) {
        List<Questionnaire> questionnaires = questionnaireService.getQuestionnaires();
        model.addAttribute("questionnaires", questionnaires);
        return "home.html";
    }

    @GetMapping("/questionnaires/{id}")
    public String showQuestionnaire(@PathVariable Long id, Model model) {
        Questionnaire questionnaire = questionnaireService.getQuestionnaire(id);
        model.addAttribute("questionnaire", questionnaire);
        return "questionnaire.html";
    }

    @GetMapping("/questionnaires/add")
    public String addQuestionnaire(Model model) {
        Questionnaire questionnaire = new Questionnaire();
        model.addAttribute("questionnaire", questionnaire);
        return "questionnaire-add.html";
    }

    @PostMapping("/questionnaires/add")
    public String addQuestionnaire(@ModelAttribute Questionnaire questionnaire) {
        questionnaireService.saveQuestionnaire(questionnaire);
        return "redirect:/questionnaires";
    }
}
