package foodcalculator.repository;

import foodcalculator.model.FoodUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodUserRepository extends JpaRepository<FoodUser, Long> {
}
