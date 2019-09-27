/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuTest;

import com.mycompany.menuapp.CreateDBData;
import com.mycompany.menuapp.Init;
import entities.Dish;
import entities.DishesRepository;
import entities.Menu;
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
    private static Menu menu;
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
    public void addStudenttest() {
        Dish dish = new Dish("Fish", 0.4, 44.00, true);     
        repository.addDish(dish);
        assertTrue(repository.isExists(dish));

    }

    @Test
    public void selectByWeight() {
        Dish dishes = repository.selectByWeight(0.5);
        assertTrue(dishes.getWeight()<=0.5);
    }

    @Test
    public void findByNameTest() {
       Dish dish =repository.findByName("Cake");
        assertNotNull(dish);
    }

    @Test
    public void findIsSaleTest() {
        List<Dish> dishes = repository.selectSale();     
        assertTrue(dishes.get(0).isWithSale());
    }
    
    @Test
    public void findByPrice(){
        List<Dish> dishes = repository.selectByPrice(10, 50);     
        for(Dish d:dishes){
            assertTrue(d.getPrice()>10&&d.getPrice()<50);
        }
    }

   
    
}
