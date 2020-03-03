package foodcalculator.controller;

import foodcalculator.model.Activity;
import foodcalculator.model.FoodUser;
import foodcalculator.model.Product;
import foodcalculator.repository.FoodUserRepository;
import foodcalculator.service.FoodUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodUserController {

    private FoodUserRepository foodUserRepository;
    private FoodUserService foodUserService;
    private Activity activity;

    public FoodUserController(FoodUserRepository foodUserRepository, FoodUserService foodUserService) {
        this.foodUserRepository = foodUserRepository;
        this.foodUserService = foodUserService;
    }
//    @GetMapping("/fooduser")
//    public String home(){
//        return "tableUser";
//    }

    @PostMapping("/fooduser/add")
    public String addFoodUser(@ModelAttribute FoodUser newFoodUser){

        FoodUser foodUser = new FoodUser();
        foodUser.setFirstname(newFoodUser.getFirstname());
        foodUser.setSurname(newFoodUser.getSurname());
        foodUser.setAge(newFoodUser.getAge());
        foodUser.setHeight(newFoodUser.getHeight());
        foodUser.setWeight(newFoodUser.getWeight());
        foodUser.setSex(newFoodUser.isSex());
        foodUser.setActivity(newFoodUser.getActivity());
        foodUserRepository.save(foodUser);
        return "redirect:/foodusers";
    }

    @GetMapping("/foodusers")
    public String getFoodUsers(Model model){
        model.addAttribute("foodusers", foodUserRepository.findAll());
        return "fooduser-index";
    }


    @GetMapping("/foodusers/delate")
    public String deleteFoodUser(@RequestParam long id){
        foodUserRepository.deleteById(id);
        return "redirect:/foodusers";
    }

    @GetMapping("/foodusers/update")
    public String updateFooduser(@RequestParam long id, Model model){

        FoodUser foodUser = foodUserService.getFooduserById(id);

        if(foodUser == null){
            return "Cannot find user";
        }
        model.addAttribute("fooduser", foodUser);
        return "fooduser-update";
    }

    @PostMapping("/foodusers/update/confirm")
    public String updateFooduserConfirm(@ModelAttribute FoodUser incomeFooduser){

        FoodUser foodUser = new FoodUser();
        foodUser.setId(incomeFooduser.getId());
        foodUser.setFirstname(incomeFooduser.getFirstname());
        foodUser.setSurname(incomeFooduser.getSurname());
        foodUser.setAge(incomeFooduser.getAge());
        foodUser.setWeight(incomeFooduser.getWeight());
        foodUser.setHeight(incomeFooduser.getHeight());
        foodUser.setSex(incomeFooduser.isSex());
        foodUser.setActivity(incomeFooduser.getActivity());
        foodUserRepository.save(incomeFooduser);
        String operationResult = foodUserService.updateFooduser(incomeFooduser.getId(),foodUser).getSurname();
        return "redirect:/foodusers??message=updated fooduser: " + operationResult;
    }


}
