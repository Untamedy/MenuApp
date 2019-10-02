/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import init.Init;
import entities.Dish;
import repositories.DishesRepository;
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

    public boolean addDish(String name, double weight, double price, boolean isSale) {
        Dish dish = new Dish(name, weight, price, isSale);
     return  repository.addDish(dish);
        
    }

    public List<Dish> findBySale() {
        List<Dish> saleDish = repository.selectSale();
        return saleDish;
    }

    public List<Dish> selectByPrice(double min, double max) {
        List<Dish> listByPrice = repository.selectByPrice(min, max);
        return listByPrice;
    }

    public List<Dish> getAll() {
        List<Dish> allDishes = repository.selectAll();
        return allDishes;

    }

    public List<Dish> getByWeight(double max) {
        double tmp = 0;        
        int index = 0;
        List<Dish> dishes = new ArrayList<>();        
        while (tmp <= max) {
            List<Dish> dish = repository.selectByWeight(max - tmp);
            if (!dish.isEmpty()) {
                if(!dishes.contains(dish.get(index))){
                   tmp += dish.get(index).getWeight();
                dishes.add(dish.get(index));
                index++; 
                }                
            }
            else{
                return dishes;
            }
        }
        return dishes;
    }

    public double getMaxPrice(String param) {
       return repository.getMaxPrice(param);
    }

    
}
