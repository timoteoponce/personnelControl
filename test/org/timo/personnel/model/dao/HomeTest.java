/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.timo.personnel.model.dao;

import org.timo.personnel.model.User;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.timo.personnel.model.persistence.PersistenceUtil;
import static org.junit.Assert.*;

/**
 *
 * @author timoteo
 */
public class HomeTest {

    public HomeTest() {
    }

    /**
     * Test of getId method, of class Home.
     */
//    @Test
    public void testGetId() {
        System.out.println("getId");
        Home instance = null;
        Object expResult = null;
        Object result = instance.getId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearInstance method, of class Home.
     */
//    @Test
    public void testClearInstance() {
        System.out.println("clearInstance");
        Home instance = null;
        instance.clearInstance();
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Home.
     */
//    @Test
    public void testSetId() {
        System.out.println("setId");
        Object id = null;
        Home instance = null;
        instance.setId(id);
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIdDefined method, of class Home.
     */
//    @Test
    public void testIsIdDefined() {
        System.out.println("isIdDefined");
        Home instance = null;
        boolean expResult = false;
        boolean result = instance.isIdDefined();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of isManaged method, of class Home.
     */
//    @Test
    public void testIsManaged() {
        System.out.println("isManaged");
        Home instance = null;
        boolean expResult = false;
        boolean result = instance.isManaged();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Home.
     */
//    @Test
    public void testUpdate() {
        System.out.println("update");
        Home instance = null;
        instance.update();
        fail("The test case is a prototype.");
    }

    /**
     * Test of persist method, of class Home.
     */
//    @Test
    public void testPersist() {
        System.out.println("persist");
        Home instance = null;
        instance.persist();
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Home.
     */
//    @Test
    public void testRemove() {
        System.out.println("remove");
        Home instance = null;
        instance.remove();
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Home.
     */
    //@Test
    public void testFind() {
        System.out.println("find");
        Home instance = null;
        Object expResult = null;
        Object result = instance.find();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of initInstance method, of class Home.
     */
    //@Test
    public void testInitInstance() {
        System.out.println("initInstance");
        Home instance = null;
        instance.initInstance();
        fail("The test case is a prototype.");
    }

    /**
     * Test of createInstance method, of class Home.
     */
    //@Test
    public void testCreateInstance() {
        System.out.println("createInstance");
        Home instance = null;
        Object expResult = null;
        Object result = instance.createInstance();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdProperty method, of class Home.
     */
    @Test
    public void testGetIdProperty() {
        System.out.println("getIdProperty");
        final User entity = new User();        
        final Home<User> home = (Home<User>) createHome();
        
        final Integer expResult = 25;
        entity.setId(expResult);
        
        assertEquals(expResult, home.getIdProperty(entity));        
    }

    private Home<?> createHome(){
        return new Home<User>(User.class, PersistenceUtil.getEntityManager());
    }

}