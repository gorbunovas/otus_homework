package ru.gorbunov.homework.api;


import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.gorbunov.homework.entity.UserEntity;
import ru.gorbunov.homework.model.User;
import ru.gorbunov.homework.service.UserService;


import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);
    private final MapperFacade mapper;
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createUser(@Valid @RequestBody User body) {
        return new ResponseEntity(userService.createUser(mapper.map(body, UserEntity.class)), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> findUserById(@PathVariable("userId") Long userId) {
        return new ResponseEntity(userService.getUserById(userId), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> updateUser(@PathVariable("userId") Long userId, @org.jetbrains.annotations.NotNull @RequestBody User body) {
        return new ResponseEntity(userService.updateUser(userId, mapper.map(body, UserEntity.class)), HttpStatus.OK);
    }

}
