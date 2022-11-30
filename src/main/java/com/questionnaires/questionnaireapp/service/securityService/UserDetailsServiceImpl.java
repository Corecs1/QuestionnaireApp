package com.questionnaires.questionnaireapp.service.securityService;

import com.questionnaires.questionnaireapp.dao.securityDao.UserRepository;
import com.questionnaires.questionnaireapp.entity.securityEntity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found in the database"));
        return UserService.fromUser(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
