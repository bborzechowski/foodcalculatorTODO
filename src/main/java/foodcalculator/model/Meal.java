package foodcalculator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "MEAL_ID", unique = true, nullable = false)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.meal")
    private Set<ProductMeal> productMeals = new HashSet<ProductMeal>(0);


}


