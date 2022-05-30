/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package recursoshumanoszc.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import recursoshumanoszc.Interface.ConexionSql.Conexion;

/**
 *
 * @author Juanjo
 */
public class menuInicio extends javax.swing.JFrame implements Runnable{

    int mousex , mousey ;
    Thread t ;
    Thread t1;
    
    public menuInicio() {
        
        t = new Thread (this);
        initComponents();

        inicio inicio = new inicio();
        inicio.setSize(1040, 680);
        this.setLocationRelativeTo(null);
        
        contenido.removeAll();
        contenido.add(inicio, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
        
        
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoAplicacion = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        opciones = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Inicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nuevoParte = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        consultas1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        barraCierre = new javax.swing.JPanel();
        cerrar = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        fondoAplicacion.setBackground(new java.awt.Color(255, 255, 255));
        fondoAplicacion.setForeground(new java.awt.Color(255, 255, 255));
        fondoAplicacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(0, 204, 153));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        opciones.setBackground(new java.awt.Color(0, 141, 103));
        opciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionesMouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/configuracion.png"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Opciones");

        javax.swing.GroupLayout opcionesLayout = new javax.swing.GroupLayout(opciones);
        opciones.setLayout(opcionesLayout);
        opcionesLayout.setHorizontalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        opcionesLayout.setVerticalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        menu.add(opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 230, 50));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 190, 30));

        Inicio.setBackground(new java.awt.Color(0, 141, 103));
        Inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InicioMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/inicio_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Inicio");

        javax.swing.GroupLayout InicioLayout = new javax.swing.GroupLayout(Inicio);
        Inicio.setLayout(InicioLayout);
        InicioLayout.setHorizontalGroup(
            InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        InicioLayout.setVerticalGroup(
            InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16))
        );

        menu.add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 230, 50));

        nuevoParte.setBackground(new java.awt.Color(0, 141, 103));
        nuevoParte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevoParte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoParteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nuevoParteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nuevoParteMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/datonuevo.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nuevo Parte");

        javax.swing.GroupLayout nuevoParteLayout = new javax.swing.GroupLayout(nuevoParte);
        nuevoParte.setLayout(nuevoParteLayout);
        nuevoParteLayout.setHorizontalGroup(
            nuevoParteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoParteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        nuevoParteLayout.setVerticalGroup(
            nuevoParteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoParteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nuevoParteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu.add(nuevoParte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/final.png"))); // NOI18N
        menu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        consultas1.setBackground(new java.awt.Color(0, 141, 103));
        consultas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        consultas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultas1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                consultas1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                consultas1MouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/registros.png"))); // NOI18N

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Consultas");

        javax.swing.GroupLayout consultas1Layout = new javax.swing.GroupLayout(consultas1);
        consultas1.setLayout(consultas1Layout);
        consultas1Layout.setHorizontalGroup(
            consultas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        consultas1Layout.setVerticalGroup(
            consultas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consultas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu.add(consultas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 230, 50));

        fondoAplicacion.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 710));

        barraCierre.setBackground(new java.awt.Color(204, 204, 204));
        barraCierre.setForeground(new java.awt.Color(102, 255, 204));
        barraCierre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraCierreMouseDragged(evt);
            }
        });
        barraCierre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraCierreMousePressed(evt);
            }
        });

        cerrar.setBackground(new java.awt.Color(51, 51, 51));
        cerrar.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        cerrar.setForeground(new java.awt.Color(153, 153, 153));
        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setText("x");
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout barraCierreLayout = new javax.swing.GroupLayout(barraCierre);
        barraCierre.setLayout(barraCierreLayout);
        barraCierreLayout.setHorizontalGroup(
            barraCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraCierreLayout.createSequentialGroup()
                .addGap(0, 1002, Short.MAX_VALUE)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraCierreLayout.setVerticalGroup(
            barraCierreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraCierreLayout.createSequentialGroup()
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondoAplicacion.add(barraCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1040, 30));

        contenido.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        fondoAplicacion.add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 1040, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void nuevoParteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoParteMouseClicked
     
      
    /*
        Formulario  form = new Formulario ();
        form.setSize (1040,680);
        contenido.removeAll();
        contenido.add(form, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();*/
        
        t = new Thread (this);
        t.start();
        
 
        
        
    }//GEN-LAST:event_nuevoParteMouseClicked

    private void InicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InicioMouseClicked
        inicio  inicio = new inicio ();
        inicio.setSize (1040,680);
        
        
        contenido.removeAll();
        contenido.add(inicio, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint(); // TODO add your handling code here:
    }//GEN-LAST:event_InicioMouseClicked

    private void opcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionesMouseClicked
        Opciones  opcion = new Opciones();
        opcion.setSize (1040,680);
        
        
        contenido.removeAll();
        contenido.add(opcion, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint(); 
    }//GEN-LAST:event_opcionesMouseClicked

    private void consultas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultas1MouseClicked
        
     /*   Consultas consulta = new Consultas();
        consulta.setSize(1040, 680);
        
        contenido.removeAll();
        contenido.add(consulta, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
       */
        t1 = new Thread(this);
        t1.start();
       
    }//GEN-LAST:event_consultas1MouseClicked

    private void InicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InicioMouseEntered
        Color color = new Color(0, 102, 102);
        Inicio.setBackground(color);
    }//GEN-LAST:event_InicioMouseEntered

    private void InicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InicioMouseExited
        Color color = new Color (0,141,103);
        Inicio.setBackground(color);
        
    }//GEN-LAST:event_InicioMouseExited

    private void nuevoParteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoParteMouseEntered
        Color color = new Color(0, 102, 102);
        nuevoParte.setBackground(color);
    }//GEN-LAST:event_nuevoParteMouseEntered

    private void nuevoParteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoParteMouseExited
        Color color = new Color (0,141,103);
        nuevoParte.setBackground(color);
    }//GEN-LAST:event_nuevoParteMouseExited

    private void consultas1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultas1MouseEntered
        Color color = new Color(0, 102, 102);
        consultas1.setBackground(color);
    }//GEN-LAST:event_consultas1MouseEntered

    private void consultas1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultas1MouseExited
        Color color = new Color (0,141,103);
        consultas1.setBackground(color);
    }//GEN-LAST:event_consultas1MouseExited

    private void opcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionesMouseEntered
        Color color = new Color(0, 102, 102);
        opciones.setBackground(color);
    }//GEN-LAST:event_opcionesMouseEntered

    private void opcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionesMouseExited
        Color color = new Color (0,141,103);
        opciones.setBackground(color);
    }//GEN-LAST:event_opcionesMouseExited

    private void barraCierreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraCierreMousePressed
        mousex = evt.getX();
        mousey = evt.getY();
    }//GEN-LAST:event_barraCierreMousePressed

    private void barraCierreMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraCierreMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-mousex,y- mousey);
    }//GEN-LAST:event_barraCierreMouseDragged

    private void cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseExited
        cerrar.setBackground(Color.GRAY);
        
    }//GEN-LAST:event_cerrarMouseExited

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered

        cerrar.setBackground(Color.red);
    }//GEN-LAST:event_cerrarMouseEntered

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

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
            java.util.logging.Logger.getLogger(menuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuInicio().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Inicio;
    private javax.swing.JPanel barraCierre;
    private javax.swing.JLabel cerrar;
    private javax.swing.JPanel consultas1;
    public javax.swing.JPanel contenido;
    private javax.swing.JPanel fondoAplicacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel nuevoParte;
    private javax.swing.JPanel opciones;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
        if (t.isAlive()){
            cargando nuevo = new cargando ();
            nuevo.setLocationRelativeTo(menu);
            nuevo.setVisible(true);
            nuevo.setSize(420, 165);
            Formulario form = new Formulario ();
            form.setSize (1040,680);

            contenido.removeAll();
            contenido.add(form, BorderLayout.CENTER);
            contenido.revalidate();
            contenido.repaint();
            nuevo.setVisible(false);
           
        }
        else  if(t1.isAlive()){
            cargando nuevo = new cargando ();
            nuevo.setLocationRelativeTo(menu);
            nuevo.setVisible(true);
            nuevo.setSize(420, 165);
            Consultas consulta = new Consultas();
            consulta.setSize(1040, 680);

            contenido.removeAll();
            contenido.add(consulta, BorderLayout.CENTER);
            contenido.revalidate();
            contenido.repaint();
            nuevo.setVisible(false);
            

        }

    }
 


    

}
