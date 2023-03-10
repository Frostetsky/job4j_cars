package ru.job4j.cars.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.cars.dto.SignUpDto;
import ru.job4j.cars.dto.WarningDto;
import ru.job4j.cars.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @GetMapping("/registration")
    public ModelAndView registration() {
        return new ModelAndView("registration", Map.of("signup", new SignUpDto()));
    }

    @GetMapping("/authorization")
    public ModelAndView login() {
        return new ModelAndView("authorization");
    }

    @PostMapping("/registration")
    public void registrationSubmit(@ModelAttribute("signup") SignUpDto signUpDto,
                                   HttpServletRequest httpServletRequest,
                                   HttpServletResponse httpServletResponse) throws IOException {

        userService.saveUser(signUpDto);
        httpServletResponse.sendRedirect(String.format("%s/auth/authorization", httpServletRequest.getContextPath()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView duplicateUsername() {
        var warningDto = new WarningDto();
        warningDto.setMessage("Данный логин уже занят. Придумайте другой");
        return new ModelAndView("error", Map.of("info", warningDto));
    }
}
