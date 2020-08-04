package foodcalculator.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductMealId implements java.io.Serializable {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Meal meal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
