/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.ClienteEntity;
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
public class ClienteLogicTest {
    
    ClienteLogic cl= new ClienteLogic();
    
    public ClienteLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cl= new ClienteLogic();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createCliente method, of class ClienteLogic.
     */
    @Test
    public void testCreateCliente() throws Exception {
        ClienteEntity ce = new ClienteEntity();
        ClienteEntity ce1 = cl.createCliente(ce);
        assertEquals(ce, ce1);
    }

    /**
     * Test of getClientes method, of class ClienteLogic.
     */
    @Test
    public void testGetClientes() throws Exception {
        List<ClienteEntity> f = cl.getClientes();
        assertEquals(f, cl.getClientes());
    }

    /**
     * Test of getCliente method, of class ClienteLogic.
     */
    @Test
    public void testGetCliente() throws Exception {
        assertNull(cl.getCliente(Long.valueOf(123123)));
    }

    /**
     * Test of updateCliente method, of class ClienteLogic.
     */
    @Test
    public void testUpdateCliente() throws Exception {
        ClienteEntity cl1= new ClienteEntity();
        cl.createCliente(cl1);
        cl1.setApellido("hola");
        ClienteEntity vi=cl.updateCliente(cl1.getId(), cl1);
        assertEquals(vi.getApellido(), "hola");
    }

    /**
     * Test of deleteCliente method, of class ClienteLogic.
     */
    @Test
    public void testDeleteCliente() throws Exception {
        ClienteEntity cl1= new ClienteEntity();
        cl.createCliente(cl1);
        cl.deleteCliente(cl1.getId());
        assertNull(cl.getCliente(cl1.getId()));
    }
    
}
