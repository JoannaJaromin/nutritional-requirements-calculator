package joanna.jaromin.requirements.calculator.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "measurements")
@Data
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "measurement_date")
    private LocalDate measurementDate;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "hips")
    private Integer hips;

    @Column(name = "belly")
    private Integer belly;

    @Column(name = "waist")
    private Integer waist;

    @Column(name = "pal")
    private Double pal;

    @Column(name = "pregnant")
    private Boolean pregnant;

    @Column(name = "breastfeeding")
    private Boolean breastfeeding;
}
