/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timo.personnel.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import org.timo.personnel.model.Role;
import org.timo.personnel.service.RoleService;
import org.timo.personnel.view.RoleListView;
import org.timo.personnel.view.dialog.RoleEditDialog;

/**
 *
 * @author timoteo
 */
public class RoleListController implements ActionListener,Observer {

    private final RoleListView roleListView;

    private final RoleService roleService;

    public RoleListController(RoleListView roleList, RoleService roleService) {
        this.roleListView = roleList;
        this.roleService = roleService;
    }

    public void init() {
        this.roleListView.addActionListener((ActionListener) this);
        reloadView();
    }

    private void reloadView() {
        final Collection<Role> roleList = roleService.listRoles(roleListView.
                getFilterInput().getText());
        roleListView.setRoleList(roleList);
        roleListView.refresh();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String command = e.getActionCommand();

        if ("create_role".equals(command)) {
            RoleEditDialog dialog = new RoleEditDialog(null, true);
            final RoleEditDialogController controller = new RoleEditDialogController(
                    roleService, dialog, new Role());            
            controller.init();
            controller.addObserver(this);            
            dialog.setVisible(true);            
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observable changed : "+o+","+arg);
        if("roles_changed".equals(arg)){
            reloadView();
        }
    }
}
