/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;


import co.edu.uniandes.baco.restaurante.entities.MesaEntity;
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
public class MesaPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase MesaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private MesaPersistence persistence;

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

    private List<MesaEntity> data = new ArrayList<MesaEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Mesa, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MesaEntity.class.getPackage())
                .addPackage(MesaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public MesaPersistenceTest() {
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
        em.createQuery("delete from MesaEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            MesaEntity entity = factory.manufacturePojo(MesaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class MesaPersistence.
     */
    @Test
    public void createMesaTest() {
    PodamFactory factory = new PodamFactoryImpl();
    MesaEntity newEntity = factory.manufacturePojo(MesaEntity.class);
    MesaEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    MesaEntity entity = em.find(MesaEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getName(), entity.getName());
}

    /**
     * Test of update method, of class MesaPersistence.
     */
    @Test
    public void updateMesaTest() {
    MesaEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    MesaEntity newEntity = factory.manufacturePojo(MesaEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    MesaEntity resp = em.find(MesaEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getName(), resp.getName());
}

    /**
     * Test of delete method, of class MesaPersistence.
     */
    @Test
    public void deleteMesaTest() {
    MesaEntity entity = data.get(0);
    persistence.delete(entity.getId());
    MesaEntity deleted = em.find(MesaEntity.class, entity.getId());
    Assert.assertNull(deleted);
}

    /**
     * Test of find method, of class MesaPersistence.
     */
    @Test
    public void getMesaTest() {
    MesaEntity entity = data.get(0);
    MesaEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
}

    /**
     * Test of findAll method, of class MesaPersistence.
     */
    @Test
    public void getMesasTest() {
    List<MesaEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (MesaEntity ent : list) {
        boolean found = false;
        for (MesaEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}
    
}
