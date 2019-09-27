/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.mycompany.menuapp.Init;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Lenovo
 */
public class Menu {

    private List<Dish> dishes;
    private DishesRepository repository;
    private Init init;
    private EntityManagerFactory entityManagerFactory;

    public Menu() {
        this.init = new Init();
        this.entityManagerFactory = init.getEntittyManagerFactoty();
        this.repository = new DishesRepository(entityManagerFactory);
    }

    public void addDish(String name, double weight, double price, boolean isSale) {
        Dish dish = new Dish(name, weight, price, isSale);
        repository.addDish(dish);
    }

    public List<Dish> findBySale() {
        List<Dish> saleDish = repository.selectSale();
        return saleDish;
    }

    public List<Dish> selectByPrice(int min, int max) {
        List<Dish> listByPrice = repository.selectByPrice(min, max);
        return listByPrice;
    }

    public List<Dish> getAll() {
        List<Dish> allDishes = repository.selectAll();
        return allDishes;

    }

    public List<Dish> getByWeight(double max) {
        double tmp = 0.2;
        List<Dish> dishes = new ArrayList<>();
        while (tmp <= max) {
            Dish dish = repository.selectByWeight(max - tmp);
            if (dish != null) {
                tmp += dish.getWeight();
                dishes.add(dish);
            }
        }
        return dishes;
    }

    
}
