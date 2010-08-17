/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.timo.personnel.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import org.timo.personnel.model.Role;
import org.timo.personnel.service.RoleService;
import org.timo.personnel.util.TableModel;
import org.timo.personnel.view.RoleListView;

/**
 *
 * @author timoteo
 */
public class RoleListController implements ActionListener{

    private final RoleListView roleListView;

    private final RoleService roleService;

    public RoleListController(RoleListView roleList, RoleService roleService) {
        this.roleListView = roleList;
        this.roleService = roleService;
    }

    public void init(){        
        this.roleListView.addActionListener(this);
        reloadList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String command = e.getActionCommand();

        if("create_role".equals(command)){
            System.out.println("Create role");
        }
    }

    private void reloadList() {        
        final Collection<Role> roleList = roleService.listRoles(roleListView.getFilterInput().getText());
        roleListView.setRoleList(roleList);
        roleListView.refresh();
    }

}
