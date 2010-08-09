/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timo.personnel;

import org.timo.personnel.model.Person;
import org.timo.personnel.model.dao.Home;
import org.timo.personnel.model.persistence.PersistenceUtil;

/**
 *
 * @author timoteo
 */
public class Starter {

    public static void main(String[] args) {
        final Home<Person> personHome = new Home<Person>(Person.class, PersistenceUtil.getEntityManager());
        personHome.getInstance().setName("timo");
        personHome.persist();
        println("Persisted : " + personHome.getId());

        personHome.clearInstance();
        personHome.getInstance().setName("hugo");
        personHome.persist();
        println("Persisted : " + personHome.getId());

        personHome.clearInstance();
        personHome.getInstance().setName("pablo");
        personHome.persist();
        println("Persisted : " + personHome.getId());

        personHome.clearInstance();
        personHome.setId(1);
        personHome.find();
        println("Found entity : " + personHome.getInstance().getName() + " , id " + personHome.getInstance().getId());
    }

    private static void println(String str) {
        System.out.println(str);
    }
}
