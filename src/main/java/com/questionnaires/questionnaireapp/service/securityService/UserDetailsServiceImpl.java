package com.questionnaires.questionnaireapp.service.securityService;

import com.questionnaires.questionnaireapp.dao.securityDao.UserRepository;
import com.questionnaires.questionnaireapp.entity.securityEntity.User;
import com.questionnaires.questionnaireapp.exceptions.security.UserHasAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found in the database"));
        return UserService.fromUser(user);
    }

    public User findByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found in the database"));
        return user;
    }

    public User saveUser(User user) throws UserHasAlreadyExistException {
        if (!userRepository.findByEmail(user.getEmail()).isPresent()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else {
            throw new UserHasAlreadyExistException("User has already exist");
        }
    }
}
