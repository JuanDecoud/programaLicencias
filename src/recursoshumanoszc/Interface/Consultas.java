/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package recursoshumanoszc.Interface;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import recursoshumanoszc.Interface.ConexionSql.Conexion;
import recursoshumanoszc.Licencias.Licencia;

/**
 *
 * @author Juanj
 */
public class Consultas extends javax.swing.JPanel {
    
    Conexion con ;
    public Consultas() {
        con = new Conexion();
        con.conectar();
        initComponents();
        generarBoxes();
        dateCHosers();
        
    }
    
    
      public void crearBoxes (JComboBox combo){
       combo.setUI(comboBox.createUI(combo)); 
    
    }
      
   public void generarBoxes (){
    
        crearBoxes(bsSector);
        crearBoxes(consultaPuesto);

    }
   
   public void addDatatotable ( Licencia licencia , DefaultTableModel tablem){

       Object [] fila = new Object[10];
       fila [0]= licencia.getNombreApellido();
       fila [1] = licencia.getFechaInicio();
       fila[2] = licencia.getFechaFin();
       fila[3]=licencia.getTipoLicencia();
       fila[4]=licencia.getMotivo();
       fila[5]=licencia.getSector();
       fila[6]=licencia.getPuesto();
       fila[7]=licencia.getCertificado();
       fila[8]=licencia.getObservacion();
       fila[9]=licencia.getAutoriza();
       tablem.addRow(fila);

   }
   
   public void buscarenBases (Conexion con , DefaultTableModel tablem){
          Licencia licencia = new Licencia ();
          
          ResultSet busqueda = con.consultarRegistros("SELECT *FROM Licencias");
          try {
              while (busqueda.next()){
                 
                 licencia = generarLicencia(busqueda);
                 addDatatotable(licencia, tablem);

              }
          } catch (SQLException ex) {
              Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
          }
          
   
   }
   
   public Licencia generarLicencia (ResultSet busqueda ) throws SQLException{
            
            Licencia licencia = new Licencia ();
            licencia.setNombreApellido(busqueda.getString("Nombre"));
            licencia.setFechaInicio(busqueda.getString("Fecha"));
            licencia.setFechaFin(busqueda.getString("Fecha Fin"));
            licencia.setTipoLicencia(busqueda.getString("Tipo Licencia"));
            licencia.setMotivo(busqueda.getString("Motivo"));
            licencia.setSector(busqueda.getString("Sector"));
            licencia.setPuesto(busqueda.getString("Puesto"));
            licencia.setCertificado(busqueda.getString("Certficado"));
            licencia.setObservacion(busqueda.getString("Observacion"));
            licencia.setAutoriza(busqueda.getString("Autoriza"));

            return licencia ;

   }
   
    public void dateCHosers (){
    Color nuevo = new Color(255, 255, 255);
    bsfechaf.setBackground(nuevo);
    bsfechaf.setBorder(BorderFactory.createLineBorder(nuevo));
    bsfecha.setBackground(nuevo);
    bsfecha.setBorder(BorderFactory.createLineBorder(nuevo));
    bsfechaf.setForeground(nuevo);
    bsfecha.getDateEditor().getUiComponent().setBackground(nuevo);
    bsfecha.getDateEditor().getUiComponent().setBackground(nuevo);

    }
    
    
    public void openFile (String file){
    
      
        try {
            File patch = new File (file);
            Desktop.getDesktop().open(patch);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
        
  
       
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        consultas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLicencias = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        consultaPuesto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        panelNombre3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bsSector = new javax.swing.JComboBox<>();
        panelNombre5 = new javax.swing.JPanel();
        bsfechaf = new com.toedter.calendar.JDateChooser();
        bsNombre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bsfecha = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        exportar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buscar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1040, 680));
        setMinimumSize(new java.awt.Dimension(1040, 680));
        setPreferredSize(new java.awt.Dimension(1040, 680));

