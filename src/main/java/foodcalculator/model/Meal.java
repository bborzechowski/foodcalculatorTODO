package foodcalculator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductMeal> getProductMeals() {
        return productMeals;
    }

    public void setProductMeals(Set<ProductMeal> productMeals) {
        this.productMeals = productMeals;
    }
}


