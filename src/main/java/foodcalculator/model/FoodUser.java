package foodcalculator.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class FoodUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String surname;

    private int age;

    private double weight;

    private double height;

    private boolean sex;  //true = male, false = female

    private double activity;

    @OneToOne(mappedBy = "foodUser")
    private UserNutrients userNutrients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getActivity() {
        return activity;
    }

    public void setActivity(double activity) {
        this.activity = activity;
    }

    public UserNutrients getUserNutrients() {
        return userNutrients;
    }

    public void setUserNutrients(UserNutrients userNutrients) {
        this.userNutrients = userNutrients;
    }
}
