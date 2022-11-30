package com.questionnaires.questionnaireapp;

import com.questionnaires.questionnaireapp.entity.securityEntity.Role;
import com.questionnaires.questionnaireapp.entity.securityEntity.Status;
import com.questionnaires.questionnaireapp.entity.securityEntity.User;
import com.questionnaires.questionnaireapp.service.securityService.UserDetailsServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuestionnaireAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireAppApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserDetailsServiceImpl userDetailsService) {
        return args -> {
            userDetailsService.saveUser(new User(null, "admin@gmail.com", "admin", "admin", "admin", Role.ROLE_ADMIN, Status.ACTIVE, null));
        };
    }
}
