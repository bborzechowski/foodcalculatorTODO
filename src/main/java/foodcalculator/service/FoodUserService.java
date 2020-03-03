package foodcalculator.service;

import foodcalculator.exception.ResourceNotFoundException;
import foodcalculator.model.FoodUser;
import foodcalculator.model.Product;
import foodcalculator.repository.FoodUserRepository;
import org.springframework.stereotype.Service;

import java.awt.image.RasterFormatException;

@Service
public class FoodUserService {

    private FoodUserRepository foodUserRepository;

    public FoodUserService(FoodUserRepository foodUserRepository) {
        this.foodUserRepository = foodUserRepository;
    }

    public FoodUser getFooduserById(long id){
        return foodUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product by id " + id + " not found"));
    }
    public FoodUser updateFooduser(long id, FoodUser incomeFooduser){
        return foodUserRepository.findById(id).map(foodUser ->{

            foodUser.setId(incomeFooduser.getId());
            foodUser.setFirstname(incomeFooduser.getFirstname());
            foodUser.setSurname(incomeFooduser.getSurname());
            foodUser.setAge(incomeFooduser.getAge());
            foodUser.setWeight(incomeFooduser.getWeight());
            foodUser.setHeight(incomeFooduser.getHeight());
            foodUser.setSex(incomeFooduser.isSex());
            return foodUserRepository.save(foodUser);
        }).orElseThrow(() -> new RasterFormatException("fooduser by id: "+ id + " not found"));
    }
}
