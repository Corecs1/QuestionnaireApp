package com.questionnaires.questionnaireapp.dao.securityDao;

import com.questionnaires.questionnaireapp.entity.securityEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
