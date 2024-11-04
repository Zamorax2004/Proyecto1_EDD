/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_edd;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import javax.swing.DefaultListModel;
import org.graphstream.graph.Node;


/**
 *
 * @author simon
 */
//Ventana principal donde estan todas las funciones del programa
public class VentanaM extends javax.swing.JFrame {
    private String newJsonFilePath;
    private Sucursal sucursal;
    private Grafo grafo;
    private CustomList<Sucursal> sucursalList;
    private int sucursalCounter;

    /**
     * Creates new form VentanaM
     */
    public VentanaM(String newJsonFilePath, int t) {
        this.newJsonFilePath = newJsonFilePath;
        this.sucursal = new Sucursal(0, null);
        this.sucursal.setT(t);
        this.grafo = new Grafo();
        this.sucursalList = new CustomList<>();
        this.sucursalCounter = 1;
        initComponents();
        textField2.setEditable(false);
        vOnly.setEditable(false);
        loadStations();
        grafo.loadFromJSON(newJsonFilePath);
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
        displayGrafo = new javax.swing.JButton();
        tField = new javax.swing.JTextField();
        textField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        searchBFS = new javax.swing.JButton();
        saveFile = new javax.swing.JToggleButton();
        cTotal = new javax.swing.JToggleButton();
        vOnly = new javax.swing.JTextField();

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

        displayGrafo.setText("Mostrar Grafo");
        displayGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayGrafoActionPerformed(evt);
            }
        });
        jPanel1.add(displayGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

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

        searchBFS.setText("Ver cobertura sucursal (Busqueda en Amplitud)");
        searchBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBFSActionPerformed(evt);
            }
        });
        jPanel1.add(searchBFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        saveFile.setText("Guardar Archivo*");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jPanel1.add(saveFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));

        cTotal.setText("Revisar Cobertura total*");
        cTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTotalActionPerformed(evt);
            }
        });
        jPanel1.add(cTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        vOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vOnlyActionPerformed(evt);
            }
        });
        jPanel1.add(vOnly, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 320, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Boton para retroceder a la ventana anterior
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaP v1 = new VentanaP();
        this.dispose();
        v1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    //Boton para introducirvariable "t"
    private void tFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFieldActionPerformed
        
    }//GEN-LAST:event_tFieldActionPerformed
    //Boton para confirmar variable "t"
    private void setTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTActionPerformed
        try {
            int t;
            if (tField.getText().isEmpty()) {
                t = sucursal.getT();
                vOnly.setText("t: " + String.valueOf(t));
                System.out.println("Variable t predeterminada: " + t);
            }else {
                t = Integer.parseInt(tField.getText());
                if (sucursal != null){
                    sucursal.setT(t);
                    vOnly.setText("t: " + t);
                }else{
                    vOnly.setText("La sucursal no esta seleccionada.");
                }
            }
        }catch (NumberFormatException e){
            vOnly.setText("Ingrese un numero entero.");
        }
    }//GEN-LAST:event_setTActionPerformed
    //Boton para mostrar sucursales y acciones relacionadas
    private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField2ActionPerformed
            
    }//GEN-LAST:event_textField2ActionPerformed
    //Boton para confirmar sucursal seleccionada y añadirla a una lista o removerla
    private void colocarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colocarSucursalActionPerformed
        Object selectedStation = jList1.getSelectedValue();
        if (selectedStation != null) {
            boolean alreadyExists = false;
            for (Sucursal s : sucursalList) {
                if (s.getStation().equals(selectedStation)) {
                    alreadyExists = true;
                    sucursalList.remove(s);
                    textField2.setText("");
                    vOnly.setText("Estación removida: " + selectedStation.toString());
                    break;
                }
            }
            if (!alreadyExists) {
                Sucursal newSucursal = new Sucursal(sucursalCounter, selectedStation);
                sucursalList.add(newSucursal);
                sucursalCounter++;
                textField2.setText(selectedStation.toString());
                vOnly.setText("Estación añadida: " + selectedStation.toString());
            }
        } else {
            vOnly.setText("Seleccione una estación de la lista.");
        }
    }//GEN-LAST:event_colocarSucursalActionPerformed
    //Boton de Busqueda en Profundidad
    private void searchDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDFSActionPerformed
        Object selectedStation = jList1.getSelectedValue();
        if (selectedStation != null && selectedStation instanceof String) {
            String selectedStationStr = (String) selectedStation;
            String[] parts = selectedStationStr.split(": ");
            String stationId = parts.length > 1 ? parts[1] : parts[0];
            boolean isValidSucursal = false;
            for (Sucursal s : sucursalList) {
                if (s.getStation().equals(selectedStationStr)) {
                    isValidSucursal = true;
                    break;
                }
            }
            if (isValidSucursal) {
                Node startNode = grafo.getGraph().getNode(stationId);
                if (startNode != null) {
                    int maxIterations = sucursal.getT();
                    DFS dfs = new DFS(maxIterations, grafo);
                    dfs.search(startNode);
                    CustomSet<String> reachableStations = dfs.getReachableStations();
                    String[] reachableStationsArray = reachableStations.toArray();
                    vOnly.setText("Estaciones alcanzables: " + String.join(", ", reachableStationsArray));
                } else {
                    vOnly.setText("Nodo para: " + stationId + " no encontrado.");
                }
            } else {
                vOnly.setText("Sucursal no valida.");
            }
        } else {
            vOnly.setText("Seleccione una sucursal.");
        }
    }//GEN-LAST:event_searchDFSActionPerformed
    //Boton que muestra el grafo 
    private void displayGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayGrafoActionPerformed
        for (Sucursal sucursal : sucursalList) {
            Object station = sucursal.getStation();
            String[] stationParts = station.toString().split(": ");
            String stationId = stationParts.length > 1 ? stationParts[1] : stationParts[0];
            Node node = grafo.getGraph().getNode(stationId);
            if (node != null) {
                Object posObject = node.getAttribute("xyz");
                if (posObject instanceof Object[]) {
                    Object[] posArray = (Object[]) posObject;
                    if (posArray.length == 3) {
                        try {
                            double x = Double.parseDouble(posArray[0].toString());
                            double y = Double.parseDouble(posArray[1].toString());
                            double z = Double.parseDouble(posArray[2].toString());
                            String newNodeId = stationId + "_sucursal";
                            if (grafo.getGraph().getNode(newNodeId) == null) {
                                Node newNode = grafo.getGraph().addNode(newNodeId);
                                newNode.setAttribute("ui.label", newNodeId);
                                newNode.setAttribute("xyz", x + 0.1, y + 0.1, z + 0.1);
                                newNode.setAttribute("ui.style", "fill-color: black;");
                                System.out.println("Nodo " + newNodeId + " creado en la posicion: " + x + ", " + y + ", " + z);
                                String edgeId = stationId + "_to_" + newNodeId;
                                grafo.getGraph().addEdge(edgeId, stationId, newNodeId);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error de parseDouble.");
                        }
                    } else {
                        System.out.println("Attr posicion Nodo no tiene 3 elementos exactos.");
                    }
                } else {
                    System.out.println("Attr posicion Nodo no es de tipo Objeto[].");
                }
            } else {
                System.out.println("Nodo para estacion " + stationId + " no encontrado.");
            }
        }
        grafo.display();
    }//GEN-LAST:event_displayGrafoActionPerformed
    //Boton de Busqueda en Amplitud
    private void searchBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBFSActionPerformed
        Object selectedStation = jList1.getSelectedValue();
        if (selectedStation != null && selectedStation instanceof String) {
            String selectedStationStr = (String) selectedStation;
            String[] parts = selectedStationStr.split(": ");
            String stationId = parts.length > 1 ? parts[1] : parts[0];
            boolean isValidSucursal = false;
            for (Sucursal s : sucursalList) {
                if (s.getStation().equals(selectedStationStr)) {
                    isValidSucursal = true;
                    break;
                }
            }
            if (isValidSucursal) {
                Node startNode = grafo.getGraph().getNode(stationId);
                if (startNode != null) {
                    int maxIterations = sucursal.getT();
                    BFS bfs = new BFS(maxIterations);
                    bfs.search(grafo, startNode);
                    CustomSet<String> reachableStations = bfs.getReachableStations();
                    String[] reachableStationsArray = reachableStations.toArray();
                    vOnly.setText("Estaciones alcanzables: " + String.join(", ", reachableStationsArray));
                } else {
                    vOnly.setText("Nodo para: " + stationId + " no encontrado.");
                }
            } else {
                vOnly.setText("Sucursal no valida.");
            }
        } else {
            vOnly.setText("Seleccione una sucursal!");
        }
    }//GEN-LAST:event_searchBFSActionPerformed

    private void vOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vOnlyActionPerformed
        
    }//GEN-LAST:event_vOnlyActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFileActionPerformed

    private void cTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTotalActionPerformed
        if (sucursalList.isEmpty()) {
            vOnly.setText("No hay sucursales seleccionadas.");
            return;
        }
        CustomSet<String> allNodes = new CustomSet<>(grafo.getAdjacencyList().keySet());
        CustomSet<String> reachableNodes = new CustomSet<>();
        CustomSet<String> markedNodes = new CustomSet<>();
        for (Sucursal sucursal : sucursalList) {
            Object station = sucursal.getStation();
            String[] stationParts = station.toString().split(": ");
            String stationId = stationParts.length > 1 ? stationParts[1] : stationParts[0];
            Node startNode = grafo.getGraph().getNode(stationId);
            if (startNode != null) {
                int maxIterations = sucursal.getT();
                BFS bfs = new BFS(maxIterations);
                bfs.search(grafo, startNode);
                reachableNodes.addAll(bfs.getReachableStations());
                DFS dfs = new DFS(maxIterations, grafo);
                dfs.search(startNode);
                reachableNodes.addAll(dfs.getReachableStations());
            }
        }
        for (Node node : grafo.getGraph()) {
            if ("marked".equals(node.getAttribute("ui.class"))) {
                markedNodes.add(node.getId());
            }
        }
        if (reachableNodes.containsAll(allNodes) || markedNodes.containsAll(allNodes)) {
            vOnly.setText("Las sucursales cubren totalmente la ciudad.");
        } else {
            CustomSet<String> missingNodes = new CustomHashSet<>(allNodes);
            missingNodes.removeAll(reachableNodes);
            missingNodes.removeAll(markedNodes);
            String[] missingNodesArray = missingNodes.toArray();
            vOnly.setText("Estaciones necesarias: " + String.join(", ", missingNodesArray));
        }
    }//GEN-LAST:event_cTotalActionPerformed
    //Metodo para leer las paradas del json y cargarlas como objetos en una JList
    private void loadStations() {
        if (newJsonFilePath != null) {
            grafo.loadFromJSON(newJsonFilePath); // Utilize the Grafo's method to load the JSON file
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String station : grafo.getAdjacencyList().keySet()) {
                listModel.addElement(station);
                System.out.println("Estacion añadida: " + station);
            }
            jList1.setModel(listModel);
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
    private javax.swing.JToggleButton cTotal;
    private javax.swing.JButton colocarSucursal;
    private javax.swing.JButton displayGrafo;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton saveFile;
    private javax.swing.JButton searchBFS;
    private javax.swing.JButton searchDFS;
    private javax.swing.JButton setT;
    private javax.swing.JTextField tField;
    private javax.swing.JTextField textField2;
    private javax.swing.JTextField vOnly;
    // End of variables declaration//GEN-END:variables
}
