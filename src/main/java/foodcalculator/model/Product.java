package foodcalculator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "PRODUCT_ID",unique = true, nullable = false)
    private Long id;

    private String name;

    private double kcal;

    private double protein;

    private double fat;

    private double carbohydrates;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product")
    private Set<ProductMeal> productMeals = new HashSet<ProductMeal>(0);

    public Product() {
    }

    public Product(String name, double kcal, double protein, double fat, double carbohydrates) {
        this.name = name;
        this.kcal = kcal;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public Product(String name, double kcal, double protein, double fat, double carbohydrates, Set<ProductMeal> productMeals) {
        this.name = name;
        this.kcal = kcal;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.productMeals = productMeals;
    }
}
