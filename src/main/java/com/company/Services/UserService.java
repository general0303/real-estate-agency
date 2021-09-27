package com.company.Services;

import com.company.Entitys.User;
import com.company.Repositotys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Класс UserService, который отвечает за бизнес-логику работы с пользователями
 * Имеет два приватных свойства - userRepository и encoder
 * Имплементирует интерфейс UserDetailService
 */
@Service
public class UserService implements UserDetailsService {
    /**
     * Поле encoder обозначает, каким алгоритмом будут шифроваться данные пользователей
     */
    @Autowired
    BCryptPasswordEncoder encoder;

    /** Репозиторий, необходимый для работы с базой */
    @Autowired
    private UserRepository userRepository;

    /**
     * Метод поиска пользователя по имени
     * @param s - имя пользователя
     * @return объект класса UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findById(s).get();
    }
}
