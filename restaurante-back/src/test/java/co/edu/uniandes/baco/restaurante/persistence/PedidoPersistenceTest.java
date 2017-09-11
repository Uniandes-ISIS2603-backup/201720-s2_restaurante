/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;


import co.edu.uniandes.baco.restaurante.entities.PedidoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author s.heim
 */
public class PedidoPersistenceTest {
     /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private PedidoPersistence persistence;

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
    private List<PedidoEntity> data = new ArrayList<PedidoEntity>();
    
     /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PedidoEntity.class.getPackage())
                .addPackage(PedidoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
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
        em.createQuery("delete from PedidoEntity").executeUpdate();
    }


    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PedidoEntity entity = factory.manufacturePojo(PedidoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createPedidoEntityTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PedidoEntity newEntity = factory.manufacturePojo(PedidoEntity.class);
        PedidoEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        PedidoEntity entity = em.find(PedidoEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
    public void getPedidosTest() {
        List<PedidoEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PedidoEntity ent : list) {
            boolean found = false;
            for (PedidoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getPedidoTest() {
        PedidoEntity entity = data.get(0);
        PedidoEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    @Test
    public void updatePedidoTest() {
        PedidoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PedidoEntity newEntity = factory.manufacturePojo(PedidoEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        PedidoEntity resp = em.find(PedidoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
    
    @Test
    public void deletePedidoTest() {
        PedidoEntity entity = data.get(0);
        persistence.delete(entity.getId());
        PedidoEntity deleted = em.find(PedidoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    public PedidoPersistenceTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of create method, of class PedidoPersistence.
//     */
//    @Test
//    public void testCreate() {
//    }
//
//    /**
//     * Test of update method, of class PedidoPersistence.
//     */
//    @Test
//    public void testUpdate() {
//    }
//
//    /**
//     * Test of delete method, of class PedidoPersistence.
//     */
//    @Test
//    public void testDelete() {
//    }
//
//    /**
//     * Test of find method, of class PedidoPersistence.
//     */
//    @Test
//    public void testFind() {
//    }
//
//    /**
//     * Test of findAll method, of class PedidoPersistence.
//     */
//    @Test
//    public void testFindAll() {
//    }
    
}
