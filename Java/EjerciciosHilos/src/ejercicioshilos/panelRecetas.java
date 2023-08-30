/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioshilos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Junior
 */

public class panelRecetas extends javax.swing.JDialog {

    AbstractTableModel modelodeTabla;
    List<Recetas> listadeReccetas = new ArrayList<>();

    private int borrado;
    private boolean existente = false;

    static boolean puedeEditar = false;
    static int filaEdit;
    static int minEdit;
    static String nom = null;

    private jMicroOndas micro;
    private String ENLACE = "Recetas.dat";
    private Recetas recetaAgregada;
    
    public panelRecetas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    static class Recetas implements Serializable {

        private String nombre;
        private int minutos;

        Recetas() {
        }

        public Recetas(String nombre, int minutos) {
            this.nombre = nombre;
            this.minutos = minutos;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getMinutos() {
            return minutos;
        }

        public void setMinutos(int minutos) {
            this.minutos = minutos;
        }

    }

    public void init() {
        ActionListener a1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnEditar) {
                    if (jTablaRecetas.getSelectedRowCount() > 0) {
                        puedeEditar = true;
                        setFila(jTablaRecetas.getSelectedRow());
                        nom = listadeReccetas.get(getFila()).getNombre();
                        minEdit = listadeReccetas.get(getFila()).getMinutos();
                        editar();
                    }
                }
            }
        };
        btnEditar.addActionListener(a1);
        modelodeTabla = new AbstractTableModel() {
            String[] nombresColumnas = {"Nombre", "Tiempo"};

            @Override
            public int getRowCount() {
                return listadeReccetas.size();
            }

            @Override
            public int getColumnCount() {
                return nombresColumnas.length;
            }

            @Override
            public String getColumnName(int column) {
                return nombresColumnas[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return listadeReccetas.get(rowIndex).getNombre();
                    case 1:
                        return listadeReccetas.get(rowIndex).minutos;
                    default:
                        break;
                }
                return null;
            }

        };
        jTablaRecetas.setModel(modelodeTabla);
        jTablaRecetas.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTablaRecetas.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if (lse.getValueIsAdjusting()) {
                int fila = jTablaRecetas.getSelectedRow();
                habilitarBotones(fila >= 0);
            }
        });
        try {
            abrirArchivo();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(panelRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void habilitarBotones(boolean habilitar) {
        btnEditar.setEnabled(habilitar);
        btnEliminar.setEnabled(habilitar);
    }

    private void abrirArchivo() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ENLACE))) {
            List<Recetas> listaArchivo = (List<Recetas>) objectInputStream.readObject();
            for (Recetas e : listaArchivo) {
                System.out.println("La receta recuperada: " + e.getNombre());
                listadeReccetas.add(e);
            }
        }
    }

    private void guardarArchivo() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(ENLACE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(panelRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            objectOutputStream.writeObject(listadeReccetas);
        } catch (IOException ex) {
            Logger.getLogger(panelRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
        objectOutputStream.close();
    }

    public void abrirPanel() {
        Frame VerRecetas = null;
        agregarReceta pa = new agregarReceta(VerRecetas, true);
        pa.addReceta(this, jTablaRecetas);
        pa.setVisible(true);
    }
    

    private Recetas buscarReceta(String nombre) {
        for (Recetas r : listadeReccetas) {
            if (r.getNombre().equals(nombre)) {
                return r;
            }
        }
        return null;
    }

    private boolean eliminarReceta(String nombre) {
        Recetas r = buscarReceta(nombre);
        if (r != null) {
            boolean ok = listadeReccetas.remove(r);
            modelodeTabla.fireTableDataChanged();
            return ok;

        }
        return false;
    }
    
    private void eliminarFila() {
        int fila = jTablaRecetas.getSelectedRow();
        setFila(fila);
        eliminarReceta(listadeReccetas.get(fila).getNombre());
        try {
            guardarArchivo();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(panelRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getFila() {
        return borrado;
    }

    public void setFila(int fila) {
        this.borrado = fila;
    }

    public void ProcesoReceta(Recetas Receta) {
        boolean temp = buscaReceta(Receta);
        if (!temp && existente == true) {
            Actualizacion(Receta);
        } else {
            listadeReccetas.add(Receta);
        }
        modelodeTabla.fireTableDataChanged();
        try {

            guardarArchivo();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(panelRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar() {
        Frame VerRecetas = null;
        editarReceta edit = new editarReceta(VerRecetas, true);
        edit.Llamada(this);
        edit.setVisible(true);
    }

    public void Actualizacion(Recetas receta) {
        this.recetaAgregada = receta;

        if (puedeEditar) {
            System.out.println("Editando desde Actualizacion... en la fila " + getFila());
            System.out.println("Receta: " + receta.getNombre() + " " + receta.getMinutos());
            if (!buscaReceta(receta)) {
                listadeReccetas.get(getFila()).setNombre(receta.getNombre());
                listadeReccetas.get(getFila()).setMinutos(receta.getMinutos());
                modelodeTabla.fireTableDataChanged();
                puedeEditar = false;

                try {
                    guardarArchivo();
                } catch (IOException ex) {
                    Logger.getLogger(panelRecetas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelRecetas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (buscaReceta(receta)) {
                JOptionPane.showMessageDialog(null, "ERROR: RECETA EXISTENTE");
            }

        }

        for (int i = 0; i < listadeReccetas.size(); i++) {
            if (listadeReccetas.get(i).getNombre().equals(receta.getNombre())) {
                listadeReccetas.get(i).setMinutos(receta.getMinutos());
            }
        }

        try {
            guardarArchivo();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(panelRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean buscaReceta(Recetas e) {
        int i = 0;
        for (i = 0; i < listadeReccetas.size(); i++) {
            if (listadeReccetas.get(i).getNombre().equals(e.getNombre()) && listadeReccetas.get(i).getMinutos() == e.getMinutos()) {
                return true;
            } else if (listadeReccetas.get(i).getNombre().equals(e.getNombre())) {
                existente = true;
            }
        }

        return false;
    }

    public void llamadaMicro(jMicroOndas Micro) {
        this.micro = Micro;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCargar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaRecetas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jTablaRecetas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaRecetas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(179, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        abrirPanel();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarFila();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        int fila = jTablaRecetas.getSelectedRow();
        int tiempo = listadeReccetas.get(fila).getMinutos();
        micro.setMinutos(tiempo);
        micro.Tiempo(tiempo);
    }//GEN-LAST:event_btnCargarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(panelRecetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelRecetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelRecetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelRecetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                panelRecetas dialog = new panelRecetas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaRecetas;
    // End of variables declaration//GEN-END:variables

}
