package foodcalculator.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class FoodUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String surname;

    private int age;

    private double weight;

    private double height;

    private boolean sex;  //true = male, false = female

    private double activity;
}
