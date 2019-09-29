/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Dish;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


/**
 *
 * @author Lenovo
 */
public class DishesRepository {

    private EntityManager entityManager;
    private EntityManagerFactory managerFactory;
    private EntityTransaction transaction;

  public  DishesRepository(EntityManagerFactory entityManagerFactory) {
        this.managerFactory = entityManagerFactory;
        this.entityManager = managerFactory.createEntityManager();
    }

   public boolean addDish(Dish dish) {
        transaction = entityManager.getTransaction();
        if (!isExists(dish)) {
            try {
                transaction.begin();
                entityManager.persist(dish);
                transaction.commit();
                return true;
            } catch (Exception ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
        return false;
    }

   public List<Dish> selectSale() {
        List<Dish> dishesSaleList = (List<Dish>) entityManager.createQuery("select d from Dish d where d.sale=1").getResultList();
        return dishesSaleList;

    }

  public  List<Dish> selectByPrice(int min, int max) {
        List<Dish> dishes = entityManager.createQuery("SELECT d FROM Dish d WHERE d.price>" + min + " AND d.price<" + max).getResultList();
        return dishes;
    }

   public List<Dish> selectAll() {
        List<Dish> dishes = entityManager.createQuery("SELECT d FROM Dish AS d").getResultList();
        return dishes;
    }

    public List<Dish> selectByWeight(double tmp) {       
        List<Dish> dishes = (List<Dish>) entityManager.createQuery("SELECT d FROM Dish d where d.weight<" + tmp).getResultList();
        return dishes;
    }

    public boolean isExists(Dish dish) {
        boolean isStudentExists = false;
          List<Dish> newdish = findByName(dish.getName());
        if (!newdish.isEmpty()) {
            return isStudentExists = true;
        }
        return isStudentExists;
    }

    public List<Dish> findByName(String name) {
        List<Dish> dishes = (List<Dish>) entityManager.createQuery("SELECT d FROM Dish d where d.name=" +"'"+ name+"'").getResultList();
        return dishes;
    }

    

}
