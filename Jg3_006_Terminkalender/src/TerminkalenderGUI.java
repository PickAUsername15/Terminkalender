
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class TerminkalenderGUI extends javax.swing.JFrame {

    /**
     * Creates new form TerminkalenderGUI
     */
    public TerminkalenderGUI() {
        initComponents();

        try {
            bl.load(new File("./data.bin"));

        } catch (FileNotFoundException e) {
        } catch (EOFException ex) {

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "Exception: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        bl.addCols();
        taTable.setModel(bl);

        taTable.getTableHeader().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    pm.show(taTable.getTableHeader(), e.getX(), e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    AppointmentModell bl = new AppointmentModell();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pm = new javax.swing.JPopupMenu();
        muTermine = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miDel = new javax.swing.JMenuItem();
        miChange = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        taTable = new javax.swing.JTable();

        muTermine.setText("Termine");

        miAdd.setText("hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        muTermine.add(miAdd);

        miDel.setText("löschen");
        miDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDelActionPerformed(evt);
            }
        });
        muTermine.add(miDel);

        miChange.setText("ändern");
        miChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miChangeActionPerformed(evt);
            }
        });
        muTermine.add(miChange);

        pm.add(muTermine);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Termin-Kalender");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        taTable.setModel(new javax.swing.table.DefaultTableModel(
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
        taTable.setComponentPopupMenu(pm);
        taTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        taTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(taTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miAddActionPerformed
    {//GEN-HEADEREND:event_miAddActionPerformed
        TerminkalenderDialog dlg = new TerminkalenderDialog(this, true);

        dlg.setVisible(true);

        if (dlg.isOk()) {
            try {
                bl.add(dlg.getAppointment());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Exception: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_miAddActionPerformed

    private void miDelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miDelActionPerformed
    {//GEN-HEADEREND:event_miDelActionPerformed
        int[] idx = taTable.getSelectedRows();

        for (int i = idx.length - 1; i >= 0; i--) {
            bl.remove((Appointment) bl.getRowValue(idx[i]));
        }
    }//GEN-LAST:event_miDelActionPerformed

    private void miChangeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miChangeActionPerformed
    {//GEN-HEADEREND:event_miChangeActionPerformed
        TerminkalenderDialog dlg = new TerminkalenderDialog(this, true);

        try{
            if(taTable.getSelectedRow()>= 0)
            {
                dlg.setVisible(true);
                dlg.loadDatas((Appointment) bl.getRowValue(taTable.getSelectedRow()));

                if (dlg.isOk()) {
                     bl.remove((Appointment) bl.getRowValue(taTable.getSelectedRow()));
                    bl.add(dlg.getAppointment());
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Bitte wähle zuerst einen Termin aus");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_miChangeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            bl.save(new File("./data.bin"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Exception: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void taTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taTableMouseClicked
        System.out.println("sd");
    }//GEN-LAST:event_taTableMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TerminkalenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerminkalenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerminkalenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerminkalenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TerminkalenderGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miChange;
    private javax.swing.JMenuItem miDel;
    private javax.swing.JMenu muTermine;
    private javax.swing.JPopupMenu pm;
    private javax.swing.JTable taTable;
    // End of variables declaration//GEN-END:variables
}
