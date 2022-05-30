/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package recursoshumanoszc.Interface.opciones;

import java.awt.Color;
import javax.swing.JComboBox;
import recursoshumanoszc.Interface.ConexionSql.Conexion;
import recursoshumanoszc.Interface.comboBox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import recursoshumanoszc.Interface.Formulario;


/**
 *
 * @author Juanjo
 */
public class empleadoNuevo extends javax.swing.JPanel {

    /**
     * Creates new form empleadoNuevo
     */
    public empleadoNuevo() {
        initComponents();
       

        crearBoxes(boxempresa);
        crearBoxes(boxpuesto);
        crearBoxes(boxsector);
 
       
        
    }
    
    public void crearBoxes (JComboBox combo){
        combo.setUI(comboBox.createUI(combo)); 
    
    }
    
    public void resetearBoxes (){
 
        nombreEmpleado.setText("");
        dniEmpleado.setText("");
        boxempresa.setSelectedIndex(-1);
        boxpuesto.setSelectedIndex(-1);
        boxsector.setSelectedIndex(-1);
    }
    
    
        public void obtenerDatos (String base , JComboBox box , String columna  , Conexion con){

        ResultSet consulta = con.consultarRegistros("SELECT * FROM "+base);
        
        try {
            while (consulta.next()){
                String sector = consulta.getString(columna);
                box.addItem(sector);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        box.setSelectedIndex(-1);
        
    
    }
        
        

  
    
    
    
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        neDocumento = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        dniEmpleado = new javax.swing.JTextField();
        nePuesto = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        boxpuesto = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        neSector = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        boxsector = new javax.swing.JComboBox<>();
        jSeparator6 = new javax.swing.JSeparator();
        neEmpresa = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        boxempresa = new javax.swing.JComboBox<>();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarempleado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        neNombre = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        nombreEmpleado = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(790, 640));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1023, 656));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        neDocumento.setBackground(new java.awt.Color(255, 255, 255));
        neDocumento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/carne-de-identidad (1).png"))); // NOI18N
        neDocumento.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("N° De Documento");
        neDocumento.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));
        neDocumento.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 20));

        dniEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        dniEmpleado.setForeground(new java.awt.Color(153, 153, 153));
        dniEmpleado.setText("Ingrese documento");
        dniEmpleado.setBorder(null);
        neDocumento.add(dniEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, -1));

        jPanel1.add(neDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 190, 90));

        nePuesto.setBackground(new java.awt.Color(255, 255, 255));
        nePuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nePuesto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/puesto-de-trabajo.png"))); // NOI18N
        nePuesto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Puesto");
        nePuesto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        boxpuesto.setBackground(new java.awt.Color(255, 255, 255));
        boxpuesto.setForeground(new java.awt.Color(0, 0, 0));
        boxpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chofer local", "Chofer de larga distancia", "Operario/a", "Administrativo/a", "Maestranza", "Otros" }));
        boxpuesto.setSelectedIndex(-1);
        boxpuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxpuestoItemStateChanged(evt);
            }
        });
        boxpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxpuestoActionPerformed(evt);
            }
        });
        nePuesto.add(boxpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 20));
        nePuesto.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 10));

        jPanel1.add(nePuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 190, 90));

        neSector.setBackground(new java.awt.Color(255, 255, 255));
        neSector.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/departamento.png"))); // NOI18N
        neSector.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Sector");
        neSector.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        boxsector.setBackground(new java.awt.Color(255, 255, 255));
        boxsector.setForeground(new java.awt.Color(0, 0, 0));
        boxsector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administracion contable y finanzas", "Operaciones y Logistica", "RRHH Y Asuntos Regulatorios", "Comercial", "Maestranza", "Otros", " " }));
        boxsector.setSelectedIndex(-1);
        boxsector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxsector.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                boxsectorPopupMenuWillBecomeVisible(evt);
            }
        });
        boxsector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxsectorMouseClicked(evt);
            }
        });
        boxsector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxsectorActionPerformed(evt);
            }
        });
        neSector.add(boxsector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 20));
        neSector.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 190, 10));

        jPanel1.add(neSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 190, 90));

        neEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        neEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/empresa.png"))); // NOI18N
        neEmpresa.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Empresa");
        neEmpresa.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        boxempresa.setBackground(new java.awt.Color(255, 255, 255));
        boxempresa.setForeground(new java.awt.Color(0, 0, 0));
        boxempresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "El Faro", "Zona Comun", "Braggio", "Recomb", "Energia" }));
        boxempresa.setSelectedIndex(-1);
        boxempresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        neEmpresa.add(boxempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 20));
        neEmpresa.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 10));

        jPanel1.add(neEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 190, 90));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 454, 25));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar nuevo empleado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 349, 38));

        btnAgregarempleado.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarempleado.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarempleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarempleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarempleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarempleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarempleadoMouseExited(evt);
            }
        });
        btnAgregarempleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/agregar-usuario.png"))); // NOI18N
        btnAgregarempleado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Agregar Empleado");
        btnAgregarempleado.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel1.add(btnAgregarempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 220, 50));

        neNombre.setBackground(new java.awt.Color(255, 255, 255));
        neNombre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/usuario.png"))); // NOI18N
        neNombre.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Apellido y Nombre");
        neNombre.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        neNombre.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 20));

        nombreEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        nombreEmpleado.setForeground(new java.awt.Color(153, 153, 153));
        nombreEmpleado.setText("Ingrese nombre");
        nombreEmpleado.setBorder(null);
        neNombre.add(nombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, -1));

        jPanel1.add(neNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 190, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxpuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxpuestoItemStateChanged
        
    }//GEN-LAST:event_boxpuestoItemStateChanged

    private void boxpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxpuestoActionPerformed

    private void boxsectorPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_boxsectorPopupMenuWillBecomeVisible

    }//GEN-LAST:event_boxsectorPopupMenuWillBecomeVisible

    private void boxsectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxsectorMouseClicked

    }//GEN-LAST:event_boxsectorMouseClicked

    private void boxsectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxsectorActionPerformed

    }//GEN-LAST:event_boxsectorActionPerformed

    private void btnAgregarempleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarempleadoMouseClicked
            if (!"".equals(nombreEmpleado.getText()) && !"".equals(dniEmpleado.getText()) ){
                Conexion con = new Conexion ();
                con.conectar();
                
                String insertar =String.format("INSERT INTO `Empleado`(`id`, `Nombre`, `DNI`, `Puesto`, `Sector`, `Empresa`) VALUES ('%d','%s','%s','%s','%s','%s')"
                        , 0 , nombreEmpleado.getText(), dniEmpleado.getText(),boxpuesto.getSelectedItem().toString(),boxsector.getSelectedItem().toString() ,boxempresa.getSelectedItem().toString());
                
                con.ejercutarSentenciaSQL(insertar);
                con.desconectar();
            }
            else {
                System.out.println("Debe completar los campos");
            }
            resetearBoxes();
    }//GEN-LAST:event_btnAgregarempleadoMouseClicked

    private void btnAgregarempleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarempleadoMouseEntered
        btnAgregarempleado.setBackground(Color.GRAY);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        btnAgregarempleado.setBorder(border);
    }//GEN-LAST:event_btnAgregarempleadoMouseEntered

    private void btnAgregarempleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarempleadoMouseExited
        btnAgregarempleado.setBackground(Color.WHITE);
        btnAgregarempleado.setBorder(null);
    }//GEN-LAST:event_btnAgregarempleadoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxempresa;
    private javax.swing.JComboBox<String> boxpuesto;
    private javax.swing.JComboBox<String> boxsector;
    private javax.swing.JPanel btnAgregarempleado;
    private javax.swing.JTextField dniEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel neDocumento;
    private javax.swing.JPanel neEmpresa;
    private javax.swing.JPanel neNombre;
    private javax.swing.JPanel nePuesto;
    private javax.swing.JPanel neSector;
    private javax.swing.JTextField nombreEmpleado;
    // End of variables declaration//GEN-END:variables
}
