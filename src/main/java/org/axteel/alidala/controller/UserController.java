package org.axteel.alidala.controller;

import org.axteel.alidala.model.User;
import org.axteel.alidala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    /* Держим и пользуемся репозиторием здесь */
    private final UserRepository userRepository;

    /**
     * Связываем с контейнером
     * */
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository; // Подтягиваем репозиторий для базы
    }

    @RequestMapping (method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * Находим -> paging and sorting
     * */
    @RequestMapping (method = RequestMethod.GET, params = { "page", "size" })
    public Page getAll(@RequestParam("page") int page, @RequestParam("size") int size,
                       UriComponentsBuilder uriBuilder,
                       HttpServletResponse response) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    /**
     * For Local Validation
     * */
    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    */
}
