/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.admin;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import lychee.kulfi.admin.ejb.ProductRegisterEJBRemote;
import lychee.kulfi.admin.pojo.ProductPojo;
import lychee.kulfi.admin.pojo.PropertyPojo;

/**
 *
 * @author Sely
 */
public class JPProductRegister extends javax.swing.JPanel {

    @EJB
    private ProductRegisterEJBRemote productRegisterEJB;
    private List<ProductPojo> productList = new ArrayList();
    private List<PropertyPojo> propertyList = new ArrayList();
    private DefaultTreeModel dtm = new DefaultTreeModel(new DefaultMutableTreeNode("Empty"));

    public JPProductRegister() {
        initComponents();

        initProductRegister();
    }

    private void initProductRegister() {        
        showProductOnTree();
        getPropertyListOnCombo();
    }

    private void showProductOnTree() {
        try {
            productList = productRegisterEJB.getAllProductsOrderByName();

            DefaultMutableTreeNode group = new DefaultMutableTreeNode("Group");
            dtm.insertNodeInto(group, (MutableTreeNode) dtm.getRoot(), 0);

            for (ProductPojo product : productList) {
                dtm.insertNodeInto(new DefaultMutableTreeNode(product), (MutableTreeNode) group, 0);
            }
            /*            
             dtm.insertNodeInto(new DefaultMutableTreeNode("Root1?"), (MutableTreeNode) d, 0);
             dtm.insertNodeInto(new DefaultMutableTreeNode("Root2?"), (MutableTreeNode) d, 0);
             dtm.insertNodeInto(new DefaultMutableTreeNode("Root3?"), (MutableTreeNode) d, 0);
             */
            jTreeProduct.expandRow(0);
            jTreeProduct.setRootVisible(false);

        } catch (Exception e) {
        }
    }
    
    private void getPropertyListOnCombo(){
        try{
            jCBProperty.removeAllItems();
            System.out.println("hello");
            propertyList = productRegisterEJB.getAllPropertiesOrderByName();
            for (PropertyPojo propertyPojo : propertyList) {
                jCBProperty.addItem(propertyPojo.getPropertyName());
            }
            System.out.println("hello2");
        }catch(Exception e){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSPTreeProduct = new javax.swing.JScrollPane();
        jTreeProduct = new javax.swing.JTree();
        jTFSearch = new javax.swing.JTextField();
        jBSearch = new javax.swing.JButton();
        jTFProductName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBRemove = new javax.swing.JButton();
        jBClear = new javax.swing.JButton();
        jBSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProperty = new javax.swing.JTable();
        jCBProperty = new javax.swing.JComboBox();

        jTreeProduct.setModel(dtm);
        jSPTreeProduct.setViewportView(jTreeProduct);

        jTFSearch.setText("Search for Product");

        jBSearch.setText("Search");

        jLabel1.setText("Product");

        jBRemove.setText("Remove");

        jBClear.setText("Clear");

        jBSave.setText("Save");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        jTProperty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProperty.setColumnSelectionAllowed(true);
        jTProperty.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTProperty);
        jTProperty.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTProperty.getColumnModel().getColumn(0).setResizable(false);

        jCBProperty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item1", "Item2", "Item3", "Zebra" }));
        jCBProperty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCBPropertyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jBClear, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSPTreeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFProductName))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                            .addComponent(jCBProperty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSPTreeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCBPropertyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCBPropertyKeyReleased
        if(evt.getKeyCode()==10){
            
        }else if(evt.getKeyCode()==113){
            JFPropertyRegister jfProperty = new JFPropertyRegister();
            jfProperty.setVisible(true);
        } 
    }//GEN-LAST:event_jCBPropertyKeyReleased

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        
    }//GEN-LAST:event_jBSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBClear;
    private javax.swing.JButton jBRemove;
    private javax.swing.JButton jBSave;
    private javax.swing.JButton jBSearch;
    private javax.swing.JComboBox jCBProperty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jSPTreeProduct;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFProductName;
    private javax.swing.JTextField jTFSearch;
    private javax.swing.JTable jTProperty;
    private javax.swing.JTree jTreeProduct;
    // End of variables declaration//GEN-END:variables
}
