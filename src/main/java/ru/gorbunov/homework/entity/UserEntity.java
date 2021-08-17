package ru.gorbunov.homework.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
public class UserEntity   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id = null;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email ;

    @Column(name = "phone")
    private String phone ;

}

