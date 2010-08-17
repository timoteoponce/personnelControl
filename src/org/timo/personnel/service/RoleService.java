/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.timo.personnel.service;

import java.util.Collection;
import org.timo.personnel.model.Role;

/**
 *
 * @author timoteo
 */
public interface RoleService extends Service{
    Role createRole();

    void save(Role role);

    void update(Role role);

    void delete(Role role);

    Collection<Role> listRoles(String search);
}
