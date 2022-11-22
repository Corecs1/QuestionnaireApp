package com.questionnaires.questionnaireapp.controller;

import com.questionnaires.questionnaireapp.entity.Question;
import com.questionnaires.questionnaireapp.entity.Questionnaire;
import com.questionnaires.questionnaireapp.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/questionnaires")
    public String showAllQuestionnaires(Model model) {
        List<Questionnaire> questionnaires = questionnaireService.getQuestionnaires();
        model.addAttribute("questionnaires",questionnaires);
        return "home.html";
    }

    @GetMapping("/questionnaires/{id}")
    public String showQuestionnaire(@PathVariable int id, Model model) {
        Questionnaire questionnaire = questionnaireService.getQuestionnaire(id);
        model.addAttribute("questionnaire",questionnaire);
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
