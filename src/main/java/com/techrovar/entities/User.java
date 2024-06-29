package com.techrovar.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_name",length = 255)
    private String username;
    @Column(name = "email",length = 255)
    private String email;
    @Column(name = "password",length = 255)
    private String password;

}
