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

    public Starter(){
        Home<Person> personHome = new Home<Person>(Person.class, PersistenceUtil.getEntityManager());
        personHome.getInstance().setFirstName("timo");
        personHome.getInstance().setLastName("ponce");
        personHome.persist();
        println("Persisted : " + personHome.getInstance().toString());

        personHome.clearInstance();
        personHome.getInstance().setFirstName("hugo");
        personHome.getInstance().setLastName("ponce");
        personHome.persist();
        println("Persisted : " + personHome.getInstance().toString());

        personHome.clearInstance();
        personHome.getInstance().setFirstName("pedro");
        personHome.getInstance().setLastName("ponce");
        personHome.persist();
        println("Persisted : " + personHome.getInstance().toString());

        personHome.clearInstance();
        personHome.setId(1);
        personHome.find();
        println("Found entity : " + personHome.getInstance().toString());
        personHome = null;
    }

    public static void main(String[] args) {
        new Starter();
    }

    private static void println(String str) {
        System.out.println(str);
    }
}
