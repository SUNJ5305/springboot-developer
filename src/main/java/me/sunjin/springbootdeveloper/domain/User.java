package me.sunjin.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@NoArgsConstructor
@Getter
@Entity
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceGeneratorName")
    @SequenceGenerator(
            name="SequenceGeneratorName",
            sequenceName = "userseq", allocationSize = 1
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "userid", nullable = false, unique = true)
    private String userid;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Builder
    public User(String userid, String password, String auth) {
        this.userid = userid;
        this.password = password;
        role = "ROLE_USER";
    }
}
