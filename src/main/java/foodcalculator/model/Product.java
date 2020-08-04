package foodcalculator.model;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Set<ProductMeal> getProductMeals() {
        return productMeals;
    }

    public void setProductMeals(Set<ProductMeal> productMeals) {
        this.productMeals = productMeals;
    }
}
