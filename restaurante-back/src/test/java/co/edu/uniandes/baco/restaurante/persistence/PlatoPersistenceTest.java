package co.edu.uniandes.baco.restaurante.persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;
import co.edu.uniandes.baco.restaurante.persistence.PlatoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author df.penap
 */
@RunWith(Arquillian.class)
public class PlatoPersistenceTest {
   /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private PlatoPersistence persistence;

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
    private List<PlatoEntity> data = new ArrayList<PlatoEntity>();
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PlatoEntity.class.getPackage())
                .addPackage(PlatoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    public PlatoPersistenceTest() {
        
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
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() throws Exception{ 
        fail("testSomeMethod");
    }
    @Test
    public void testFind() throws Exception{
        fail("testFind");
    }
    @Test
    public void testFindByName() throws Exception{
        fail("testFindByName");
    }
    @Test
    public void testFindAll() throws Exception{
        fail("testFindAll");
    }
    @Test
    public void testCreate() throws Exception{
        fail("testCreate");
    }
    @Test
    public void testUpdate() throws Exception{
        fail("testUpdate");
    }
    @Test
    public void testDelete() throws Exception {
         fail("testDelete");
    }
    @Test
    public void clearData() {
        em.createQuery("delete from PlatoEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PlatoEntity entity = factory.manufacturePojo(PlatoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
 @Test
public void createPlatoEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    PlatoEntity newEntity = factory.manufacturePojo(PlatoEntity.class);
    PlatoEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    PlatoEntity entity = em.find(PlatoEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getName(), entity.getName());
}
@Test
public void getPlatoTest() {
    List<PlatoEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (PlatoEntity ent : list) {
        boolean found = false;
        for (PlatoEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}
@Test
public void gePlatoTest() {
    PlatoEntity entity = data.get(0);
    PlatoEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
}

@Test
public void updatePlatoTest() {
    PlatoEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    PlatoEntity newEntity = factory.manufacturePojo(PlatoEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    PlatoEntity resp = em.find(PlatoEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getName(), resp.getName());
}
@Test
public void deletePlatoTest() {
    PlatoEntity entity = data.get(0);
    persistence.delete(entity.getId());
    PlatoEntity deleted = em.find(PlatoEntity.class, entity.getId());
    Assert.assertNull(deleted);
}
}
