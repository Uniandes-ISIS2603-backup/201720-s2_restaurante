/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.sql.Time;
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
public class TarjetaPuntosEntityTest {
    
    TarjetaPuntosEntity re= new TarjetaPuntosEntity();
    
    public TarjetaPuntosEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        re= new TarjetaPuntosEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRest method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testGetRest() {
        RestauranteEntity re1= new RestauranteEntity();
        re.setRest(re1);
        assertEquals(re.getRest(), re1);
    }

    /**
     * Test of setRest method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testSetRest() {
        RestauranteEntity re1= new RestauranteEntity();
        re.setRest(re1);
        assertEquals(re.getRest(), re1);
    }

    /**
     * Test of getCliente method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testGetCliente() {
        ClienteEntity ce= new ClienteEntity();
        re.setCliente(ce);
        assertEquals(re.getCliente(), ce);
    }

    /**
     * Test of setCliente method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testSetCliente() {
        ClienteEntity ce= new ClienteEntity();
        re.setCliente(ce);
        assertEquals(re.getCliente(), ce);
    }

    /**
     * Test of getPuntos method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testGetPuntos() {
        re.setPuntos(100);
        assertEquals(re.getPuntos(), 100);
    }

    /**
     * Test of setPuntos method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testSetPuntos() {
        re.setPuntos(100);
        assertEquals(re.getPuntos(), 100);
    }

    /**
     * Test of getVencimientos method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testGetVencimientos() {
        ArrayList<Time> ven= new ArrayList<>();
        re.setVencimientos(ven);
        assertEquals(ven, re.getVencimientos());
    }

    /**
     * Test of setVencimientos method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testSetVencimientos() {
        ArrayList<Time> ven= new ArrayList<>();
        re.setVencimientos(ven);
        assertEquals(ven, re.getVencimientos());
    }

    /**
     * Test of hashCode method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testHashCode() {
        int h= re.hashCode();
        assertTrue(h==re.hashCode());
    }

    /**
     * Test of equals method, of class TarjetaPuntosEntity.
     */
    @Test
    public void testEquals() {
        RestauranteEntity re1 = new RestauranteEntity();
        assertTrue(re.equals(re));
        assertFalse(re.equals(null));
        assertFalse(re.equals(re1));
        TarjetaPuntosEntity te= new TarjetaPuntosEntity();
        re.setPuntos(100);
        te.setPuntos(2);
        assertFalse(re.equals(te));
    }
    
}
