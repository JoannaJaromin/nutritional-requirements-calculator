package joanna.jaromin.requirements.calculator.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "users_details")
@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sex")
    private String sex;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
