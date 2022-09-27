/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.admin;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Sely
 */
public class JFMainPage extends javax.swing.JFrame {

    private JTabbedPane jtpRegisters = new JTabbedPane();
    private JPProductRegister jpProductRegister= new JPProductRegister();
    
    public JFMainPage() {
        initComponents();
        initMainPage();
    }
    
    private void initMainPage(){
        this.jTPMain.add("Registers",jtpRegisters);
        
        
        jtpRegisters.add("Products",jpProductRegister);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar = new javax.swing.JProgressBar();
        jTPMain = new javax.swing.JTabbedPane();
        jMBMain = new javax.swing.JMenuBar();
        jMNotifications = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin Console");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jTPMain.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jMNotifications.setText("Notifications");

        jMBMain.add(Box.createHorizontalGlue());

        jMBMain.add(jMNotifications);

        setJMenuBar(jMBMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
            .addComponent(jTPMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTPMain, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFMainPage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMBMain;
    private javax.swing.JMenu jMNotifications;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JTabbedPane jTPMain;
    // End of variables declaration//GEN-END:variables
}
