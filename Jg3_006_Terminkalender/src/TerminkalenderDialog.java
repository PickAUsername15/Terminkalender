
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class TerminkalenderDialog extends javax.swing.JDialog {

    /**
     * Creates new form TerminkalenderDialog
     */
    private Appointment a = null;
    private boolean b = false;

    public TerminkalenderDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDay = new javax.swing.JLabel();
        tfDay = new javax.swing.JTextField();
        lbMonth = new javax.swing.JLabel();
        tfMonth = new javax.swing.JTextField();
        lbYear = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        lbHour = new javax.swing.JLabel();
        tfHour = new javax.swing.JTextField();
        lbMin = new javax.swing.JLabel();
        tfMin = new javax.swing.JTextField();
        lbText = new javax.swing.JLabel();
        tfText = new javax.swing.JTextField();
        btUebernehmen = new javax.swing.JButton();
        btAbbrechen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(7, 2));

        lbDay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDay.setText("Tag: ");
        getContentPane().add(lbDay);
        getContentPane().add(tfDay);

        lbMonth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMonth.setText("Monat: ");
        getContentPane().add(lbMonth);
        getContentPane().add(tfMonth);

        lbYear.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbYear.setText("Jahr: ");
        getContentPane().add(lbYear);
        getContentPane().add(tfYear);

        lbHour.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHour.setText("Stunde: ");
        getContentPane().add(lbHour);
        getContentPane().add(tfHour);

        lbMin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMin.setText("Minute: ");
        getContentPane().add(lbMin);
        getContentPane().add(tfMin);

        lbText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbText.setText("Text: ");
        getContentPane().add(lbText);
        getContentPane().add(tfText);

        btUebernehmen.setText("übernehmen");
        btUebernehmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUebernehmenActionPerformed(evt);
            }
        });
        getContentPane().add(btUebernehmen);

        btAbbrechen.setText("abbrechen");
        btAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbbrechenActionPerformed(evt);
            }
        });
        getContentPane().add(btAbbrechen);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btUebernehmenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btUebernehmenActionPerformed
    {//GEN-HEADEREND:event_btUebernehmenActionPerformed
        
        try{
            b = true;
            
            int day = Integer.parseInt(tfDay.getText());
            int month = Integer.parseInt(tfMonth.getText());
            int year = Integer.parseInt(tfYear.getText());
            int hour = Integer.parseInt(tfHour.getText());
            int minute = Integer.parseInt(tfMin.getText());
            String text = tfText.getText();
            
            if(day < 1 ||month < 1  || year < 1 ||hour < 0 || minute < 0)
                throw new Exception("Negative Werte sind nicht erlaubt");

            LocalDateTime ldt = LocalDateTime.of(year, month, day, hour, minute);
            a = new Appointment(text, ldt);
            this.dispose();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_btUebernehmenActionPerformed

    private void btAbbrechenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btAbbrechenActionPerformed
    {//GEN-HEADEREND:event_btAbbrechenActionPerformed
        b = false;
        this.dispose();
    }//GEN-LAST:event_btAbbrechenActionPerformed

    public void loadDatas(Appointment a)
    {
        tfDay.setText(""+a.getLdt().getDayOfMonth());
        tfHour.setText(""+a.getLdt().getHour());
        tfMin.setText(""+a.getLdt().getMinute());
        tfMonth.setText(""+a.getLdt().getMonth());
        tfText.setText(a.getText());
        tfYear.setText(""+a.getLdt().getYear());
    }
    public  boolean isOk(){
        return b;
    }
    
    public Appointment getAppointment(){
        return a;
    }
    
    
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
            java.util.logging.Logger.getLogger(TerminkalenderDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerminkalenderDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerminkalenderDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerminkalenderDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TerminkalenderDialog dialog = new TerminkalenderDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbbrechen;
    private javax.swing.JButton btUebernehmen;
    private javax.swing.JLabel lbDay;
    private javax.swing.JLabel lbHour;
    private javax.swing.JLabel lbMin;
    private javax.swing.JLabel lbMonth;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbYear;
    private javax.swing.JTextField tfDay;
    private javax.swing.JTextField tfHour;
    private javax.swing.JTextField tfMin;
    private javax.swing.JTextField tfMonth;
    private javax.swing.JTextField tfText;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}
