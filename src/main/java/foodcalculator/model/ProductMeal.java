package foodcalculator.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "product_meal")
@AssociationOverrides({
        @AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "PRODUCT_ID")),
        @AssociationOverride(name = "pk.meal", joinColumns = @JoinColumn(name = "MEAL_ID"))
})
public class ProductMeal  implements java.io.Serializable{

    @EmbeddedId
    private ProductMealId pk = new ProductMealId();

    private int quantity;


    @Transient
    public Product getProduct() {
        return getPk().getProduct();
    }

    public void setProduct(Product product) {
        getPk().setProduct(product);
    }

    @Transient
    public Meal getMeal() {
        return getPk().getMeal();
    }

    public void setMeal(Meal meal) {
        getPk().setMeal(meal);
    }


}
