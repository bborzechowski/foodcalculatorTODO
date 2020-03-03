package foodcalculator.repository;

import foodcalculator.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   // @Query(value = "select p from Product p where p.id = ?1")
    @Query(value = "SELECT * FROM product WHERE id like (?1%)", nativeQuery = true)
    Product findProductByZZ(long id);
}
