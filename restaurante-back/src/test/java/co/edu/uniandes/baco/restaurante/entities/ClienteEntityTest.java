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
public class ClienteEntityTest {
    
    ClienteEntity ce= new ClienteEntity();
    
    public ClienteEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ce= new ClienteEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getReservas method, of class ClienteEntity.
     */
    @Test
    public void testGetReservas() {
        ArrayList<ReservaEntity> res= new ArrayList<>();
        ce.setReservas(res);
        assertEquals(res, ce.getReservas());
    }

    /**
     * Test of getTarjeta method, of class ClienteEntity.
     */
    @Test
    public void testGetTarjeta() {
        TarjetaPuntosEntity tp= new TarjetaPuntosEntity();
        ce.setTarjeta(tp);
        assertEquals(ce.getTarjeta(), tp);
    }

    /**
     * Test of getDom method, of class ClienteEntity.
     */
    @Test
    public void testGetDom() {
        DomicilioEntity dom= new DomicilioEntity();
        ce.setDom(dom);
        assertEquals(ce.getDom(), dom);
    }

    /**
     * Test of getRest method, of class ClienteEntity.
     */
    @Test
    public void testGetRest() {
        RestauranteEntity re= new RestauranteEntity();
        ce.setRest(re);
        assertEquals(ce.getRest(), re);
    }

    /**
     * Test of getMetodos method, of class ClienteEntity.
     */
    @Test
    public void testGetMetodos() {
        ArrayList<PagoEntity> res= new ArrayList<>();
        ce.setMetodos(res);
        assertEquals(res, ce.getMetodos());
    }

    /**
     * Test of getApellido method, of class ClienteEntity.
     */
    @Test
    public void testGetApellido() {
        ce.setApellido("hola");
        assertEquals(ce.getApellido(), "hola");
    }

    /**
     * Test of getNumPuntos method, of class ClienteEntity.
     */
    @Test
    public void testGetNumPuntos() {
        ce.setNumPuntos(155);
        assertTrue(ce.getNumPuntos()==155);
    }

    /**
     * Test of isTieneTarjeta method, of class ClienteEntity.
     */
    @Test
    public void testIsTieneTarjeta() {
        ce.settieneTarjeta(true);
        assertTrue(ce.isTieneTarjeta());
    }

    /**
     * Test of getNombre method, of class ClienteEntity.
     */
    @Test
    public void testGetNombre() {
        ce.setNombre("hola");
        assertEquals(ce.getNombre(), "hola");
    }

    /**
     * Test of setMetodos method, of class ClienteEntity.
     */
    @Test
    public void testSetMetodos() {
        ArrayList<PagoEntity> res= new ArrayList<>();
        ce.setMetodos(res);
        assertEquals(res, ce.getMetodos());
    }

    /**
     * Test of setReservas method, of class ClienteEntity.
     */
    @Test
    public void testSetReservas() {
        ArrayList<ReservaEntity> res= new ArrayList<>();
        ce.setReservas(res);
        assertEquals(res, ce.getReservas());
    }

    /**
     * Test of setTarjeta method, of class ClienteEntity.
     */
    @Test
    public void testSetTarjeta() {
        TarjetaPuntosEntity tp= new TarjetaPuntosEntity();
        ce.setTarjeta(tp);
        assertEquals(ce.getTarjeta(), tp);
    }

    /**
     * Test of setDom method, of class ClienteEntity.
     */
    @Test
    public void testSetDom() {
        DomicilioEntity dom= new DomicilioEntity();
        ce.setDom(dom);
        assertEquals(ce.getDom(), dom);
    }

    /**
     * Test of setRest method, of class ClienteEntity.
     */
    @Test
    public void testSetRest() {
        RestauranteEntity re= new RestauranteEntity();
        ce.setRest(re);
        assertEquals(ce.getRest(), re);
    }

    /**
     * Test of hashCode method, of class ClienteEntity.
     */
    @Test
    public void testHashCode() {
        int h= ce.hashCode();
        assertTrue(ce.hashCode()==h);
    }

    /**
     * Test of equals method, of class ClienteEntity.
     */
    @Test
    public void testEquals() {
        ClienteEntity ce1 = new ClienteEntity();
        ce.settieneTarjeta(true);
        ce1.settieneTarjeta(false);
        RestauranteEntity re= new RestauranteEntity();
        assertTrue(ce.equals(ce));
        assertFalse(ce.equals(null));
        assertFalse(ce.equals(re));
        assertFalse(ce.equals(ce1));
    }
    
}
