package foodcalculator.model;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dish", schema = "foodcalculator")

public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany
//    @JoinColumn(name = "disch_id")
//    private Set<Product> products;


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
}