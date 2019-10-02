/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo
 */
public class Init {
     private final EntityManagerFactory entittyManagerFactoty = Persistence.createEntityManagerFactory("JpaAppPostgresql");

    public Init() {
    }

    public EntityManagerFactory getEntittyManagerFactoty() {
        return entittyManagerFactoty;
    }
    
}
