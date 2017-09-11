/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author af.bejarano
 */
@RunWith(Arquillian.class)
public class DomicilioPersistenceTest {
    
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DomicilioEntity.class.getPackage())
                .addPackage(DomicilioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private DomicilioPersistence persistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

     /**
     *
     */
    private List<DomicilioEntity> data = new ArrayList<DomicilioEntity>();
    
    public DomicilioPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData() {
        em.createQuery("delete from DomicilioEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DomicilioEntity entity = factory.manufacturePojo(DomicilioEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class DomicilioPersistence.
     */
    @Test
    public void createDomicilioEntityTest() {
       PodamFactory factory = new PodamFactoryImpl();
       DomicilioEntity newEntity = factory.manufacturePojo(DomicilioEntity.class);
       DomicilioEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        DomicilioEntity entity = em.find(DomicilioEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
public void getDomiciliosTest() {
    List<DomicilioEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (DomicilioEntity ent : list) {
        boolean found = false;
        for (DomicilioEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}

@Test
public void getDomicilioTest() {
    DomicilioEntity entity = data.get(0);
    DomicilioEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
}

    @Test
public void updateDomicilioTest() {
    DomicilioEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    DomicilioEntity newEntity = factory.manufacturePojo(DomicilioEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    DomicilioEntity resp = em.find(DomicilioEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getName(), resp.getName());
}

@Test
public void deleteDomicilioTest() {
    DomicilioEntity entity = data.get(0);
    persistence.delete(entity.getId());
    DomicilioEntity deleted = em.find(DomicilioEntity.class, entity.getId());
    Assert.assertNull(deleted);
}
    
}
