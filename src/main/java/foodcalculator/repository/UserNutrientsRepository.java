package foodcalculator.repository;

import foodcalculator.model.UserNutrients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNutrientsRepository extends JpaRepository<UserNutrients, Long> {
}
