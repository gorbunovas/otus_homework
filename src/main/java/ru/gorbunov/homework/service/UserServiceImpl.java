package ru.gorbunov.homework.service;

import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import ru.gorbunov.homework.Exception.NotFoundException;
import ru.gorbunov.homework.entity.UserEntity;
import ru.gorbunov.homework.model.User;
import ru.gorbunov.homework.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final MapperFacade mapper;
    private final UserRepository userRepo;

    @Override
    public List<User> getUsers() {
        return  mapper.mapAsList(userRepo.findAll(), User.class);
    }

    @Override
    public Long createUser(UserEntity user) {
        return mapper.map(userRepo.save(user), User.class).getId();
    }

    @Override
    public User getUserById(Long id) {
        var optUser = userRepo.findById(id);
        return optUser.map(userEntity -> mapper.map(userEntity, User.class)).orElseThrow(() -> new NotFoundException(404, "Not Found"));
    }

    @Override
    public User updateUser(Long id, UserEntity newUser) {
        UserEntity updateUserEntity = userRepo.getById(id);
        updateUserEntity.setEmail(newUser.getEmail());
        updateUserEntity.setUserName(newUser.getUserName());
        updateUserEntity.setFirstName(newUser.getFirstName());
        updateUserEntity.setPhone(newUser.getPhone());
        updateUserEntity.setLastName(newUser.getLastName());
        userRepo.save(updateUserEntity);
//        else {
//            throw new NotFoundException(404, "Not Found");
//        }
        return mapper.map(updateUserEntity, User.class);
    }

    @Override
    public void deleteUser(Long id) {
         userRepo.deleteById(id);
    }

}
