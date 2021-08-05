package ru.gorbunov.homework.api;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gorbunov.homework.model.User;


import javax.validation.Valid;


@Validated
public interface UserApi {


    @RequestMapping(value = "/user",
        method = RequestMethod.POST)
    ResponseEntity<Long> createUser( @Valid @RequestBody User body);


    @RequestMapping(value = "/user/{userId}",
        method = RequestMethod.DELETE)
    void deleteUser( @PathVariable("userId") Long userId);


    @RequestMapping(value = "/user/{userId}",
        method = RequestMethod.GET)
    ResponseEntity<User> findUserById(@PathVariable("userId") Long userId);


    @RequestMapping(value = "/user/{userId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser( @PathVariable("userId") Long userId, @Valid @RequestBody User body);

}

