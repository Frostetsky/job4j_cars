package ru.cars.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cars.app.dto.SignUpDto;
import ru.cars.app.persistence.User;
import ru.cars.app.repository.UserRepository;
import ru.cars.app.security.context.UserContext;

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
