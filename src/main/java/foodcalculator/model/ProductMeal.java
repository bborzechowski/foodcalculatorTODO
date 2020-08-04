package foodcalculator.model;

import lombok.Data;

import javax.persistence.*;

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

    public ProductMealId getPk() {
        return pk;
    }

    public void setPk(ProductMealId pk) {
        this.pk = pk;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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
