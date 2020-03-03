package foodcalculator.controller;

import foodcalculator.model.Meal;
import foodcalculator.repository.MealRepository;
import foodcalculator.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MealController {

    private MealService mealService;
    private MealRepository mealRepository;

    public MealController(MealService mealService, MealRepository mealRepository) {
        this.mealService = mealService;
        this.mealRepository = mealRepository;
    }

    @GetMapping("/me")
    public String mealHome(){
        return "mealpage";
    }

    @PostMapping("/me/add")
    public String addMeal(@ModelAttribute Meal meal){
        Meal newMeal = new Meal();
        newMeal.setName(meal.getName());
         mealRepository.save(newMeal);
        return "/meals";
    }

    @GetMapping("/meals")
    public String getMeals(Model model){
        model.addAttribute("meals", mealService.getMeal());
        return "allmeals";
    }

    @GetMapping("/meals/delete")
    public String deleteMeal(@RequestParam long id){
        mealService.deleteMeal(id);
        return "redirect:/meals";
    }

}
