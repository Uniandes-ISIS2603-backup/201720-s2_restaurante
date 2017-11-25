/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.util.Date;
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
public class ReservaEntityTest {
    
    ReservaEntity re= new ReservaEntity();
    
    public ReservaEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        re= new ReservaEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRestaurante method, of class ReservaEntity.
     */
    @Test
    public void testGetRestaurante() {
        RestauranteEntity re1= new RestauranteEntity();
        re.setRestaurante(re1);
        assertEquals(re.getRestaurante(), re1);
    }
    
    /**
     * Test of setRestaurante method, of class ReservaEntity.
     */
    @Test
    public void testSetRestaurante() {
        RestauranteEntity re1= new RestauranteEntity();
        re.setRestaurante(re1);
        assertEquals(re.getRestaurante(), re1);
    }

    /**
     * Test of getCliente method, of class ReservaEntity.
     */
    @Test
    public void testGetCliente() {
        ClienteEntity ce= new ClienteEntity();
        re.setCliente(ce);
        assertEquals(re.getCliente(), ce);
    }

    /**
     * Test of setCliente method, of class ReservaEntity.
     */
    @Test
    public void testSetCliente() {
        ClienteEntity ce= new ClienteEntity();
        re.setCliente(ce);
        assertEquals(re.getCliente(), ce);
    }

    /**
     * Test of getMesa method, of class ReservaEntity.
     */
    @Test
    public void testGetMesa() {
        MesaEntity me= new MesaEntity();
        re.setMesa(me);
        assertEquals(re.getMesa(), me);
    }

    /**
     * Test of setMesa method, of class ReservaEntity.
     */
    @Test
    public void testSetMesa() {
        MesaEntity me= new MesaEntity();
        re.setMesa(me);
        assertEquals(re.getMesa(), me);
    }

    /**
     * Test of getFecha method, of class ReservaEntity.
     */
    @Test
    public void testGetFecha() {
        Date fecha = new Date();
        re.setFecha(fecha);
        assertEquals(re.getFecha(), fecha);
    }

    /**
     * Test of setFecha method, of class ReservaEntity.
     */
    @Test
    public void testSetFecha() {
        Date fecha = new Date();
        re.setFecha(fecha);
        assertEquals(re.getFecha(), fecha);
    }

    /**
     * Test of hashCode method, of class ReservaEntity.
     */
    @Test
    public void testHashCode() {
        int h= re.hashCode();
        assertTrue(h==re.hashCode());
    }

    /**
     * Test of equals method, of class ReservaEntity.
     */
    @Test
    public void testEquals() {
        RestauranteEntity re1 = new RestauranteEntity();
        assertTrue(re.equals(re));
        assertFalse(re.equals(null));
        assertFalse(re.equals(re1));
        ReservaEntity re2= new ReservaEntity();
        re.setFecha(new Date(1111));
        re2.setFecha(new Date(2222));
        assertFalse(re.equals(re2));
    }
    
}
