package com.questionnaires.questionnaireapp.dao.securityDao;

import com.questionnaires.questionnaireapp.entity.securityEntity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String username);
}
