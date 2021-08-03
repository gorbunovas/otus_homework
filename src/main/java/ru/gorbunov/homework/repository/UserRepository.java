package ru.gorbunov.homework.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gorbunov.homework.entity.UserEntity;


import javax.transaction.Transactional;

@Repository
@Transactional(Transactional.TxType.MANDATORY)
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
