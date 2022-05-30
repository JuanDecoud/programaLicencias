/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursoshumanoszc.Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;



public class comboBox extends BasicComboBoxUI{
    
    Color nuevo = new Color(255, 255, 255);
    
        public static ComboBoxUI createUI (JComponent combo){
               
                return new comboBox();
            
        }

    @Override
    protected JButton createArrowButton() {
       
        Color nuevo = new Color(255, 255, 255);
        JButton btn = new JButton ();
     
        
        btn.setIcon(new ImageIcon(getClass().getResource("Imagenes/imagenesFormulario/flecha.png")));
        btn.setBorder(BorderFactory.createLineBorder(nuevo, 4) );
        btn.setBackground(nuevo);
        btn.setContentAreaFilled(false);
        btn.setText("");
        
        
        
        return btn;
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(nuevo);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
    
    
   

}
