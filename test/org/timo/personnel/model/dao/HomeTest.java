/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.timo.personnel.model.dao;

import org.timo.personnel.model.User;
import org.junit.Test;
import org.timo.personnel.model.persistence.PersistenceUtil;
import static org.junit.Assert.*;

/**
 *
 * @author timoteo
 */
public class HomeTest {

    /**
     * Test of clearInstance method, of class Home.
     */
    @Test
    public void testClearInstance() {
        System.out.println("clearInstance");
        final Home<User> home = (Home<User>) createHome();
        home.getInstance().setUsername("test");

        home.clearInstance();
        assertNull(home.getInstance().getUsername());
    }


    /**
     * Test of isIdDefined method, of class Home.
     */
    @Test
    public void testIsIdDefined() {
        System.out.println("isIdDefined");
        final Home<User> home = (Home<User>) createHome();
        assertFalse(home.isIdDefined());
        home.setId(Integer.valueOf(25));
        assertTrue(home.isIdDefined());
    }

    /**
     * Test of isManaged method, of class Home.
     */
    @Test
    public void testIsManaged() {
        System.out.println("isManaged");
        final Home<User> home = (Home<User>) createHome();
        home.getInstance().setUsername("test");
        home.getInstance().setPassword("test");

        assertFalse(home.isManaged());
        home.persist();
        assertTrue(home.isManaged());
    }

    /**
     * Test of update method, of class Home.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        final Home<User> home = (Home<User>) createHome();
        home.getInstance().setUsername("test");
        home.getInstance().setPassword("test");
        home.persist();
        final Integer savedId = home.getInstance().getId();

        final String modString = "testModified";
        home.getInstance().setUsername(modString);
        home.update();

        home.clearInstance();
        home.setId(savedId);
        assertEquals(modString, home.getInstance().getUsername());
    }

    /**
     * Test of persist method, of class Home.
     */
    @Test
    public void testPersist() {
        System.out.println("persist");
        final Home<User> home = (Home<User>) createHome();
        home.getInstance().setUsername("test");
        home.getInstance().setPassword("test");
        home.persist();
        final Integer savedId = home.getInstance().getId();
        assertNotNull(savedId);

        home.clearInstance();
        home.setId(savedId);
        assertEquals(savedId, home.getInstance().getId());
    }

    /**
     * 
     */
    @Test
    public void testInitInstance() {
        System.out.println("persist");
        final Home<User> home = (Home<User>) createHome();
        home.getInstance().setUsername("test");
        home.getInstance().setPassword("test");
        home.persist();
        final Integer savedId = home.getInstance().getId();

        home.clearInstance();
        home.initInstance();
        assertNull(home.getInstance().getId());

        home.clearInstance();
        home.setId(savedId);
        home.initInstance();
        assertEquals(savedId, home.getInstance().getId());
    }

    /**
     * Test of remove method, of class Home.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        final Home<User> home = (Home<User>) createHome();
        home.getInstance().setUsername("test");
        home.getInstance().setPassword("test");
        home.persist();

        final Integer savedId = home.getInstance().getId();
        home.clearInstance();
        home.setId(savedId);
        assertEquals(savedId, home.find().getId());

        home.remove();
        home.setId(savedId);
        assertNull(home.find());
    }

    /**
     * Test of find method, of class Home.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        final Home<User> home = (Home<User>) createHome();
        home.getInstance().setUsername("test");
        home.getInstance().setPassword("test");
        home.persist();

        final Integer savedId = home.getInstance().getId();
        home.clearInstance();
        home.setId(savedId);
        
        assertEquals(savedId, home.find().getId());
    }

    /**
     * Test of createInstance method, of class Home.
     */
    @Test
    public void testCreateInstance() {
        System.out.println("createInstance");
        final Home<User> home = (Home<User>) createHome();
        home.getInstance().setId(25);

        assertEquals(home.getInstance().getId(), Integer.valueOf(25));
        
        home.clearInstance();
        assertNull(home.getInstance().getId());
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