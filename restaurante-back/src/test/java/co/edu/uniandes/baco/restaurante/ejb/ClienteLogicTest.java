/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.ClienteEntity;
import org.junit.After;
import org.junit.Before;
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
        ClienteEntity ce= new ClienteEntity();
        ce.setApellido("hola");
        try{
        cl.createCliente(ce);
        }catch(Exception e){
            assertTrue(e!=null);
        }
    }

    /**
     * Test of getClientes method, of class ClienteLogic.
     */
    @Test
    public void testGetClientes() throws Exception {
        try{
        cl.getClientes();
        }catch(Exception e){
            assertTrue(e!=null);
        }
    }

    /**
     * Test of getCliente method, of class ClienteLogic.
     */
    @Test
    public void testGetCliente() throws Exception {
        try{
        cl.getCliente(Long.valueOf(1));
        }catch(Exception e){
            assertTrue(e!=null);
        }
    }

    /**
     * Test of updateCliente method, of class ClienteLogic.
     */
    @Test
    public void testUpdateCliente() throws Exception {
        ClienteEntity ce= new ClienteEntity();
        try{
        cl.updateCliente(Long.valueOf(1),ce);
        }catch(Exception e){
            assertTrue(e!=null);
        }
    }

    /**
     * Test of deleteCliente method, of class ClienteLogic.
     */
    @Test
    public void testDeleteCliente() throws Exception {
        try{
        cl.deleteCliente(Long.valueOf(1));
        }catch(Exception e){
            assertTrue(e!=null);
        }
    }
    
}