        consultas.setBackground(new java.awt.Color(255, 255, 255));
        consultas.setMinimumSize(new java.awt.Dimension(1040, 680));
        consultas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/consultas1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Consultas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25))))
        );

        consultas.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 90));
        consultas.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, 10));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tableLicencias.setBackground(new java.awt.Color(204, 204, 204));
        tableLicencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre y Apellido", "Desde", "Hasta", "Descripcion", "Motivo", "Sector", "Puesto", "Certificado", "Observacion", "Autoriza"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableLicencias);
        if (tableLicencias.getColumnModel().getColumnCount() > 0) {
            tableLicencias.getColumnModel().getColumn(0).setMinWidth(120);
            tableLicencias.getColumnModel().getColumn(0).setPreferredWidth(120);
            tableLicencias.getColumnModel().getColumn(0).setMaxWidth(120);
            tableLicencias.getColumnModel().getColumn(1).setMinWidth(70);
            tableLicencias.getColumnModel().getColumn(1).setPreferredWidth(70);
            tableLicencias.getColumnModel().getColumn(1).setMaxWidth(70);
            tableLicencias.getColumnModel().getColumn(2).setMinWidth(70);
            tableLicencias.getColumnModel().getColumn(2).setPreferredWidth(70);
            tableLicencias.getColumnModel().getColumn(2).setMaxWidth(70);
            tableLicencias.getColumnModel().getColumn(3).setMinWidth(100);
            tableLicencias.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableLicencias.getColumnModel().getColumn(3).setMaxWidth(100);
            tableLicencias.getColumnModel().getColumn(4).setMinWidth(100);
            tableLicencias.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableLicencias.getColumnModel().getColumn(4).setMaxWidth(100);
            tableLicencias.getColumnModel().getColumn(5).setMinWidth(100);
            tableLicencias.getColumnModel().getColumn(5).setPreferredWidth(100);
            tableLicencias.getColumnModel().getColumn(5).setMaxWidth(100);
            tableLicencias.getColumnModel().getColumn(6).setMinWidth(100);
            tableLicencias.getColumnModel().getColumn(6).setPreferredWidth(100);
            tableLicencias.getColumnModel().getColumn(6).setMaxWidth(100);
            tableLicencias.getColumnModel().getColumn(7).setMinWidth(70);
            tableLicencias.getColumnModel().getColumn(7).setPreferredWidth(70);
            tableLicencias.getColumnModel().getColumn(7).setMaxWidth(70);
            tableLicencias.getColumnModel().getColumn(9).setMinWidth(100);
            tableLicencias.getColumnModel().getColumn(9).setPreferredWidth(100);
            tableLicencias.getColumnModel().getColumn(9).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        consultas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 1010, 360));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/puesto-de-trabajo.png"))); // NOI18N
        consultas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        consultaPuesto.setBackground(new java.awt.Color(255, 255, 255));
        consultaPuesto.setForeground(new java.awt.Color(0, 0, 0));
        consultaPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chofer local", "Chofer de larga distancia", "Operario/a", "Administrativo/a", "Maestranza", "Otros" }));
        consultaPuesto.setSelectedIndex(-1);
        consultaPuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        consultaPuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                consultaPuestoItemStateChanged(evt);
            }
        });
        consultaPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPuestoActionPerformed(evt);
            }
        });
        consultas.add(consultaPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 150, 20));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Puesto");
        consultas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        panelNombre3.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/departamento.png"))); // NOI18N
        panelNombre3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Sector");
        panelNombre3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        bsSector.setBackground(new java.awt.Color(255, 255, 255));
        bsSector.setForeground(new java.awt.Color(0, 0, 0));
        bsSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administracion contable y finanzas", "Operaciones y Logistica", "RRHH Y Asuntos Regulatorios", "Comercial", "Maestranza", "Otros" }));
        bsSector.setSelectedIndex(-1);
        bsSector.setToolTipText("");
        bsSector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsSector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bsSectorItemStateChanged(evt);
            }
        });
        bsSector.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                bsSectorPopupMenuWillBecomeVisible(evt);
            }
        });
        bsSector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bsSectorMouseClicked(evt);
            }
        });
        bsSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsSectorActionPerformed(evt);
            }
        });
        panelNombre3.add(bsSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 150, 20));

        consultas.add(panelNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 160, 70));

        panelNombre5.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        consultas.add(panelNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, 70));

        bsfechaf.setDateFormatString("dd/MM/yy");
        consultas.add(bsfechaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 170, 30));

        bsNombre.setBackground(new java.awt.Color(255, 255, 255));
        bsNombre.setForeground(new java.awt.Color(0, 0, 0));
        bsNombre.setToolTipText("");
        bsNombre.setBorder(null);
        bsNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsNombreActionPerformed(evt);
            }
        });
        consultas.add(bsNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 170, 20));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Nombre o Apellido");
        consultas.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/usuario.png"))); // NOI18N
        consultas.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));
        consultas.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 170, 10));

        bsfecha.setDateFormatString("dd/MM/yy");
        consultas.add(bsfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 170, 30));
        consultas.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));
        consultas.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 150, 20));
        consultas.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, 20));

        exportar.setBackground(new java.awt.Color(255, 255, 255));
        exportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exportarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exportarMouseExited(evt);
            }
        });
        exportar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/exportar.png"))); // NOI18N
        exportar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Exportar");
        exportar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        consultas.add(exportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 580, 150, 60));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarMouseExited(evt);
            }
        });
        buscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/busqueda1.png"))); // NOI18N
        buscar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Buscar");
        buscar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        consultas.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 150, 60));

        btnBorrar.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBorrarMouseExited(evt);
            }
        });
        btnBorrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/goma-de-borrar.png"))); // NOI18N
        btnBorrar.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Borrar");
        btnBorrar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        consultas.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 130, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consultas, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultaPuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_consultaPuestoItemStateChanged
     

    }//GEN-LAST:event_consultaPuestoItemStateChanged

    private void consultaPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaPuestoActionPerformed

    private void bsSectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bsSectorItemStateChanged

    }//GEN-LAST:event_bsSectorItemStateChanged

    private void bsSectorPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_bsSectorPopupMenuWillBecomeVisible

    }//GEN-LAST:event_bsSectorPopupMenuWillBecomeVisible

    private void bsSectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsSectorMouseClicked

    }//GEN-LAST:event_bsSectorMouseClicked

    private void bsSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsSectorActionPerformed

    }//GEN-LAST:event_bsSectorActionPerformed

    private void bsNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bsNombreActionPerformed

    private void exportarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportarMouseEntered
        exportar.setBackground(Color.GRAY);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        exportar.setBorder(border);
    }//GEN-LAST:event_exportarMouseEntered

    private void exportarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportarMouseExited
        exportar.setBackground(Color.white);
        exportar.setBorder(null);
    }//GEN-LAST:event_exportarMouseExited

    private void buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseEntered
          buscar.setBackground(Color.GRAY);
          Border border = BorderFactory.createLineBorder(Color.BLACK);
          buscar.setBorder(border);
    }//GEN-LAST:event_buscarMouseEntered

    private void buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseExited
       buscar.setBackground(Color.white);
       buscar.setBorder(null);
    }//GEN-LAST:event_buscarMouseExited

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
            

         DefaultTableModel tablem = (DefaultTableModel) tableLicencias.getModel();
         tablem.getDataVector().removeAllElements();
         String where = " Where 1=1 ";
         if (bsSector.getSelectedItem()!=null){
             where = where + " and Sector='"+bsSector.getSelectedItem().toString()+"'";
         }
         if (consultaPuesto.getSelectedItem()!=null){
           where = where + " and Puesto='"+consultaPuesto.getSelectedItem().toString()+"'";
           System.out.println(where);
         }
         
         if (!"".equals(bsNombre.getText())){
           where = where + " and Nombre='"+bsNombre.getText()+"'";
             
         }
         
         if (bsfechaf.getDate()!=null && bsfecha.getDate()!=null){
            SimpleDateFormat format = new SimpleDateFormat(bsfechaf.getDateFormatString());
            String fechafin = format.format(bsfechaf.getDate());
            String fechainicio = format.format(bsfecha.getDate());
            if (fechafin!=null && fechainicio!=null){

                where = where + " and Fecha BETWEEN '"+fechainicio+"' and '"+fechafin+"'";
           }

         }
         
         String prueba = "Select * FROM Licencias " +where+" ;";
         System.out.println(prueba);

         ResultSet busqueda =   con.consultarRegistros("Select * FROM Licencias " +where+" ;");
         
        try {
            while (busqueda.next()){
                
                Licencia licencia = generarLicencia(busqueda);
                addDatatotable(licencia, tablem);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
        
         
        
    }//GEN-LAST:event_buscarMouseClicked

    private void exportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportarMouseClicked
        try {
            JFileChooser choser = new JFileChooser();
            choser.showSaveDialog(this);
            File saveFile =choser.getSelectedFile();
            if (saveFile !=null){
                saveFile = new File (saveFile.toString()+".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Customer");
                Row rowCol = sheet.createRow(0);
                
                for (int i = 0 ; i <tableLicencias.getColumnCount() ; i++ ){
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tableLicencias.getColumnName(i));

                }
                for (int j = 1 ; j <tableLicencias.getRowCount(); j++){
                    Row row = sheet.createRow(j);
                    for (int k = 0 ;  k <tableLicencias.getColumnCount() ; k++){
                        Cell cell  = row.createCell(k);
                        if (tableLicencias.getValueAt(j, k)!=null){
                            cell.setCellValue(tableLicencias.getValueAt(j, k).toString());
                        }
                        
                    }
                
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()) );
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());

            }else{
                System.out.println("Error al generar archivo");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }catch (IOException IO){
            System.out.println(IO);
        }
                    

    }//GEN-LAST:event_exportarMouseClicked

    private void btnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseClicked
        DefaultTableModel modelo=(DefaultTableModel) tableLicencias.getModel();
            int filas=modelo.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }

       
       bsSector.setSelectedItem(null);
       bsfecha.setDate(null);
       bsfechaf.setDate(null);
       bsNombre.setText("");
      consultaPuesto.setSelectedItem(null);

    }//GEN-LAST:event_btnBorrarMouseClicked

    private void btnBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseEntered
        Color color = new Color(204, 204, 204);
        btnBorrar.setBackground(color);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        btnBorrar.setBorder(border);
    }//GEN-LAST:event_btnBorrarMouseEntered

    private void btnBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseExited
        btnBorrar.setBackground(Color.white);
        btnBorrar.setBorder(null);

    }//GEN-LAST:event_btnBorrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bsNombre;
    private javax.swing.JComboBox<String> bsSector;
    private com.toedter.calendar.JDateChooser bsfecha;
    private com.toedter.calendar.JDateChooser bsfechaf;
    private javax.swing.JPanel btnBorrar;
    private javax.swing.JPanel buscar;
    private javax.swing.JComboBox<String> consultaPuesto;
    private javax.swing.JPanel consultas;
    private javax.swing.JPanel exportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel panelNombre3;
    private javax.swing.JPanel panelNombre5;
    private javax.swing.JTable tableLicencias;
    // End of variables declaration//GEN-END:variables

   
}
