/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;
import java.util.List;
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
public class DomicilioLogicTest {
    
    DomicilioLogic dl= new DomicilioLogic();
    
    public DomicilioLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dl= new DomicilioLogic();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createDomicilio method, of class DomicilioLogic.
     */
    @Test
    public void testCreateDomicilio() throws Exception {
        DomicilioEntity ce = new DomicilioEntity();
        DomicilioEntity ce1 = dl.createDomicilio(ce);
        assertEquals(ce, ce1);
    }

    /**
     * Test of getDomicilios method, of class DomicilioLogic.
     */
    @Test
    public void testGetDomicilios() throws Exception {
        List<DomicilioEntity> f = dl.getDomicilios();
        assertEquals(f, dl.getDomicilios());
    }

    /**
     * Test of getDomicilio method, of class DomicilioLogic.
     */
    @Test
    public void testGetDomicilio() throws Exception {
        assertNull(dl.getDomicilio(Long.valueOf(123123)));
    }

    /**
     * Test of updateDomicilio method, of class DomicilioLogic.
     */
    @Test
    public void testUpdateDomicilio() throws Exception {
        DomicilioEntity cl1= new DomicilioEntity();
        dl.createDomicilio(cl1);
        cl1.setRango(123);
        DomicilioEntity vi=dl.updateDomicilio(cl1.getId(), cl1);
        assertEquals(vi.getRango(), 123);
    }

    /**
     * Test of deleteDomicilio method, of class DomicilioLogic.
     */
    @Test
    public void testDeleteDomicilio() throws Exception {
        DomicilioEntity cl1= new DomicilioEntity();
        dl.createDomicilio(cl1);
        dl.deleteDomicilio(cl1.getId());
        assertNull(dl.getDomicilio(cl1.getId()));
    }
    
}
