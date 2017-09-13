/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.RestauranteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


/**
 *
 * @author jd.correa
 */
@RunWith(Arquillian.class)
public class RestaurantePersistenceTest {
    @Inject
    private RestaurantePersistence persistence;
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserTransaction utx;
    private List<RestauranteEntity> data = new ArrayList<RestauranteEntity>();
    public RestaurantePersistenceTest() {
    }
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RestauranteEntity.class.getPackage())
                .addPackage(RestaurantePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    private void clearData() {
        em.createQuery("delete from RestauranteEntity").executeUpdate();
    }
    


    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            RestauranteEntity entity = factory.manufacturePojo(RestauranteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    @Test
    public void createRestauranteEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    RestauranteEntity newEntity = factory.manufacturePojo(RestauranteEntity.class);
    RestauranteEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    RestauranteEntity entity = em.find(RestauranteEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getName(), entity.getName());
}
    @Test
public void getRestaurantesTest() {
    List<RestauranteEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (RestauranteEntity ent : list) {
        boolean found = false;
        for (RestauranteEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}
@Test
public void getRestauranteTest() {
    RestauranteEntity entity = data.get(0);
    RestauranteEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getName(), newEntity.getName());
}
@Test
public void updateRestauranteTest() {
    RestauranteEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    RestauranteEntity newEntity = factory.manufacturePojo(RestauranteEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    RestauranteEntity resp = em.find(RestauranteEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getName(), resp.getName());
}
@Test
public void deleteRestauranteTest() {
    RestauranteEntity entity = data.get(0);
    persistence.delete(entity.getId());
    RestauranteEntity deleted = em.find(RestauranteEntity.class, entity.getId());
    Assert.assertNull(deleted);
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
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }
}
