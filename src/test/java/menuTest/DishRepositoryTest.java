/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuTest;

import init.CreateDBData;
import init.Init;
import entities.Dish;
import repositories.DishesRepository;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lenovo
 */
public class DishRepositoryTest extends Assert{    
    private static DishesRepository repository;
    private static String path = "src\\main\\resources\\menu.json";
    
          
    

    @BeforeClass
    public static void init() {
        Init init = new Init();
        EntityManagerFactory managerFactory = init.getEntittyManagerFactoty();
       repository = new DishesRepository(managerFactory);
       CreateDBData createDBData = new CreateDBData(repository,path);
       createDBData.addDataToDB();   
       
       
    }

    @Test
    public void addDishTest() {
        Dish dish = new Dish("Fish", 0.4, 44.00, true);     
        repository.addDish(dish);
        assertTrue(repository.isExists(dish));

    }

    @Test
    public void selectByWeightTest() {
        List<Dish> dishes = repository.selectByWeight(0.3);
        assertFalse(dishes.get(0).getWeight()==0.3);
    }

    @Test
    public void findByNameTest() {
       List<Dish> dish =repository.findByName("Cake");
        assertFalse(dish.isEmpty());
    }

    @Test
    public void findIsSaleTest() {
        List<Dish> dishes = repository.selectSale();     
        assertTrue(dishes.get(0).isWithSale());
    }
    
    @Test
    public void findByPriceTest(){
        List<Dish> dishes = repository.selectByPrice(10, 50);     
        for(Dish d:dishes){
            assertTrue(d.getPrice()>10&&d.getPrice()<50);
        }
    }
    
    @Test
    public void getAllTest(){
       List<Dish> dishes = repository.selectAll();
       assertTrue(dishes.size()>=10);
    }

   
    
}
