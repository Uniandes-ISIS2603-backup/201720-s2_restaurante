/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author af.bejarano
 */
public class BaseEntityTest {

    BaseEntity be = new BaseEntity() {
    };

    public BaseEntityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        be = new BaseEntity() {
        };
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class BaseEntity.
     */
    @Test
    public void testGetId() {
        be.setId(Long.getLong("0"));
        assertEquals(Long.getLong("0"), be.getId());
    }

    /**
     * Test of setId method, of class BaseEntity.
     */
    @Test
    public void testSetId() {
        be.setId(Long.getLong("0"));
        assertEquals(Long.getLong("0"), be.getId());
    }

    /**
     * Test of getName method, of class BaseEntity.
     */
    @Test
    public void testGetName() {
        be.setName("hola");
        assertEquals(be.getName(),"hola");
    }

    /**
     * Test of setName method, of class BaseEntity.
     */
    @Test
    public void testSetName() {
        be.setName("hola");
        assertEquals(be.getName(),"hola");
    }

    /**
     * Test of equals method, of class BaseEntity.
     */
    @Test
    public void testEquals() {
        BaseEntity be1 = new BaseEntity() {
    };
        be.setId(Long.MIN_VALUE);
        be1.setId(Long.MAX_VALUE);
        RestauranteEntity re= new RestauranteEntity();
        assertFalse(be.equals(null));
        assertTrue(be.equals(be));
        assertFalse(be.equals(re));
        assertFalse(be.equals(be1));
    }

    /**
     * Test of hashCode method, of class BaseEntity.
     */
    @Test
    public void testHashCode() {
        Long f=Long.valueOf(100);
        be.setId(f);
        assertTrue(be.hashCode()==f.hashCode());
    }

}
