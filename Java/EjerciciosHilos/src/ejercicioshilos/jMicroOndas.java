/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioshilos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;


/**
 *
 * @author Junior
 */

public class jMicroOndas extends javax.swing.JFrame implements ActionListener {

    static int minutos, segundos;
    static boolean Iniciar = true, Proceso = false, detener = false;

    public jMicroOndas() {
        initComponents();
        init();
        setLocationRelativeTo(null);
        btnInicio.addActionListener(this);
        btnStop.addActionListener(this);
    }

    public static int getMinutos() {
        return minutos;
    }

    public static void setMinutos(int minutos) {
        jMicroOndas.minutos = minutos;
    }

    public static int getSegundos() {
        return segundos;
    }

    public static void setSegundos(int segundos) {
        jMicroOndas.segundos = segundos;
    }

    public void Tiempo(int tiempo) {
        if (tiempo > 59) {
            minutos = 0;
            tiempo = 0;
            jReloj.setForeground(Color.BLACK);
        }
        if (tiempo > 9) {
            jReloj.setText(Integer.toString(tiempo) + ":00");
        } else {
            jReloj.setText("0" + Integer.toString(tiempo) + ":00");
        }
    }
    
    public void init() {

        ActionListener seleccionarTiempo = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jReloj.getText().equals("00:00") && e.getSource() == btnStop) {
                    if (btnInicio.isEnabled() == true && Proceso == false) {
                        Pantalla.setBackground(Color.BLACK);
                    }
                } else if (!jReloj.getText().equals("00:00") && e.getSource() == btnStop) {
                    if (btnInicio.isEnabled() == true && !jReloj.getText().equals("00:00") 
                            && e.getActionCommand().equalsIgnoreCase("Stop")) {
                        Pantalla.setBackground(Color.BLACK);
                        minutos = 0;
                        segundos = 0;
                        Tiempo(minutos);
                    }
                }
                if (Proceso == false && e.getSource() == btnStop && !jReloj.getText().equals("00:00")) {
                    try {
                        btnStop.setText("Cancelar");
                        Thread.sleep(1);
                        Pantalla.setBackground(Color.BLUE);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(jMicroOndas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    btnInicio.setEnabled(true);
                }
                if (Proceso == false && e.getActionCommand().equalsIgnoreCase("Cancelar") && !jReloj.getText().equals("00:00") 
                        && btnInicio.isEnabled() == true) {
                    btnStop.setText("Stop");
                    minutos = 0;
                    segundos = 0;
                    Tiempo(minutos);
                    Iniciar = false;
                    Pantalla.setBackground(Color.black);
                }
                if (Proceso == true && e.getActionCommand().equalsIgnoreCase("Cancelar")) {
                    btnStop.setText("Stop");
                }
                if (jReloj.getText().equals("00:00") && btnInicio.isEnabled() == true) {
                    if (e.getSource() == btnUnmin) {
                        minutos = 1;
                        Tiempo(minutos);
                    }
                    if (e.getSource() == btnDosmin) {
                        minutos = 2;
                        Tiempo(minutos);
                    }
                    if (e.getSource() == btnCincomin) {
                        minutos = 5;
                        Tiempo(minutos);
                    }
                    if (e.getSource() == btnPizza) {
                        minutos = 12;
                        Tiempo(minutos);
                    }
                    if (e.getSource() == btnPopCorn) {
                        minutos = 7;
                        Tiempo(minutos);
                    }
                } else if (!jReloj.getText().equals("00:00") && btnInicio.isEnabled() == true) {
                    if (e.getSource() == btnUnmin) {
                        minutos += 1;
                        Tiempo(minutos);
                    }
                    if (e.getSource() == btnDosmin) {
                        minutos += 2;
                        Tiempo(minutos);
                    }
                    if (e.getSource() == btnCincomin) {
                        minutos += 5;
                        Tiempo(minutos);
                    }
                    if (e.getSource() == btnPizza) {
                        minutos += 12;
                        Tiempo(minutos);
                    }
                    if (e.getSource() == btnPopCorn) {
                        minutos += 7;
                        Tiempo(minutos);
                    }
                }


                if (!jReloj.getText().equals("00:00") && btnInicio.isEnabled() == false) {
                    if (e.getSource() == btnUnmin) {
                        minutos += 1;

                    }
                    if (e.getSource() == btnDosmin) {
                        minutos += 2;

                    }
                    if (e.getSource() == btnCincomin) {
                        minutos += 5;

                    }
                    if (e.getSource() == btnPizza) {
                        minutos += 12;

                    }
                    if (e.getSource() == btnPopCorn) {
                        minutos += 7;

                    }
                }

                if (e.getSource() == btnInicio && jReloj.getText().equals("00:00")) {
                    Proceso = false;
                    Iniciar = false;
                    Pantalla.setBackground(Color.black);
                }
                if (e.getSource() == btnInicio && !jReloj.getText().equals("00:00")) {
                    btnInicio.setEnabled(false);
                }
            }

        };

