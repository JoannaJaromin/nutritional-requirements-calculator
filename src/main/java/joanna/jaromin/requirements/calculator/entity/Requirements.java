package joanna.jaromin.requirements.calculator.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requirements")
@Data
public class Requirements {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "protein")
    private Double protein;

    @Column(name = "fiber")
    private Double fiber;

    @Column(name = "calcium")
    private Double calcium;

    @Column(name = "phosphorus")
    private Double phosphorus;

    @Column(name = "magnesium")
    private Double magnesium;

    @Column(name = "iron")
    private Double iron;

    @Column(name = "potassium")
    private Double potassium;

    @Column(name = "sodium")
    private Double sodium;

    @Column(name = "zinc")
    private Double zinc;

    @Column(name = "copper")
    private Double copper;

    @Column(name = "iodine")
    private Double iodine;

    @Column(name = "selenium")
    private Double selenium;

    @Column(name = "manganese")
    private Double manganese;

    @Column(name = "vit_c")
    private Double vitC;

    @Column(name = "vit_b1")
    private Double vitB1;

    @Column(name = "vit_b2")
    private Double vitB2;

    @Column(name = "vit_b3")
    private Double vitB3;

    @Column(name = "vit_b6")
    private Double vitB6;

    @Column(name = "foliate")
    private Double foliate;

    @Column(name = "vit_b12")
    private Double vitB12;

    @Column(name = "vit_a")
    private Double vitA;

    @Column(name = "vit_e")
    private Double vitE;

    @Column(name = "vit_d")
    private Double vitD;

    @Column(name = "vit_k")
    private Double vitK;

}
