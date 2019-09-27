/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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

   public void addDish(Dish dish) {
        transaction = entityManager.getTransaction();
        if (!isExists(dish)) {
            try {
                transaction.begin();
                entityManager.persist(dish);
                transaction.commit();
            } catch (Exception ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }

   public List<Dish> selectSale() {
        List<Dish> dishesSaleList = (List<Dish>) entityManager.createQuery("select d from Dish d where d.sale=true").getResultList();
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

    public Dish selectByWeight(double tmp) {       
        Dish dish = (Dish) entityManager.createQuery("SELECT d FROM Dish where d.weight<=" + tmp).getSingleResult();
        return dish;
    }

    public boolean isExists(Dish dish) {
        boolean isStudentExists = false;
        Dish newdish = findByName(dish.getName());
        if (newdish!=null) {
            return isStudentExists = true;
        }
        return isStudentExists;
    }

    public Dish findByName(String name) {
        Dish dishes = (Dish) entityManager.createQuery("SELECT d FROM Dish where d.name<=" + name).getSingleResult();
        return dishes;
    }

    

}
