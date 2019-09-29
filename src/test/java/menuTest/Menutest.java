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
import services.Menu;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lenovo
 */
public class Menutest {
     private static Menu menu;
    private static DishesRepository repository;
    private static String path = "src\\main\\resources\\menu.json";
    
          
    

    @BeforeClass
    public static void init() {
        Init init = new Init();
        EntityManagerFactory managerFactory = init.getEntittyManagerFactoty();
       menu = new Menu();   
       repository = new DishesRepository(managerFactory);
       CreateDBData createDBData = new CreateDBData(repository,path);
       createDBData.addDataToDB();   
       
       
    }

    @Test
    public void addStudenttest() {
        menu.addDish("FishAndChips", 0.4, 56.00, true);   
        assertNotNull(repository.findByName("FishAndChips"));

    }

    @Test
    public void selectByWeight() {
        List<Dish> dishes = menu.getByWeight(1);
        double sumWeight = 0;
        for(Dish d: dishes){
            sumWeight+=d.getWeight();
                    }
        assertTrue(sumWeight<=1);
    }

    
    
 
   
}
