/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.util.ArrayList;
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
public class SucursalEntityTest {
    
    SucursalEntity re= new SucursalEntity();
    
    public SucursalEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        re= new SucursalEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getImage method, of class SucursalEntity.
     */
    @Test
    public void testGetImage() {
        re.setImage("hola");
        assertEquals(re.getImage(), "hola");
    }

    /**
     * Test of setImage method, of class SucursalEntity.
     */
    @Test
    public void testSetImage() {
        re.setImage("hola");
        assertEquals(re.getImage(), "hola");
    }

    /**
     * Test of getPlatos method, of class SucursalEntity.
     */
    @Test
    public void testGetPlatos() {
        ArrayList<PlatoEntity> pl= new ArrayList<>();
        re.setPlatos(pl);
        assertEquals(re.getPlatos(), pl);
    }

    /**
     * Test of setPlatos method, of class SucursalEntity.
     */
    @Test
    public void testSetPlatos() {
        ArrayList<PlatoEntity> pl= new ArrayList<>();
        re.setPlatos(pl);
        assertEquals(re.getPlatos(), pl);
    }

    /**
     * Test of getMesas method, of class SucursalEntity.
     */
    @Test
    public void testGetMesas() {
        ArrayList<MesaEntity> pl= new ArrayList<>();
        re.setMesas(pl);
        assertEquals(re.getMesas(), pl);
    }

    /**
     * Test of setMesas method, of class SucursalEntity.
     */
    @Test
    public void testSetMesas() {
        ArrayList<MesaEntity> pl= new ArrayList<>();
        re.setMesas(pl);
        assertEquals(re.getMesas(), pl);
    }

    /**
     * Test of getRestaurante method, of class SucursalEntity.
     */
    @Test
    public void testGetRestaurante() {
        RestauranteEntity re1= new RestauranteEntity();
        re.setRestaurante(re1);
        assertEquals(re.getRestaurante(), re1);
    }

    /**
     * Test of setRestaurante method, of class SucursalEntity.
     */
    @Test
    public void testSetRestaurante() {
        RestauranteEntity re1= new RestauranteEntity();
        re.setRestaurante(re1);
        assertEquals(re.getRestaurante(), re1);
    }

    /**
     * Test of getCalificacion method, of class SucursalEntity.
     */
    @Test
    public void testGetCalificacion() {
        re.setCalificacion("hola");
        assertEquals(re.getCalificacion(), "hola");
    }

    /**
     * Test of setCalificacion method, of class SucursalEntity.
     */
    @Test
    public void testSetCalificacion() {
        re.setCalificacion("hola");
        assertEquals(re.getCalificacion(), "hola");
    }

    /**
     * Test of isDosPisos method, of class SucursalEntity.
     */
    @Test
    public void testIsDosPisos() {
        re.setDosPisos(true);
        assertTrue(re.isDosPisos());
    }

    /**
     * Test of setDosPisos method, of class SucursalEntity.
     */
    @Test
    public void testSetDosPisos() {
        re.setDosPisos(true);
        assertTrue(re.isDosPisos());
    }

    /**
     * Test of getDireccion method, of class SucursalEntity.
     */
    @Test
    public void testGetDireccion() {
        re.setDireccion("hola");
        assertEquals(re.getDireccion(), "hola");
    }

    /**
     * Test of setDireccion method, of class SucursalEntity.
     */
    @Test
    public void testSetDireccion() {
        re.setDireccion("hola");
        assertEquals(re.getDireccion(), "hola");
    }

    /**
     * Test of hashCode method, of class SucursalEntity.
     */
    @Test
    public void testHashCode() {
        int h= re.hashCode();
        assertTrue(h==re.hashCode());
    }

    /**
     * Test of equals method, of class SucursalEntity.
     */
    @Test
    public void testEquals() {
        RestauranteEntity re1= new RestauranteEntity();
        SucursalEntity se= new SucursalEntity();
        assertTrue(re.equals(re));
        assertFalse(re.equals(null));
        assertFalse(re.equals(re1));
        re.setCalificacion("a");
        se.setCalificacion("e");
        assertFalse(re.equals(se));
    }
    
}
