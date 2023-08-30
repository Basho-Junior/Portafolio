/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clonewhatsapp.Clases;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Junior
 */
public class listaUser extends JLabel implements ListCellRenderer {

    //Icono usuario
    final static ImageIcon logo = new ImageIcon("img/iconouser.png"); 
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        String valor = value.toString();
        setText(valor);
        if(!valor.equals("")){
            setIcon(logo);
        }
        
        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else{
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
               
        return this;
        
    }
    
}
