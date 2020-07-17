package org.axteel.alidala.controller;

import org.axteel.alidala.model.User;
import org.axteel.alidala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController ("api/")
public class UserController {
    /* Держим и пользуемся репозиторием здесь */
    private final UserRepository userRepository;

    /**
     * Связываем с IoC контейнером
     * */
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository; // Подтягиваем репозиторий для базы
    }

    /* Выдаем страничку регистр пользователя*/
    @RequestMapping (value = "/signup", method = RequestMethod.GET)
    public String signUp(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("api/users/all")
    public List<User> getAll() {
        List<User> user = userRepository.findAll();
        return user;
    }

}
