/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_edd;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import javax.swing.DefaultListModel;


/**
 *
 * @author simon
 */
public class VentanaM extends javax.swing.JFrame {
    private String newJsonFilePath;
    private Sucursal sucursal;
    private DFSClass dfsClass;
    private Lista sucursales = new Lista();
    private Grafo grafo;

    /**
     * Creates new form VentanaM
     */
    public VentanaM(String newJsonFilePath, int t) {
        this.newJsonFilePath = newJsonFilePath;
        this.sucursal = new Sucursal(null);
        this.sucursal.setT(t);
        this.dfsClass = new DFSClass(sucursal, 100);
        this.grafo = new Grafo();
        initComponents();
        textField2.setEditable(false);
        loadStations();
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
        jButton1 = new javax.swing.JButton();
        setT = new javax.swing.JButton();
        colocarSucursal = new javax.swing.JButton();
        searchDFS = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        displayGrafo = new javax.swing.JButton();
        tField = new javax.swing.JTextField();
        textField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        saveFile1 = new javax.swing.JButton();
        searchBFS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Go Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        setT.setText("Establecer t");
        setT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTActionPerformed(evt);
            }
        });
        jPanel1.add(setT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        colocarSucursal.setText("Colocar sucursal");
        colocarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colocarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(colocarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        searchDFS.setText("Ver cobertura sucursal (Busqueda a profundidad)");
        searchDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDFSActionPerformed(evt);
            }
        });
        jPanel1.add(searchDFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jButton5.setText("Revisar cobertura total");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jButton6.setText("Agregar Linea");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        displayGrafo.setText("Mostrar Grafo");
        displayGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayGrafoActionPerformed(evt);
            }
        });
        jPanel1.add(displayGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        tField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFieldActionPerformed(evt);
            }
        });
        jPanel1.add(tField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 50, -1));

        textField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField2ActionPerformed(evt);
            }
        });
        jPanel1.add(textField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 210, 210));

        saveFile1.setText("Guardar Archivo");
        saveFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFile1ActionPerformed(evt);
            }
        });
        jPanel1.add(saveFile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));

        searchBFS.setText("Ver cobertura sucursal (Busqueda en Amplitud)");
        jPanel1.add(searchBFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaP v1 = new VentanaP();
        this.dispose();
        v1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFieldActionPerformed
        
    }//GEN-LAST:event_tFieldActionPerformed

    private void setTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTActionPerformed
         try {
        int t;
        if (tField.getText().isEmpty()) {
            if (sucursal != null) {
                t = sucursal.getT();
                System.out.println("Variable t predeterminada: " + t);
            } else {
                System.out.println("La sucursal no esta seleccionada");
            }
        } else {
            t = Integer.parseInt(tField.getText());
            if (sucursal != null) {
                sucursal.setT(t);
                System.out.println("t: " + t);
            } else {
                System.out.println("La sucursal no esta seleccionada");
            }
        }
    } catch (NumberFormatException e) {
        System.out.println("Error. Ingrese un numero entero.");
    }
    }//GEN-LAST:event_setTActionPerformed

    private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField2ActionPerformed
            
    }//GEN-LAST:event_textField2ActionPerformed

    private void colocarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colocarSucursalActionPerformed
        String station = jList1.getSelectedValue();
        if (station != null){
            Sucursal newSucursal = new Sucursal(station);
            sucursales.add(newSucursal);
            textField2.setText(newSucursal.getStation().toString());
        }else{
            textField2.setText("No se ha seleccionado una parada");
        }
    }//GEN-LAST:event_colocarSucursalActionPerformed

    private void saveFile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFile1ActionPerformed
         
    }//GEN-LAST:event_saveFile1ActionPerformed

    private void searchDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDFSActionPerformed
        if (sucursal != null) {
            int limit = Integer.parseInt(tField.getText());
            int reachableStations = dfsClass.dfs(limit);
            textField2.setText("Paradas alcanzables: " + reachableStations);
        } else {
            textField2.setText("No se ha colocado la sucursal.");
        }
    }//GEN-LAST:event_searchDFSActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void displayGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayGrafoActionPerformed
        grafo = new Grafo();
        Lista stations = sucursal.getStations();
        Lista connections = sucursal.getConnections();
        for (int i = 0; i < stations.size(); i++) {
            grafo.addStation(stations.get(i).toString());
        }
        for (int i = 0; i < connections.size(); i++) {
            String[] connection = (String[]) connections.get(i);
            grafo.addConnection(connection[0], connection[1]);
        }
        grafo.display();
    }//GEN-LAST:event_displayGrafoActionPerformed

    private void loadStations() {
        if (newJsonFilePath != null) {
            try {
                File jsonFile = new File(newJsonFilePath);
                Json jsonReader = new Json(jsonFile);
                JsonObject jsonObject = jsonReader.readJson();
                DefaultListModel<String> listModel = new DefaultListModel<>();
                String cityKey = jsonObject.keySet().iterator().next();
                JsonArray metroLines = jsonObject.getAsJsonArray(cityKey);
                for (int i = 0; i < metroLines.size(); i++) {
                    JsonObject line = metroLines.get(i).getAsJsonObject();
                    for (String key : line.keySet()) {
                        JsonArray stations = line.getAsJsonArray(key);
                        for (int j = 0; j < stations.size(); j++) {
                            if (stations.get(j).isJsonObject()) {
                                JsonObject stationObject = stations.get(j).getAsJsonObject();
                                for (String stationName : stationObject.keySet()) {
                                    listModel.addElement(stationName + " - " + stationObject.get(stationName).getAsString());
                                }
                            } else {
                                listModel.addElement(stations.get(j).getAsString());
                            }
                        }
                    }
                }
                jList1.setModel(listModel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
            java.util.logging.Logger.getLogger(VentanaM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String newJsonFilePath = "";
                int t = 0;
                new VentanaM(newJsonFilePath, t).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colocarSucursal;
    private javax.swing.JButton displayGrafo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveFile1;
    private javax.swing.JButton searchBFS;
    private javax.swing.JButton searchDFS;
    private javax.swing.JButton setT;
    private javax.swing.JTextField tField;
    private javax.swing.JTextField textField2;
    // End of variables declaration//GEN-END:variables
}
