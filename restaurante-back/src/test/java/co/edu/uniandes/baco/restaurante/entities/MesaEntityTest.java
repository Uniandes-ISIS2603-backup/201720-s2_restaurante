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
public class MesaEntityTest {
    
    MesaEntity me = new MesaEntity();
    
    public MesaEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        me = new MesaEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSucursal method, of class MesaEntity.
     */
    @Test
    public void testGetSucursal() {
        SucursalEntity se = new SucursalEntity();
        me.setSucursal(se);
        assertEquals(me.getSucursal(), se);
    }

    /**
     * Test of getReserva method, of class MesaEntity.
     */
    @Test
    public void testGetReserva() {
        ReservaEntity re = new ReservaEntity();
        me.setReserva(re);
        assertEquals(me.getReserva(), re);
    }

    /**
     * Test of setSucursal method, of class MesaEntity.
     */
    @Test
    public void testSetSucursal() {
        SucursalEntity se = new SucursalEntity();
        me.setSucursal(se);
        assertEquals(me.getSucursal(), se);
    }

    /**
     * Test of setReserva method, of class MesaEntity.
     */
    @Test
    public void testSetReserva() {
        ReservaEntity re = new ReservaEntity();
        me.setReserva(re);
        assertEquals(me.getReserva(), re);
    }

    /**
     * Test of getSillasDisponibles method, of class MesaEntity.
     */
    @Test
    public void testGetSillasDisponibles() {
        me.setSillasDisponibles(10);
        assertTrue(me.getSillasDisponibles()==10);
    }

    /**
     * Test of getPiso method, of class MesaEntity.
     */
    @Test
    public void testGetPiso() {
        me.setPiso(1);
        assertTrue(me.getPiso()==1);
    }

    /**
     * Test of isDisponible method, of class MesaEntity.
     */
    @Test
    public void testIsDisponible() {
        me.setDisponible(true);
        assertTrue(me.isDisponible());
    }

    /**
     * Test of hashCode method, of class MesaEntity.
     */
    @Test
    public void testHashCode() {
        assertTrue(me.hashCode()==8);
    }

    /**
     * Test of equals method, of class MesaEntity.
     */
    @Test
    public void testEquals() {
        PlatoEntity pe= new PlatoEntity();
        assertTrue(me.equals(me));
        assertFalse(me.equals(false));
        assertFalse(me.equals(pe));
    }
    
}
