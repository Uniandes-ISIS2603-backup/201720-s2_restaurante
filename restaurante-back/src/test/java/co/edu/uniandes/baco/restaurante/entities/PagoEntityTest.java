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
public class PagoEntityTest {

    PagoEntity pe = new PagoEntity();

    public PagoEntityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pe = new PagoEntity();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPedidos method, of class PagoEntity.
     */
    @Test
    public void testGetPedidos() {
        ArrayList<PedidoEntity> pedidos = new ArrayList<>();
        pe.setPedidos(pedidos);
        assertEquals(pe.getPedidos(), pedidos);
    }

    /**
     * Test of setPedidos method, of class PagoEntity.
     */
    @Test
    public void testSetPedidos() {
        ArrayList<PedidoEntity> pedidos = new ArrayList<>();
        pe.setPedidos(pedidos);
        assertEquals(pe.getPedidos(), pedidos);
    }

    /**
     * Test of getDomicilio method, of class PagoEntity.
     */
    @Test
    public void testGetDomicilio() {
        DomicilioEntity dom = new DomicilioEntity();
        pe.setDomicilio(dom);
        assertEquals(pe.getDomicilio(), dom);
    }

    /**
     * Test of setDomicilio method, of class PagoEntity.
     */
    @Test
    public void testSetDomicilio() {
        DomicilioEntity dom = new DomicilioEntity();
        pe.setDomicilio(dom);
        assertEquals(pe.getDomicilio(), dom);
    }

    /**
     * Test of getCliente method, of class PagoEntity.
     */
    @Test
    public void testGetCliente() {
        ClienteEntity ce = new ClienteEntity();
        pe.setCliente(ce);
        assertEquals(ce, pe.getCliente());
    }

    /**
     * Test of setCliente method, of class PagoEntity.
     */
    @Test
    public void testSetCliente() {
        ClienteEntity ce = new ClienteEntity();
        pe.setCliente(ce);
        assertEquals(ce, pe.getCliente());
    }

    /**
     * Test of setRegistrado method, of class PagoEntity.
     */
    @Test
    public void testSetRegistrado() {
        pe.setRegistrado(true);
        assertTrue(pe.getRegistrado());
    }

    /**
     * Test of setPagoAnticipado method, of class PagoEntity.
     */
    @Test
    public void testSetPagoAnticipado() {
        pe.setPagoAnticipado(true);
        assertTrue(pe.getPagoAnticipado());
    }

    /**
     * Test of setTipo method, of class PagoEntity.
     */
    @Test
    public void testSetTipo() {
        pe.setTipo("comida");
        assertEquals(pe.getTipo(), "comida");
    }

    /**
     * Test of getRegistrado method, of class PagoEntity.
     */
    @Test
    public void testGetRegistrado() {
        pe.setRegistrado(true);
        assertTrue(pe.getRegistrado());
    }

    /**
     * Test of getPagoAnticipado method, of class PagoEntity.
     */
    @Test
    public void testGetPagoAnticipado() {
        pe.setPagoAnticipado(true);
        assertTrue(pe.getPagoAnticipado());
    }

    /**
     * Test of getTipo method, of class PagoEntity.
     */
    @Test
    public void testGetTipo() {
        pe.setTipo("comida");
        assertEquals(pe.getTipo(), "comida");
    }

    /**
     * Test of hashCode method, of class PagoEntity.
     */
    @Test
    public void testHashCode() {
        assertTrue(pe.hashCode()==5);
    }

    /**
     * Test of equals method, of class PagoEntity.
     */
    @Test
    public void testEquals() {
        RestauranteEntity re = new RestauranteEntity();
        assertTrue(pe.equals(pe));
        assertFalse(pe.equals(null));
        assertFalse(pe.equals(re));
    }

}
