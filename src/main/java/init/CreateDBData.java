/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Dish;
import repositories.DishesRepository;
import services.Menu;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class CreateDBData {

    public static final Logger LOGGER = Logger.getLogger(CreateDBData.class.getName());

    private DishesRepository repository;
    private ObjectMapper mapper = new ObjectMapper();
    private String path;

    public CreateDBData(DishesRepository repository, String path) {
        this.repository = repository;
        this.path = path;
    }

    public static List<Dish> parsFromJson(ObjectMapper mapper, String path) {
        File file = new File(path);
        List<Dish> dishes = new ArrayList<>();
        try {
           List<Object>list = mapper.readValue(file,List.class);
            dishes = mapper.convertValue(list, new TypeReference<List<Dish>>(){});
            
        } catch (IOException ex) {
            Logger.getLogger(CreateDBData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dishes;
    }

    public static void parsToJson(ObjectMapper mapper,List<Dish> dish, String path) {
        File file = new File(path);
        try {
            mapper.writeValue(file, dish);
        } catch (IOException ex) {
            Logger.getLogger(CreateDBData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addDataToDB() {
        List<Dish> list = parsFromJson(mapper, path);
        for (Dish d : list) {
            repository.addDish(d);
        }
    }
}
