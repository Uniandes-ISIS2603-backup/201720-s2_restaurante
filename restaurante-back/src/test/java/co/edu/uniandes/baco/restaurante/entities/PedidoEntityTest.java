/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.util.ArrayList;
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
public class PedidoEntityTest {
    
    PedidoEntity pe = new PedidoEntity();
    
    public PedidoEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pe= new PedidoEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPlatos method, of class PedidoEntity.
     */
    @Test
    public void testGetPlatos() {
        ArrayList<PlatoEntity> pl= new ArrayList<>();
        pe.setPlatos(pl);
        assertEquals(pe.getPlatos(), pl);
    }

    /**
     * Test of setPlatos method, of class PedidoEntity.
     */
    @Test
    public void testSetPlatos() {
        ArrayList<PlatoEntity> pl= new ArrayList<>();
        pe.setPlatos(pl);
        assertEquals(pe.getPlatos(), pl);
    }

    /**
     * Test of getDomicilio method, of class PedidoEntity.
     */
    @Test
    public void testGetDomicilio() {
        DomicilioEntity dom= new DomicilioEntity();
        pe.setDomicilio(dom);
        assertEquals(pe.getDomicilio(), dom);
    }

    /**
     * Test of setDomicilio method, of class PedidoEntity.
     */
    @Test
    public void testSetDomicilio() {
        DomicilioEntity dom= new DomicilioEntity();
        pe.setDomicilio(dom);
        assertEquals(pe.getDomicilio(), dom);
    }

    /**
     * Test of getPago method, of class PedidoEntity.
     */
    @Test
    public void testGetPago() {
        PagoEntity pago= new PagoEntity();
        pe.setPago(pago);
        assertEquals(pe.getPago(), pago);
    }

    /**
     * Test of setPago method, of class PedidoEntity.
     */
    @Test
    public void testSetPago() {
        PagoEntity pago= new PagoEntity();
        pe.setPago(pago);
        assertEquals(pe.getPago(), pago);
    }

    /**
     * Test of getFecha method, of class PedidoEntity.
     */
    @Test
    public void testGetFecha() {
        Date fecha= new Date();
        pe.setFecha(fecha);
        assertEquals(pe.getFecha(), fecha);
    }

    /**
     * Test of getDireccion method, of class PedidoEntity.
     */
    @Test
    public void testGetDireccion() {
        pe.setDireccion("hola");
        assertEquals(pe.getDireccion(), "hola");
    }

    /**
     * Test of setDireccion method, of class PedidoEntity.
     */
    @Test
    public void testSetDireccion() {
        pe.setDireccion("hola");
        assertEquals(pe.getDireccion(), "hola");
    }

    /**
     * Test of hashCode method, of class PedidoEntity.
     */
    @Test
    public void testHashCode() {
        int d=pe.hashCode();
        assertTrue(d==pe.hashCode());
    }

    /**
     * Test of equals method, of class PedidoEntity.
     */
    @Test
    public void testEquals() {
        RestauranteEntity re = new RestauranteEntity();
        assertTrue(pe.equals(pe));
        assertFalse(pe.equals(null));
        assertFalse(pe.equals(re));
        PedidoEntity pe1= new PedidoEntity();
        pe.setFecha(new Date(111111111));
        pe.setDireccion("hola");
        pe1.setFecha(new Date(111121111));
        pe1.setDireccion("hola");
        assertFalse(pe.equals(pe1));
        pe1.setDireccion("Holiwis");
        assertFalse(pe.equals(pe1));
    }
    
}
