package foodcalculator.model;

import javax.persistence.*;

@Entity
@Table(name = "usernutrients")
public class UserNutrients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private FoodUser foodUser;

    private double kcal;

    private double protein;

    private double fat;

    private double carbohydrates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FoodUser getFoodUser() {
        return foodUser;
    }

    public void setFoodUser(FoodUser foodUser) {
        this.foodUser = foodUser;
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
}
