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
public class PlatoEntityTest {
    
    PlatoEntity pe= new PlatoEntity();
    
    public PlatoEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pe= new PlatoEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPedido method, of class PlatoEntity.
     */
    @Test
    public void testGetPedido() {
        PedidoEntity a= new PedidoEntity();
        pe.setPedido(a);
        assertEquals(pe.getPedido(), a);
    }

    /**
     * Test of setPedido method, of class PlatoEntity.
     */
    @Test
    public void testSetPedido() {
        PedidoEntity a= new PedidoEntity();
        pe.setPedido(a);
        assertEquals(pe.getPedido(), a);
    }

    /**
     * Test of getRestaurante method, of class PlatoEntity.
     */
    @Test
    public void testGetRestaurante() {
        RestauranteEntity re= new RestauranteEntity();
        pe.setRestaurante(re);
        assertEquals(pe.getRestaurante(), re);
    }

    /**
     * Test of setRestaurante method, of class PlatoEntity.
     */
    @Test
    public void testSetRestaurante() {
        RestauranteEntity re= new RestauranteEntity();
        pe.setRestaurante(re);
        assertEquals(pe.getRestaurante(), re);
    }

    /**
     * Test of getSucursales method, of class PlatoEntity.
     */
    @Test
    public void testGetSucursales() {
        ArrayList<SucursalEntity> se= new ArrayList<>();
        pe.setSucursales(se);
        assertEquals(pe.getSucursales(), se);
    }

    /**
     * Test of setSucursales method, of class PlatoEntity.
     */
    @Test
    public void testSetSucursales() {
        ArrayList<SucursalEntity> se= new ArrayList<>();
        pe.setSucursales(se);
        assertEquals(pe.getSucursales(), se);
    }

    /**
     * Test of getTipo method, of class PlatoEntity.
     */
    @Test
    public void testGetTipo() {
        pe.setTipo("hola");
        assertEquals(pe.getTipo(), "hola");
    }

    /**
     * Test of setTipo method, of class PlatoEntity.
     */
    @Test
    public void testSetTipo() {
        pe.setTipo("hola");
        assertEquals(pe.getTipo(), "hola");
    }

    /**
     * Test of isEspecialSucursal method, of class PlatoEntity.
     */
    @Test
    public void testIsEspecialSucursal() {
        pe.setEspecialSucursal(true);
        assertTrue(pe.isEspecialSucursal());
    }

    /**
     * Test of setEspecialSucursal method, of class PlatoEntity.
     */
    @Test
    public void testSetEspecialSucursal() {
        pe.setEspecialSucursal(true);
        assertTrue(pe.isEspecialSucursal());
    }

    /**
     * Test of getPrecio method, of class PlatoEntity.
     */
    @Test
    public void testGetPrecio() {
        pe.setPrecio(12);
        assertTrue(pe.getPrecio()==12);
    }

    /**
     * Test of setPrecio method, of class PlatoEntity.
     */
    @Test
    public void testSetPrecio() {
        pe.setPrecio(12);
        assertTrue(pe.getPrecio()==12);
    }

    /**
     * Test of hashCode method, of class PlatoEntity.
     */
    @Test
    public void testHashCode() {
        int h= pe.hashCode();
        assertTrue(h==pe.hashCode());
    }

    /**
     * Test of equals method, of class PlatoEntity.
     */
    @Test
    public void testEquals() {
        RestauranteEntity re = new RestauranteEntity();
        assertTrue(pe.equals(pe));
        assertFalse(pe.equals(null));
        assertFalse(pe.equals(re));
        PlatoEntity pe1= new PlatoEntity();
        pe1.setEspecialSucursal(true);
        pe.setEspecialSucursal(false);
        pe1.setTipo("hola");
        pe.setTipo("holiwis");
        assertFalse(pe.equals(pe1));
    }
    
}
