package joanna.jaromin.requirements.calculator.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "authority")
    private String authority;

    @OneToOne(mappedBy = "user")
    private UserData userData;

    @OneToMany(mappedBy = "user")
    private Measurement measurement;
}
