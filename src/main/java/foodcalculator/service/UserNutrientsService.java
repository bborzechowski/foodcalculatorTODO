package foodcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class UserNutrientsService {

    public Double calculateUserCalories(double weight, double height, int age,double activity, boolean sex){
        double result;
        if(sex){
            result = (66.4 + 13.7 * weight + 6.0 * height - 6.8 * age) *  activity;
        }
        else {
            result = 655 + 9.6 * weight + 1.8 * height - 4.7 * age;
        }
        return round(result);
    }

    public Double calculateUserProtein(double calories){
        double result = (calories * 0.15)/4;
        return round(result);
    }

    public Double calculateUserFat(double calories){
        double result = (calories * 0.3)/9;
        return round(result);
    }

    public Double calculateUserCarbohydrates(double calories){
        double result = (calories * 0.55)/4;
        return round(result);
    }
    public Double round(double number){
        number = Math.round(number *100);
        return number/100;
    }
}
