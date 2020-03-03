package foodcalculator.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
@Data
@Embeddable
public class ProductMealId implements java.io.Serializable {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Meal meal;
}
