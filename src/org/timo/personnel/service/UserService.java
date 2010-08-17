/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.timo.personnel.service;

import java.util.Collection;
import org.timo.personnel.model.Role;
import org.timo.personnel.model.User;

/**
 *
 * @author timoteo
 */
public interface UserService extends Service{

    User createUser();

    void save(User user);

    void update(User user);

    void delete(User user);

    Collection<Role> listRoles();

}
