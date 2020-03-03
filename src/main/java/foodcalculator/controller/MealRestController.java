package foodcalculator.controller;

import foodcalculator.model.Meal;
import foodcalculator.model.Product;
import foodcalculator.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealRestController {

    private MealService mealService;

    public MealRestController(MealService mealService) {
        this.mealService = mealService;
    }
    @GetMapping("/api/meals/")
    public List<Meal> geatMeals(){
        return mealService.getMeal();
    }

    @PostMapping("/api/meals/")
    public Meal createMeal(@ModelAttribute Meal meal){
        return mealService.addMeal(meal);
    }

    @PutMapping("/api/meals/{id}")
    public Meal updateMeal(@PathVariable long id, @RequestBody Meal meal){
        return mealService.updateMeal(id, meal);
    }

    @DeleteMapping("api/meal/{id}")
    public ResponseEntity<?> deleteMeal(@PathVariable long id){
        return mealService.deleteMeal(id);
    }
}