        btnUnmin.addActionListener(seleccionarTiempo);
        btnDosmin.addActionListener(seleccionarTiempo);
        btnCincomin.addActionListener(seleccionarTiempo);
        btnPizza.addActionListener(seleccionarTiempo);
        btnPopCorn.addActionListener(seleccionarTiempo);
        btnInicio.addActionListener(seleccionarTiempo);
        btnStop.addActionListener(seleccionarTiempo);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pantalla = new javax.swing.JLabel();
        jReloj = new javax.swing.JLabel();
        btnUnmin = new javax.swing.JButton();
        btnDosmin = new javax.swing.JButton();
        btnCincomin = new javax.swing.JButton();
        btnPizza = new javax.swing.JButton();
        btnPopCorn = new javax.swing.JButton();
        btnVerRecetas = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pantalla.setBackground(new java.awt.Color(0, 0, 0));
        Pantalla.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Pantalla.setForeground(new java.awt.Color(255, 255, 102));
        Pantalla.setText("Micro Ondas");
        Pantalla.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Pantalla.setOpaque(true);

        jReloj.setBackground(new java.awt.Color(0, 0, 0));
        jReloj.setFont(new java.awt.Font("Segoe UI", 1, 52)); // NOI18N
        jReloj.setForeground(new java.awt.Color(51, 255, 51));
        jReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jReloj.setText("00:00");
        jReloj.setOpaque(true);

        btnUnmin.setText("1 min");
        btnUnmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnminActionPerformed(evt);
            }
        });

        btnDosmin.setText("2 min");
        btnDosmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosminActionPerformed(evt);
            }
        });

        btnCincomin.setText("5 min");
        btnCincomin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincominActionPerformed(evt);
            }
        });

        btnPizza.setText("Pizza");
        btnPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPizzaActionPerformed(evt);
            }
        });

        btnPopCorn.setText("PopCorn");
        btnPopCorn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPopCornActionPerformed(evt);
            }
        });

        btnVerRecetas.setText("Ver Recetas");
        btnVerRecetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRecetasActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPizza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUnmin, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDosmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCincomin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVerRecetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPopCorn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUnmin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDosmin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCincomin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPizza)
                .addGap(18, 18, 18)
                .addComponent(btnPopCorn)
                .addGap(18, 18, 18)
                .addComponent(btnVerRecetas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(Pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnminActionPerformed

    private void btnDosminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDosminActionPerformed

    private void btnCincominActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincominActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCincominActionPerformed

    private void btnVerRecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRecetasActionPerformed
        // TODO add your handling code here:
        abrirPanelRecetas();
    }//GEN-LAST:event_btnVerRecetasActionPerformed

    private void btnPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPizzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPizzaActionPerformed

    private void btnPopCornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPopCornActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPopCornActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStopActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jMicroOndas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jMicroOndas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pantalla;
    private javax.swing.JButton btnCincomin;
    private javax.swing.JButton btnDosmin;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPizza;
    private javax.swing.JButton btnPopCorn;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnUnmin;
    private javax.swing.JButton btnVerRecetas;
    private javax.swing.JLabel jReloj;
    // End of variables declaration//GEN-END:variables

    private void iniciarReloj() {
        if (Iniciar == true) {
            claseContador reloj = new claseContador(jReloj, Pantalla, btnInicio);
            reloj.start();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnInicio) {
            if (Proceso == false) {
                Iniciar = true;
                Proceso = true;
                iniciarReloj();
                encender();
            }
        }
        if (e.getSource() == btnStop) {
            Proceso = false;
            Iniciar = false;
        }
    }

    private void encender() {

        Color color = Color.RED;

        if (Proceso == true) {
            Pantalla.setBackground(color);
        }
    }

    private void abrirPanelRecetas() {
        panelRecetas recetas = new panelRecetas(this, true);
        recetas.llamadaMicro(this);
        recetas.setVisible(true);
    }
}
