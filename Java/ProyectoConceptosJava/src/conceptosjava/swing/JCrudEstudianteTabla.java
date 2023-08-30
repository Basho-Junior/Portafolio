/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.swing;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vacax
 */
public class JCrudEstudianteTabla extends javax.swing.JFrame {

    //Propiedades.
    AbstractTableModel modeloTabla;
    List<Estudiante> lista = new ArrayList<>();

    /**
     * Creates new form JCrudEstudianteTabla
     */
    public JCrudEstudianteTabla() {
        initComponents();
        init();
    }

    private void init() {
        //instanciar el modelo de tabla.
        modeloTabla = new AbstractTableModel() {
            //puedo trabajarlo fuera...
            String[] nombreColumnas = {"Matricula", "Nombre", "Carrera"};

            @Override
            public int getRowCount() {
                return lista.size();
            }

            @Override
            public int getColumnCount() {
                return nombreColumnas.length;
            }

            @Override
            public String getColumnName(int column) {
                return nombreColumnas[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getMatricula();
                    case 1:
                        return lista.get(rowIndex).getNombre();
                    case 2:
                        return lista.get(rowIndex).getCarrera();
                    default:
                        break;
                }
                return null;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false; // si cambio a true permite editar.
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        lista.get(rowIndex).setMatricula((Integer) aValue);
                        break;
                    case 1:
                        lista.get(rowIndex).setNombre((String) aValue);
                        break;
                    case 2:
                        lista.get(rowIndex).setCarrera((String) aValue);
                    default:
                        break;
                }
            }

        };
        //indicando las propiedades a la tabla.
        tabla.setModel(modeloTabla);
        //cambiando el modelo de selección.
        tabla.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //subscribiendo al evento de selección.
        tabla.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if (lse.getValueIsAdjusting()) {
                System.out.println("Evento -> Valor seleccionado en tabla: " + lse.getFirstIndex());
                //indicando la fila seleccionada.
                int fila = tabla.getSelectedRow();
                habilitarBotones(fila >= 0);                
            }
        });
        //agregar estudiantes...
        lista.add(new Estudiante(20011136, "Carlos Camacho", "ITT"));
    }
    
    /**
     * Habilitar los botones
     * @param habilitar 
     */
    private void habilitarBotones(boolean habilitar){
        btnEditar.setEnabled(habilitar);
        btnBorrar.setEnabled(habilitar);
    }
    
    /**
     * Permite buscar un estudiante
     * @param matricula
     * @return 
     */
    private Estudiante buscarEstudiante(int matricula){        
        for(Estudiante e : lista){
            if(e.getMatricula() == matricula){
                return e;                
            }
        }
        return null;
    }
    
    /**
     * Eliminar un estudiante de la lista
     * @param matricula
     * @return 
     */
    private boolean eliminarEstudiante(int matricula){
        Estudiante es = buscarEstudiante(matricula);
        if(es!=null){
            boolean ok = lista.remove(es);
            modeloTabla.fireTableDataChanged();
            return ok            ;
        }
        return false;
    }
    
    /**
     * Eliminando la fila de la tabla.
     */
    private void eliminarFilaTabla(){
        //selecciono el fila.
        int fila = tabla.getSelectedRow();
        eliminarEstudiante(lista.get(fila).getMatricula());
    }
    
    public void crearEditarEstudiante(Estudiante estudiante){
        System.out.println("Creando o editando...");
        Estudiante temp = buscarEstudiante(estudiante.getMatricula());
        if(temp!=null){
            System.out.println("Estoy actualizando....");
        }
        lista.add(estudiante);
        //actualizando
        modeloTabla.fireTableDataChanged();
        //pruebaPintado();
    }
    
    private void abrirVentanaEstudiante(){
        //instanciando la ventana.
        JEstudianteForm estudianteForm = new JEstudianteForm(this, true);
        estudianteForm.addJCrudEstudianteTabla(this);
        estudianteForm.setVisible(true);
    }

    /**
     * Clase para encapsular la información mostrada en la tabla. Puede venir de
     * la base de datos, o archivo.
     */
    static class Estudiante {

        private int matricula;
        private String nombre;
        private String carrera;

        Estudiante(){
            
        }
        
        public Estudiante(int matricula, String nombre, String carrera) {
            this.matricula = matricula;
            this.nombre = nombre;
            this.carrera = carrera;
        }

        public int getMatricula() {
            return matricula;
        }

        public void setMatricula(int matricula) {
            this.matricula = matricula;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCarrera() {
            return carrera;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }
    }

    private void pruebaPintado() {
        // TODO add your handling code here:
        System.out.println("Creando un nuevo estudiante");
        lista.add(new Estudiante(20011136, "Otro Esdtudiante", "ITT"));
        System.out.println("Cantidad de elementos: " + lista.size());
        //actualizando
        modeloTabla.fireTableDataChanged();
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
        tfBuscar = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar:");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);

        btnBorrar.setText("Borrar");
        btnBorrar.setEnabled(false);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBorrar, btnEditar, btnNuevo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //pruebaPintado();
        abrirVentanaEstudiante();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminarFilaTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(JCrudEstudianteTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCrudEstudianteTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCrudEstudianteTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCrudEstudianteTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCrudEstudianteTabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}

class OtroClase{
    
}