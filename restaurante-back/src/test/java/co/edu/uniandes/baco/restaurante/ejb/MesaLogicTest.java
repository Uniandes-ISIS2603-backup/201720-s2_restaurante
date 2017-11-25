/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.MesaEntity;
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
public class MesaLogicTest {
    
    MesaLogic dl= new MesaLogic();
    
    public MesaLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dl= new MesaLogic();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createMesa method, of class MesaLogic.
     */
    @Test
    public void testCreateMesa() throws Exception {
        MesaEntity ce = new MesaEntity();
        MesaEntity ce1 = dl.createMesa(ce);
        assertEquals(ce, ce1);
    }

    /**
     * Test of getMesas method, of class MesaLogic.
     */
    @Test
    public void testGetMesas() throws Exception {
        List<MesaEntity> f = dl.getMesas();
        assertEquals(f, dl.getMesas());
    }

    /**
     * Test of updateMesa method, of class MesaLogic.
     */
    @Test
    public void testUpdateMesa() throws Exception {
        MesaEntity cl1= new MesaEntity();
        dl.createMesa(cl1);
        cl1.setPiso(123);
        MesaEntity vi=dl.updateMesa(cl1);
        assertEquals(vi.getPiso(), 123);
    }

    /**
     * Test of deleteMesa method, of class MesaLogic.
     */
    @Test
    public void testDeleteMesa() throws Exception {
        MesaEntity cl1= new MesaEntity();
        dl.createMesa(cl1);
        dl.deleteMesa(cl1.getId());
        assertNull(dl.getMesa(cl1.getId()));
    }

    /**
     * Test of getMesa method, of class MesaLogic.
     */
    @Test
    public void testGetMesa() throws Exception {
        assertNull(dl.getMesa(Long.valueOf(123123)));
    }

}
