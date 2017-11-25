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
public class RestauranteEntityTest {
    RestauranteEntity re= new RestauranteEntity();
    
    public RestauranteEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        re= new RestauranteEntity();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSucursales method, of class RestauranteEntity.
     */
    @Test
    public void testGetSucursales() {
        ArrayList<SucursalEntity> su= new ArrayList<>();
        re.setSucursales(su);
        assertEquals(re.getSucursales(), su);
    }

    /**
     * Test of setSucursales method, of class RestauranteEntity.
     */
    @Test
    public void testSetSucursales() {
        ArrayList<SucursalEntity> su= new ArrayList<>();
        re.setSucursales(su);
        assertEquals(re.getSucursales(), su);
    }

    /**
     * Test of getReservas method, of class RestauranteEntity.
     */
    @Test
    public void testGetReservas() {
        ArrayList<ReservaEntity> se= new ArrayList<>();
        re.setReservas(se);
        assertEquals(se, re.getReservas());
    }

    /**
     * Test of getClientes method, of class RestauranteEntity.
     */
    @Test
    public void testGetClientes() {
        ArrayList<ClienteEntity> cl= new ArrayList<>();
        re.setClientes(cl);
        assertEquals(re.getClientes(), cl);
    }

    /**
     * Test of setClientes method, of class RestauranteEntity.
     */
    @Test
    public void testSetClientes() {
        ArrayList<ClienteEntity> cl= new ArrayList<>();
        re.setClientes(cl);
        assertEquals(re.getClientes(), cl);
    }

    /**
     * Test of getTarjetas method, of class RestauranteEntity.
     */
    @Test
    public void testGetTarjetas() {
        ArrayList<TarjetaPuntosEntity> tp= new ArrayList<>();
        re.setTarjetas(tp);
        assertEquals(re.getTarjetas(), tp);
    }

    /**
     * Test of setTarjetas method, of class RestauranteEntity.
     */
    @Test
    public void testSetTarjetas() {
        ArrayList<TarjetaPuntosEntity> tp= new ArrayList<>();
        re.setTarjetas(tp);
        assertEquals(re.getTarjetas(), tp);
    }

    /**
     * Test of getPlatos method, of class RestauranteEntity.
     */
    @Test
    public void testGetPlatos() {
        ArrayList<PlatoEntity> pl= new ArrayList<>();
        re.setPlatos(pl);
        assertEquals(re.getPlatos(), pl);
    }

    /**
     * Test of setPlatos method, of class RestauranteEntity.
     */
    @Test
    public void testSetPlatos() {
        ArrayList<PlatoEntity> pl= new ArrayList<>();
        re.setPlatos(pl);
        assertEquals(re.getPlatos(), pl);
    }

    /**
     * Test of getDomicilios method, of class RestauranteEntity.
     */
    @Test
    public void testGetDomicilios() {
        ArrayList<DomicilioEntity> dom= new ArrayList<>();
        re.setDomicilios(dom);
        assertEquals(re.getDomicilios(), dom);
    }

    /**
     * Test of setDomicilios method, of class RestauranteEntity.
     */
    @Test
    public void testSetDomicilios() {
        ArrayList<DomicilioEntity> dom= new ArrayList<>();
        re.setDomicilios(dom);
        assertEquals(re.getDomicilios(), dom);
    }

    /**
     * Test of setReservas method, of class RestauranteEntity.
     */
    @Test
    public void testSetReservas() {
        ArrayList<ReservaEntity> se= new ArrayList<>();
        re.setReservas(se);
        assertEquals(se, re.getReservas());
    }

    /**
     * Test of getHoraInicioManiana method, of class RestauranteEntity.
     */
    @Test
    public void testGetHoraInicioManiana() {
        Date fecha = new Date();
        re.setHoraInicioManiana(fecha);
        assertEquals(re.getHoraInicioManiana(), fecha);
    }

    /**
     * Test of setHoraInicioManiana method, of class RestauranteEntity.
     */
    @Test
    public void testSetHoraInicioManiana() {
        Date fecha = new Date();
        re.setHoraInicioManiana(fecha);
        assertEquals(re.getHoraInicioManiana(), fecha);
    }

    /**
     * Test of getHoraInicioTarde method, of class RestauranteEntity.
     */
    @Test
    public void testGetHoraInicioTarde() {
        Date fecha = new Date();
        re.setHoraInicioTarde(fecha);
        assertEquals(re.getHoraInicioTarde(), fecha);
    }

    /**
     * Test of setHoraInicioTarde method, of class RestauranteEntity.
     */
    @Test
    public void testSetHoraInicioTarde() {
        Date fecha = new Date();
        re.setHoraInicioTarde(fecha);
        assertEquals(re.getHoraInicioTarde(), fecha);
    }

    /**
     * Test of getHoraFinManiana method, of class RestauranteEntity.
     */
    @Test
    public void testGetHoraFinManiana() {
        Date fecha = new Date();
        re.setHoraFinManiana(fecha);
        assertEquals(re.getHoraFinManiana(), fecha);
    }

    /**
     * Test of setHoraFinManiana method, of class RestauranteEntity.
     */
    @Test
    public void testSetHoraFinManiana() {
        Date fecha = new Date();
        re.setHoraFinManiana(fecha);
        assertEquals(re.getHoraFinManiana(), fecha);
    }

    /**
     * Test of getHoraFinTarde method, of class RestauranteEntity.
     */
    @Test
    public void testGetHoraFinTarde() {
        Date fecha = new Date();
        re.setHoraFinTarde(fecha);
        assertEquals(re.getHoraFinTarde(), fecha);
    }

    /**
     * Test of setHoraFinTarde method, of class RestauranteEntity.
     */
    @Test
    public void testSetHoraFinTarde() {
        Date fecha = new Date();
        re.setHoraFinTarde(fecha);
        assertEquals(re.getHoraFinTarde(), fecha);
    }

    /**
     * Test of hashCode method, of class RestauranteEntity.
     */
    @Test
    public void testHashCode() {
        int h= re.hashCode();
        assertTrue(h==re.hashCode());
    }

    /**
     * Test of equals method, of class RestauranteEntity.
     */
    @Test
    public void testEquals() {
        RestauranteEntity re1 = new RestauranteEntity();
        ReservaEntity re2= new ReservaEntity();
        assertTrue(re.equals(re));
        assertFalse(re.equals(null));
        assertFalse(re.equals(re2)); 
        re.setHoraInicioManiana(new Date(1111));
        re1.setHoraInicioManiana(new Date(2222));
        re.setHoraInicioTarde(new Date(1111));
        re1.setHoraInicioTarde(new Date(2222));
        assertFalse(re.equals(re1));
    }
    
}
