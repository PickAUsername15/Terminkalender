/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TerminkalenderGUI extends javax.swing.JFrame
{

    /**
     * Creates new form TerminkalenderGUI
     */
    public TerminkalenderGUI()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pm = new javax.swing.JPopupMenu();
        muTermine = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miDel = new javax.swing.JMenuItem();
        miChange = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        liDisplay = new javax.swing.JList<>();

        muTermine.setText("Termine");

        miAdd.setText("hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miAddActionPerformed(evt);
            }
        });
        muTermine.add(miAdd);

        miDel.setText("löschen");
        miDel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miDelActionPerformed(evt);
            }
        });
        muTermine.add(miDel);

        miChange.setText("ändern");
        miChange.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miChangeActionPerformed(evt);
            }
        });
        muTermine.add(miChange);

        pm.add(muTermine);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Termin-Kalender");

        liDisplay.setBorder(javax.swing.BorderFactory.createTitledBorder("Termine"));
        liDisplay.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        liDisplay.setComponentPopupMenu(pm);
        jScrollPane1.setViewportView(liDisplay);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miAddActionPerformed
    {//GEN-HEADEREND:event_miAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miAddActionPerformed

    private void miDelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miDelActionPerformed
    {//GEN-HEADEREND:event_miDelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miDelActionPerformed

    private void miChangeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miChangeActionPerformed
    {//GEN-HEADEREND:event_miChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miChangeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TerminkalenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TerminkalenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TerminkalenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TerminkalenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TerminkalenderGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> liDisplay;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miChange;
    private javax.swing.JMenuItem miDel;
    private javax.swing.JMenu muTermine;
    private javax.swing.JPopupMenu pm;
    // End of variables declaration//GEN-END:variables
}