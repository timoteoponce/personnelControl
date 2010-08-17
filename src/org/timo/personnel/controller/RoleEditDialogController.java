/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timo.personnel.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import org.timo.personnel.model.Role;
import org.timo.personnel.service.RoleService;
import org.timo.personnel.view.dialog.RoleEditDialog;

/**
 *
 * @author timoteo
 */
public class RoleEditDialogController extends Observable implements
        ActionListener {

    private final RoleService roleService;

    private final RoleEditDialog editDialog;

    private final Role role;

    public RoleEditDialogController(RoleService roleService,
            RoleEditDialog editDialog, Role role) {
        this.roleService = roleService;
        this.editDialog = editDialog;
        this.role = role;
    }

    public void init() {
        this.editDialog.addActionListener(this);
        reloadView();
    }

    private void reloadView() {
        this.editDialog.setRole(role);
        this.editDialog.refresh();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String command = e.getActionCommand();

        if ("save".equals(command)) {
            role.setName(editDialog.getNameText().getText());
            role.setDescription(editDialog.getDescriptionText().getText());

            roleService.save(role);
            reloadView();
            setChanged();
            notifyObservers("roles_changed");
        } else if ("close".equals(command)) {
            closeDialog();
        }                
    }

    private void closeDialog() {
        this.editDialog.setVisible(false);
        this.editDialog.dispose();
    }
}
