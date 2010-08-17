/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.timo.personnel.service.impl;

import java.awt.event.ActionEvent;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.timo.personnel.model.Role;
import org.timo.personnel.model.dao.Home;
import org.timo.personnel.service.RoleService;

/**
 *
 * @author timoteo
 */
public class RoleServiceImpl implements RoleService{

    private final Home<Role> roleHome;

    public RoleServiceImpl(Home<Role> roleHome) {
        this.roleHome = roleHome;
    }

    @Override
    public Role createRole() {
        return this.roleHome.createInstance();
    }

    @Override
    public void save(Role role) {
        this.roleHome.setInstance(role);
        this.roleHome.persist();
    }

    @Override
    public void update(Role role) {
        this.roleHome.setInstance(role);
        this.roleHome.update();
    }

    @Override
    public void delete(Role role) {
        this.roleHome.setInstance(role);
        this.roleHome.remove();
    }

    @Override
    public Collection<Role> listRoles(String search) {
        Session session = (Session) this.roleHome.getEntityManager().getDelegate();
        Criteria crit = session.createCriteria(Role.class);
        
        if(!search.isEmpty()){
            crit.add(Restrictions.like("name", search));
        }
        
        return crit.list();
    }

}
