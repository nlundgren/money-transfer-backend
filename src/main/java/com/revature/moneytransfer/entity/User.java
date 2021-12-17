package com.revature.moneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private double balance;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles",foreignKey = @ForeignKey(name="user_id"))
    private List<String> authorities;
}

