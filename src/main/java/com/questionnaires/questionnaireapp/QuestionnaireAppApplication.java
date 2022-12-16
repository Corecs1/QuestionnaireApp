package com.questionnaires.questionnaireapp;

import com.questionnaires.questionnaireapp.entity.questionnaireEntity.Answer;
import com.questionnaires.questionnaireapp.entity.questionnaireEntity.Question;
import com.questionnaires.questionnaireapp.entity.questionnaireEntity.Questionnaire;
import com.questionnaires.questionnaireapp.entity.securityEntity.Role;
import com.questionnaires.questionnaireapp.entity.securityEntity.Status;
import com.questionnaires.questionnaireapp.entity.securityEntity.User;
import com.questionnaires.questionnaireapp.service.questionnaireService.QuestionnaireService;
import com.questionnaires.questionnaireapp.service.securityService.UserDetailsServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class QuestionnaireAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireAppApplication.class, args);
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    CommandLineRunner run(UserDetailsServiceImpl userDetailsService, QuestionnaireService questionnaireService) {
        return args -> {
            userDetailsService.saveUser(new User(null,
                    "admin@gmail.com",
                    "admin",
                    "admin",
                    "admin111",
                    Role.ROLE_ADMIN,
                    Status.ACTIVE,
                    null));

            List<Answer> answers = new ArrayList<>();
            answers.add(new Answer(null, "9"));
            answers.add(new Answer(null, "15"));
            answers.add(new Answer(null, "3"));
            answers.add(new Answer(null, "5"));

            List<Question> questions = new ArrayList<>();
            questions.add(new Question(null, "10+5=?", answers));
            questions.add(new Question(null, "9-4=?", answers));

            Questionnaire questionnaire = new Questionnaire(null, "Math", questions);

            questionnaireService.saveQuestionnaire(questionnaire);

            List<Answer> answers1 = new ArrayList<>();
            answers1.add(new Answer(null, "Латте"));
            answers1.add(new Answer(null, "Американо"));
            answers1.add(new Answer(null, "Эспрессо"));
            answers1.add(new Answer(null, "Капучино"));

            List<Question> questions1 = new ArrayList<>();
            questions1.add(new Question(null, "Выберите ваш любимый кофе", answers1));

            Questionnaire questionnaire1 = new Questionnaire(null, "Любимый кофе", questions1);

            questionnaireService.saveQuestionnaire(questionnaire1);
        };
    }
}
