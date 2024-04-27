/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import javax.swing.JButton;

/**
 *
 * @author carlo
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
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

        jLabel1 = new javax.swing.JLabel();
        agregarSede = new javax.swing.JButton();
        agregarTramite = new javax.swing.JButton();
        listarTramitesDeSede = new javax.swing.JButton();
        listarSedesTramite = new javax.swing.JButton();
        modTram = new javax.swing.JButton();
        elimTram = new javax.swing.JButton();
        buscarRango = new javax.swing.JButton();
        expCsv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Menú");

        agregarSede.setText("1. Agregar Sede");
        agregarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarSedeActionPerformed(evt);
            }
        });

        agregarTramite.setText("2. AgregarTramite");

        listarTramitesDeSede.setText("3. Listar Tramites de una Sede");

        listarSedesTramite.setText("4. Listar Sedes con sus Tramites");

        modTram.setText("5. Modificar Tramite");

        elimTram.setText("6. Eliminar Tramite");

        buscarRango.setText("7. Tramites realizados en rango de tiempo");

        expCsv.setText("8. Exportar a un CSV");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(modTram)
                    .addComponent(elimTram)
                    .addComponent(buscarRango)
                    .addComponent(jLabel1)
                    .addComponent(agregarSede)
                    .addComponent(agregarTramite)
                    .addComponent(listarTramitesDeSede)
                    .addComponent(listarSedesTramite)
                    .addComponent(expCsv))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(agregarSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agregarTramite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listarTramitesDeSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listarSedesTramite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modTram)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(elimTram)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarRango)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(expCsv)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSedeActionPerformed

    }//GEN-LAST:event_agregarSedeActionPerformed

    public JButton getOpc1() {
        return agregarSede;
    }
    
    public JButton getOpc2() {
        return agregarTramite;
    }
    
    public JButton getOpc3() {
        return listarTramitesDeSede;
    }
    
    public JButton getOpc4() {
        return listarSedesTramite;
    }
    
    public JButton getOpc5() {
        return modTram;
    }
    
    public JButton getOpc6() {
        return elimTram;
    }
    
    public JButton getOpc7() {
        return buscarRango;
    }
    
    public JButton getOpc8(){
        return expCsv;
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarSede;
    private javax.swing.JButton agregarTramite;
    private javax.swing.JButton buscarRango;
    private javax.swing.JButton elimTram;
    private javax.swing.JButton expCsv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listarSedesTramite;
    private javax.swing.JButton listarTramitesDeSede;
    private javax.swing.JButton modTram;
    // End of variables declaration//GEN-END:variables
}
