/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RoleList.java
 *
 * Created on 16-08-2010, 09:58:16 PM
 */
package org.timo.personnel.view;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.timo.personnel.controller.RoleListController;
import org.timo.personnel.model.Role;
import org.timo.personnel.model.dao.Home;
import org.timo.personnel.model.persistence.PersistenceUtil;
import org.timo.personnel.service.RoleService;
import org.timo.personnel.service.impl.RoleServiceImpl;
import org.timo.personnel.util.TableModel;

/**
 *
 * @author timoteo
 */
public class RoleListView extends javax.swing.JPanel {

    private Collection<Role> roleList;

    private final TableModel tableModel = new TableModel(new String[]{"ID","NAME","DESCRIPTION"}, (Collection)Collections.emptyList());

    /** Creates new form RoleList */
    public RoleListView() {
        initComponents();
        init();
    }

    private void init(){
        getDataTable().setModel(tableModel);
    }

    public JPanel getActionPanel() {
        return actionPanel;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JScrollPane getDataPanel() {
        return dataPanel;
    }

    public JTable getDataTable() {
        return dataTable;
    }

    public JTextField getFilterInput() {
        return filterInput;
    }

    public JLabel getFilterLabel() {
        return filterLabel;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public Collection<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Collection<Role> roleList) {
        this.roleList = roleList;
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actionPanel = new javax.swing.JPanel();
        filterLabel = new javax.swing.JLabel();
        filterInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        dataPanel = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        filterLabel.setText("Name:");

        searchButton.setText("Search");
        searchButton.setActionCommand("search");

        clearButton.setText("Clear");
        clearButton.setActionCommand("clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        createButton.setText("Create role");
        createButton.setActionCommand("create_role");

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createButton)
                    .addComponent(searchButton)
                    .addGroup(actionPanelLayout.createSequentialGroup()
                        .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterLabel)
                    .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataPanel.setViewportView(dataTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(actionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton createButton;
    private javax.swing.JScrollPane dataPanel;
    private javax.swing.JTable dataTable;
    private javax.swing.JTextField filterInput;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

    public void addActionListener(ActionListener listener) {
        getClearButton().addActionListener(listener);
        getCreateButton().addActionListener(listener);
        getFilterInput().addActionListener(listener);
        getSearchButton().addActionListener(listener);
    }

    public void refresh(){
        tableModel.clear();
        
        for(Role rol:roleList){
            tableModel.addRow(new Object[]{rol.getId(),rol.getName(),rol.getDescription()});
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("my frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        RoleService roleService = new RoleServiceImpl(new Home<Role>(Role.class, PersistenceUtil.getEntityManager()));
        RoleListView view = new RoleListView();
        RoleListController controller = new RoleListController(view, roleService);
        controller.init();

        frame.getContentPane().add(view);
        frame.setVisible(true);
    }
}
