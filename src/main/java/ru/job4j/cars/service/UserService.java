package ru.job4j.cars.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.cars.dto.SignUpDto;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.UserRepository;
import ru.job4j.cars.security.context.UserContext;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(SignUpDto signUpDto) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setUsername(signUpDto.getUsername());
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var rsl = userRepository.findByUsername(username);
        var userContext = new UserContext();
        userContext.setUsername(rsl.getUsername());
        userContext.setPassword(rsl.getPassword());
        userContext.setId(rsl.getId());
        return userContext;
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId);
    }
}
