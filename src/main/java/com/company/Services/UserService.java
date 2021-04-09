package com.company.Services;

import com.company.Entitys.User;
import com.company.Repositotys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public void signUpUser(User user) {
        final String encryptedPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        if(userRepository.findById(user.getUsername()).isEmpty()) {
            userRepository.save(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findById(s).get();
    }
}
