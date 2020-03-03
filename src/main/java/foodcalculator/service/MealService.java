package foodcalculator.service;

import foodcalculator.exception.ResourceNotFoundException;
import foodcalculator.model.Meal;
import foodcalculator.model.Product;
import foodcalculator.repository.MealRepository;
import foodcalculator.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MealService {

    private MealRepository mealRepository;
    private ProductRepository productRepository;

    public MealService(MealRepository mealRepository, ProductRepository productRepository) {
        this.mealRepository = mealRepository;
        this.productRepository = productRepository;
    }

    public List<Meal> getMeal(){
        return mealRepository.findAll();
//        List<Meal> meals = new ArrayList<>(0);
//        mealRepository.findAll().forEach(m -> );
    }

    public Meal addMeal(Meal meal){
        return mealRepository.save(meal);
    }

    public  Meal updateMeal( long id, Meal meal){
        return mealRepository.findById(id).map(m -> {
            m.setName(meal.getName());
            return mealRepository.save(m);
        }).orElseThrow(() -> new ResourceNotFoundException("meal type id: " +id + " not found"));
    }

    public ResponseEntity<?> deleteMeal(long id){
        return mealRepository.findById(id).map(m -> {
            mealRepository.deleteById(id);
            return new ResponseEntity<>("meal by id " + id+ " was deletes!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("meal type id: " +id + " not found"));
    }
}
