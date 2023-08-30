/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clonewhatsapp;

import clonewhatsapp.Clases.IObserver;
import clonewhatsapp.Clases.ManejoComunicacion;
import com.google.gson.Gson;
import clonewhatsapp.Clases.Mensaje;
import clonewhatsapp.Clases.ServidorComunicacion;
import clonewhatsapp.Clases.SubjectHelper;
import clonewhatsapp.Clases.TipoNotificacion;
import clonewhatsapp.clientSignInGUI.DefaultListModel;
import static clonewhatsapp.clientSignInGUI.socket;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Marie y Junior
 */
public class clientGUI extends javax.swing.JDialog {

    /**
     * Creates new form clientGUI
     */
    private DataOutputStream dout;
    private DataInputStream din;
    private Gson gson;
    public static Socket socket;
    private clientSignInGUI clorox;
    private SubjectHelper subjectHelper = new SubjectHelper();
    boolean flag = true;
    public static String receptor = "";
    public static boolean agregar = false;
    public static boolean addUser = false;
    public static int contador = 1;
    public static String digameklk;

    public clientGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private clientGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void init() {
        contador = 1;
        receptor = "";
        jLabel7.setIcon(new ImageIcon("img/iconouser.png"));
        img.setIcon(new ImageIcon("img/iconouser.png"));
        System.out.println("" + clorox.usuario);
        jLabel1.setText("" + clorox.usuario);
        gson = new Gson();
        try {
            conect();
        } catch (IOException ex) {
            Logger.getLogger(clientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ocultamos lado derecho
        img.setVisible(false);
        jTextArea1.setVisible(false);
        jTextArea2.setVisible(false);
        btnCerrar1.setVisible(false);
        jScrollPane1.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jButton2.setVisible(false);
        //

        //Ocultamos lado izquierdo
        //contacto #1
        user.setVisible(false);
        btnCerrar.setVisible(false);
        img.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnCerrar1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente WhatsApp - Usuario conectado:¨"+clorox.usuario);

        jSplitPane1.setDividerSize(15);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setText("Contacto:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Chatear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgMouseClicked(evt);
            }
        });

        user.setText("Usuario");

        btnCerrar.setText("X");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(user)
                        .addContainerGap(146, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)
                        .addGap(37, 37, 37))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(user))
                            .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnCerrar)))
                .addContainerGap(391, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(557, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(85, 85, 85)
                    .addComponent(jScrollPane3)
                    .addContainerGap()))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Usuario");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Enviar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        btnCerrar1.setText("X");
        btnCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addContainerGap(232, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar1)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCerrar1)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel2);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("Abrir");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Guardar...");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conect() throws IOException {

        din = new DataInputStream(clorox.socket.getInputStream());
        dout = new DataOutputStream(clorox.socket.getOutputStream());

        new Thread(() -> {
            try {
                //Primero recibe del servidor, por eso sol ocuando damos enviar funciona la wea en el servidor.
                //El enviarMensaje es lo ultimo que hace el servidor.
                enviarMensaje();
                recibirInformacion();
            } catch (IOException ex) {
                Logger.getLogger(clientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    private void recibirInformacion() throws IOException {
        while (true) {
            String info = din.readUTF(); //lee lo que envia el servidor
            Mensaje m = gson.fromJson(info, Mensaje.class); //lo pasa normal
            digameklk = m.enviadoA;

            mostrarMensajesRecibidos(m);
            //ManejoComunicacion.nombreUsuario.size();

        }
    }

    public static void setSocket(Socket s) {
        clientGUI.socket = s;
    }

    public static Socket getSocket() {
        return socket;
    }

    public void getInfo(clientSignInGUI tae) {
        this.clorox = tae;
    }

    private void mostrarMensajesRecibidos(Mensaje m) {
        jTextArea2.append(String.format("[%s]: %s", m.getUsuario(), m.getMensaje()) + "\n");
    }

    private void enviarMensaje() throws IOException {

        Mensaje m = null;
        if (flag) {
            flag = false;
            System.out.println("Imprimiendo receptor desde enviarMEnsaje:" + receptor);
            m = new Mensaje(clorox.usuario, receptor, jTextArea1.getText(), new Date());
            dout.writeUTF(gson.toJson(m));
            dout.flush();
        } else {
            System.out.println("Imprimiendo receptor desde enviarMEnsaje:" + receptor);
            String patron = "0000-0000-0000-0000";
            if (jTextArea1.getText().equals(patron)) {
                jTextArea1.setText("****-****-****-****");
                m = new Mensaje(clorox.usuario, receptor, jTextArea1.getText(), new Date());
            } else {
                m = new Mensaje(clorox.usuario, receptor, jTextArea1.getText(), new Date());
            }
            dout.writeUTF(gson.toJson(m));
            dout.flush();
            jTextArea1.setText("");
        }
    }

    public static String getnombreUsuario() {
        return receptor;
    }


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            enviarMensaje();
        } catch (IOException ex) {
            Logger.getLogger(clientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        receptor = jTextField1.getText();
        System.out.println("Se ha presionado chatear con el usuario..." + receptor);
        Mensaje m = new Mensaje(clorox.usuario, receptor, jTextArea1.getText(), new Date());
        try {
            dout.writeUTF(gson.toJson(m));
            dout.flush();
        } catch (IOException ex) {
            Logger.getLogger(clientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("" + clientGUI.getAdd());
        if (clientGUI.getAdd()) {

            agregar = true;

            if (agregar) {

                if (contador == 1) {
                    //contacto #1
                    user.setText(receptor);
                    user.setVisible(true);
                    btnCerrar.setVisible(true);
                    img.setVisible(true);
                    contador++;
                    return;
                }
            }
        }

        //ServidorComunicacion.getInstacia().nombreUsuario.size();
        /*
        if(buscarContacto(receptor)){
            System.out.println("Se encontro usuario");
        }
        else if(buscarContacto(receptor) == false){
            System.out.println("Usuario no encontrado...");
        }else if(clorox.usuarios.isEmpty()){
             System.out.println("Usuario no existe...");
        }
         */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed
        // TODO add your handling code here:
        //ocultamos lado derecho
        jTextArea1.setVisible(false);
        jTextArea2.setVisible(false);
        btnCerrar1.setVisible(false);
        jScrollPane1.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jButton2.setVisible(false);
    }//GEN-LAST:event_btnCerrar1ActionPerformed

    public void abrir() {

        FileReader fr;

        //Abrimos el fichero para escribir
        try {

            fr = new FileReader(jLabel6.getText() + ".txt");

        } catch (IOException io) {

            JOptionPane.showConfirmDialog(this, "Error al abrir el fichero");

            return;

        }

        //Leemos
        char[] buffer = new char[256];

        int longitud;

        try {

            while ((longitud = fr.read(buffer)) != -1) {

                String s = new String(buffer, 0, longitud);

                jTextArea2.setText(jTextArea2.getText() + s);

            }

            JOptionPane.showConfirmDialog(this, "Fichero leido");

        } catch (IOException io) {

            JOptionPane.showConfirmDialog(this, "Error al leer");

        }

        //cerramos el fichero
        try {

            fr.close();

        } catch (IOException io) {

            JOptionPane.showConfirmDialog(this, "Error al cerrar el archivo");

        }

    }

    public void guardar() {
        try {
            String ruta = jLabel6.getText() + ".txt";
            String contenido = jTextArea2.getText();
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            JOptionPane.showConfirmDialog(this, "Guardado");
            bw.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error al guardar");
        }
    }

    private void imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgMouseClicked
        // TODO add your handling code here:
        jLabel6.setText("" + user.getText());
        receptor = user.getText();
        jTextArea1.setVisible(true);
        jTextArea2.setVisible(true);
        btnCerrar1.setVisible(true);
        jScrollPane1.setVisible(true);
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
        jButton2.setVisible(true);
    }//GEN-LAST:event_imgMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        user.setVisible(false);
        btnCerrar.setVisible(false);
        img.setVisible(false);
        contador--;
        jTextArea2.setText("");
    }//GEN-LAST:event_btnCerrarActionPerformed

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
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(clientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                clientGUI dialog = new clientGUI(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton btnCerrar;
    public static javax.swing.JButton btnCerrar1;
    public static javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param observer
     */
    public void addObservadorListener(IObserver observer) {
        subjectHelper.addObserver(observer);
    }

    /**
     *
     * @param observer
     */
    public void removeObservadorListener(IObserver observer) {
        subjectHelper.removeObserver(observer);
    }

    /**
     * @param log
     */
    private void mostrarLog(String log) {
        System.out.println(log);
        subjectHelper.notify(ServidorComunicacion.class, log, TipoNotificacion.LOG);
    }

    public static void setAddUser(boolean e) {
        clientGUI.addUser = e;
    }

    public static boolean getAdd() {
        return ManejoComunicacion.deci;
    }

    public static boolean getAddUser() {
        return addUser;
    }

}