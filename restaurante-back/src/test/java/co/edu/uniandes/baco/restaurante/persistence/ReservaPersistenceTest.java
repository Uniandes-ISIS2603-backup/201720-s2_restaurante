/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.ReservaEntity;
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

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jf.sanchezg
 */
@RunWith(Arquillian.class)
public class ReservaPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase ReservaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ReservaPersistence persistence;

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

    private List<ReservaEntity> data = new ArrayList<ReservaEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Reserva, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReservaEntity.class.getPackage())
                .addPackage(ReservaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public ReservaPersistenceTest() {
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
        em.createQuery("delete from ReservaEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ReservaPersistence.
     */
    @Test
    public void createReservaTest() {
    PodamFactory factory = new PodamFactoryImpl();
    ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);
    ReservaEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    ReservaEntity entity = em.find(ReservaEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getName(), entity.getName());
}

    /**
     * Test of update method, of class ReservaPersistence.
     */
    @Test
    public void updateReservaTest() {
    ReservaEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    ReservaEntity resp = em.find(ReservaEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getName(), resp.getName());
}

    /**
     * Test of delete method, of class ReservaPersistence.
     */
    @Test
    public void deleteReservaTest() {
    ReservaEntity entity = data.get(0);
    persistence.delete(entity.getId());
    ReservaEntity deleted = em.find(ReservaEntity.class, entity.getId());
    Assert.assertNull(deleted);
}

    /**
     * Test of find method, of class ReservaPersistence.
     */
    @Test
    public void getXYZTest() {
    ReservaEntity entity = data.get(0);
    ReservaEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
}

    /**
     * Test of findAll method, of class ReservaPersistence.
     */
    @Test
    public void getReservasTest() {
    List<ReservaEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (ReservaEntity ent : list) {
        boolean found = false;
        for (ReservaEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}
    
}

