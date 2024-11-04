/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_edd;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


/**
 *
 * @author simon
 */
//JFrame inicial con el proposito de elegir el archivo
public class VentanaP extends javax.swing.JFrame {
    private File selectedFile;
    private int t;
    /**
     * Creates new form MainV
     */
    public VentanaP() {
        initComponents();
        textField.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        openFileChooser = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        textField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Title.setText("Sucursales de Supermercado");
        jPanel1.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 470, -1));

        openFileChooser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        openFileChooser.setText("Escoger Archivo");
        openFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileChooserActionPerformed(evt);
            }
        });
        jPanel1.add(openFileChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        Next.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        jPanel1.add(Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 70, 40));

        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        jPanel1.add(textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Boton para escoger el archivo
    private void openFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileChooserActionPerformed
    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.setDialogTitle("Elige un archivo .json");
    FileNameExtensionFilter restrict = new FileNameExtensionFilter("Solo archivos .json", "json");
    fileChooser.addChoosableFileFilter(restrict);
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION){
        selectedFile = fileChooser.getSelectedFile();
        textField.setText(selectedFile.getName());
        String fileName = selectedFile.getName();
        if (fileName.equals("Caracas.json")){
            t = 3;
        }else if (fileName.equals("Bogota.json")){
            t = 10;
        }else{
            t = 0;
        }
    }else{
        System.out.println("Error");
    }
    }//GEN-LAST:event_openFileChooserActionPerformed
    
    
    //Boton para ir a la siguiente ventana
    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        if (selectedFile != null){
            VentanaM v2 = new VentanaM(getNewJsonFilePath(), t);
            this.dispose();
            v2.setVisible(true);
        }else{
            textField.setText("Seleccione un archivo!");
        }
    }//GEN-LAST:event_NextActionPerformed

    //Boton para mostrar texto
    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed

    }//GEN-LAST:event_textFieldActionPerformed
    
    //Obtiene el path del archivo seleccionado
    public String getNewJsonFilePath(){
        return new File(selectedFile.getParent(), selectedFile.getName()).getPath();
    }
    
    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(VentanaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Next;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openFileChooser;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}

