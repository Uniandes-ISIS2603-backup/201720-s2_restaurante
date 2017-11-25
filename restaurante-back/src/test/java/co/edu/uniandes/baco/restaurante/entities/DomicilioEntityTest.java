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
public class DomicilioEntityTest {
    
    DomicilioEntity dom= new DomicilioEntity();
    
    public DomicilioEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dom= new DomicilioEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPago method, of class DomicilioEntity.
     */
    @Test
    public void testGetPago() {
        PagoEntity p= new PagoEntity();
        dom.setPago(p);
        assertEquals(p, dom.getPago());
    }

    /**
     * Test of setPago method, of class DomicilioEntity.
     */
    @Test
    public void testSetPago() {
        PagoEntity p= new PagoEntity();
        dom.setPago(p);
        assertEquals(p, dom.getPago());
    }

    /**
     * Test of getPedido method, of class DomicilioEntity.
     */
    @Test
    public void testGetPedido() {
        PedidoEntity p= new PedidoEntity();
        dom.setPedido(p);
        assertEquals(p, dom.getPedido());
    }

    /**
     * Test of setPedido method, of class DomicilioEntity.
     */
    @Test
    public void testSetPedido() {
        PedidoEntity p= new PedidoEntity();
        dom.setPedido(p);
        assertEquals(p, dom.getPedido());
    }

    /**
     * Test of getCliente method, of class DomicilioEntity.
     */
    @Test
    public void testGetCliente() {
        ClienteEntity p= new ClienteEntity();
        dom.setCliente(p);
        assertEquals(p, dom.getCliente());
    }

    /**
     * Test of setCliente method, of class DomicilioEntity.
     */
    @Test
    public void testSetCliente() {
        ClienteEntity p= new ClienteEntity();
        dom.setCliente(p);
        assertEquals(p, dom.getCliente());
    }

    /**
     * Test of getRest method, of class DomicilioEntity.
     */
    @Test
    public void testGetRest() {
        RestauranteEntity p= new RestauranteEntity();
        dom.setRest(p);
        assertEquals(p, dom.getRest());
    }

    /**
     * Test of setRest method, of class DomicilioEntity.
     */
    @Test
    public void testSetRest() {
        RestauranteEntity p= new RestauranteEntity();
        dom.setRest(p);
        assertEquals(p, dom.getRest());
    }

    /**
     * Test of getRango method, of class DomicilioEntity.
     */
    @Test
    public void testGetRango() {
        dom.setRango(10);
        assertEquals(10, dom.getRango());
    }

    /**
     * Test of setRango method, of class DomicilioEntity.
     */
    @Test
    public void testSetRango() {
        dom.setRango(10);
        assertEquals(10, dom.getRango());
    }

    /**
     * Test of hashCode method, of class DomicilioEntity.
     */
    @Test
    public void testHashCode() {
        assertTrue(dom.hashCode()==3);
    }

    /**
     * Test of equals method, of class DomicilioEntity.
     */
    @Test
    public void testEquals() {
        assertTrue(dom.equals(dom));
    }
    
}
