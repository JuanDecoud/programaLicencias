/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package recursoshumanoszc.Interface;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLTagProcessors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;

import java.awt.Menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleRole;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.text.DefaultCaret;
import recursoshumanoszc.Interface.ConexionSql.Conexion;
import recursoshumanoszc.Licencias.Empleado;
import recursoshumanoszc.Licencias.motivosLicencia;

/**
 *
 * @author Juanjo
 */
public final class Formulario extends javax.swing.JPanel {
        Conexion con = new Conexion ();
        

    public Formulario() {
        
        
        con.conectar();
        initComponents();
        generarBoxes();

        dateCHosers();
       
        cNombre.setVisible(false);
        cbxMotivos.setVisible(false);
        cbxEmpresa.setVisible(false);
  

    }
    
    public void generarPdf (){
    
        JFileChooser dlg = new JFileChooser();
        String f1 ;
        int opcion = dlg.showSaveDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION){
                 
            File f =dlg.getSelectedFile();
            f1 = f.toString();
            try {
                try (OutputStream miarchivo = new FileOutputStream(f1 + ".pdf")) {
                    
                    
                    Document doc = new Document();
                    Image nueva = null ;
                    if (cbxEmpresa.getSelectedItem().toString().equals("Zona Comun")){
                        nueva = Image.getInstance("logo1.png");
                    }else if (cbxEmpresa.getSelectedItem().toString().equals("El Faro")){
                        nueva = Image.getInstance("elfaro.jpg");
                    }else if (cbxEmpresa.getSelectedItem().toString().equals("Energia")){
                        nueva = Image.getInstance("energia.jpg");
                    }else if (cbxEmpresa.getSelectedItem().toString().equals("Braggio")){
                        nueva = Image.getInstance("braggioLogo.jpg");
                    }else{
                        nueva = Image.getInstance("recombLogo.jpg");
                    }
                    
                    
                    PdfWriter.getInstance(doc, miarchivo);
                    nueva.setAlignment(Element.ALIGN_LEFT);
                    
                    doc.open();
                    String asunto = Chunk.NEWLINE+"PLANILLA DE PERMISOS Y NOVEDADES";
                    Paragraph titulo = new Paragraph();
                    titulo.setFont(FontFactory.getFont("Thaoma", 25, Font.BOLD));
                    titulo.add(asunto);
                    
                    titulo.setAlignment(Element.ALIGN_LEFT);
                    
                    /// formato fecha
                    LocalDate fechaactual =LocalDate.now() ;
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formateado = fechaactual.format(formato);
                    String completarFecha = Chunk.NEWLINE + "Mar Del Plata," +" "+ formateado + "." ;
                    
                    Paragraph fecha = new Paragraph(completarFecha);
                    fecha.setAlignment(Element.ALIGN_RIGHT);
               
                     
                    Paragraph celda = new Paragraph("Descripcion");
                 
 
                    PdfPTable tablaParte = new PdfPTable(6);
                   
                    tablaParte.setHorizontalAlignment(Element.ALIGN_CENTER);
 
 
                    PdfPCell celda1 = new PdfPCell(celda);
                    PdfPCell celda3 = new PdfPCell(new Paragraph("Motivo"));
                    PdfPCell celda4 = new PdfPCell(new Paragraph("Desde"));
                    PdfPCell celda5 = new PdfPCell(new Paragraph("Hasta"));
                    PdfPCell celda6 = new PdfPCell (new Paragraph ("Certificado"));
                    PdfPCell celda7 = new PdfPCell (new Paragraph ("Autoriza"));
                    
                    
                    tablaParte.addCell(celda1);
                    tablaParte.addCell(celda3);
                    tablaParte.addCell(celda4);
                    tablaParte.addCell(celda5);
                    tablaParte.addCell (celda6);
                    tablaParte.addCell(celda7);
                    
                    SimpleDateFormat format = new SimpleDateFormat(fechaFin.getDateFormatString());
                    String fechafin = format.format(fechaFin.getDate());
                    String fechainicio = format.format(fechaInicio.getDate());
                    
                    
                    tablaParte.addCell(cbxDescripcion.getSelectedItem().toString());
                    tablaParte.addCell(cbxMotivos.getSelectedItem().toString());
                    tablaParte.addCell(fechainicio);
                    tablaParte.addCell(fechafin);
                    tablaParte.addCell (cCertificado.getSelectedItem().toString());
                    tablaParte.addCell(cAutorizar.getSelectedItem().toString());

                    for (int i = 0 ;  i< 2 ; i++){
                        PdfPRow FILA = tablaParte.getRow(i);
                     
                        PdfPCell[] celdas = FILA.getCells();
                        for ( PdfPCell celdasin : celdas){
                            celdasin.setVerticalAlignment(Element.ALIGN_CENTER);
                            celdasin.setHorizontalAlignment(Element.ALIGN_CENTER);
                           
                        }
                      
                    }
                    

                    Paragraph nombreApellido = new Paragraph();
                   

                    nombreApellido.add("Nombre y Apellido: "+cNombre.getSelectedItem().toString() +Chunk.NEWLINE  );
                    nombreApellido.add("Puesto: "+cbxPuesto.getSelectedItem().toString() + Chunk.NEWLINE );
                    nombreApellido.add("Sector: "+cSector.getSelectedItem().toString() +Chunk.NEWLINE  );
                    

                    Paragraph motivoAgregad = new Paragraph();
                    motivoAgregad.add("Observacion: "+this.observacion.getText());

                   PdfPTable firmas = new PdfPTable(3);
                   
                   PdfPCell fempleado = new PdfPCell(new Paragraph("Firma empleado"));
                   PdfPCell fJefe = new PdfPCell(new Paragraph("Firma del Jefe"));
                   PdfPCell fRRHH = new PdfPCell(new Paragraph("Firma RRHH"));
                   

                   fempleado.setBorder(0);
                   fJefe.setBorder(0);
                   fRRHH.setBorder(0);
                   firmas.addCell(fempleado);
                   firmas.addCell(fJefe);
                   firmas.addCell(fRRHH);
                 

                    doc.add(nueva);
                    doc.add(fecha);
                    doc.add(Chunk.NEWLINE);
                    doc.add(titulo);
                    doc.add(Chunk.NEWLINE);
                    doc.add(nombreApellido);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);
                    doc.add(tablaParte);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);
                    doc.add(motivoAgregad);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);
                    doc.add(firmas);
                  
                 

                  
                    
                    doc.close();
                    miarchivo.close();
                }
                 
           } catch (DocumentException | FileNotFoundException e) {
           } catch (IOException ex) {
               Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
           } finally {
           }
             
 
             }    
    }
    
  
    
    public void filtrarEmpleado (Conexion con){
      
        if (cSector.getSelectedItem()!=null && cbxPuesto.getSelectedItem()!=null){

            
            ResultSet busqueda = con.consultarRegistros("SELECT * FROM  Empleado");
            String btnSector = cSector.getItemAt(cSector.getSelectedIndex());
            String btnPuesto = cbxPuesto.getItemAt(cbxPuesto.getSelectedIndex());

        try {
            while (busqueda.next()){

                String sector = busqueda.getString("Sector");
                String puesto = busqueda.getString("Puesto");
                String nombre =busqueda.getString("Nombre");
                
             if (btnSector.equals(sector)&& btnPuesto.equals(puesto)){
             
                cNombre.addItem(nombre);
             }

            }
            
        } catch (SQLException e) {
        }
       
        cNombre.setVisible(true);
        cNombre.setSelectedIndex(-1);

       

        }

    }
    
    public void dateCHosers (){
        Color nuevo = new Color(255, 255, 255);
        observacion.setEditable(true);
        observacion.setEnabled(true);
        fechaFin.setBackground(nuevo);
        fechaFin.setBorder(BorderFactory.createLineBorder(nuevo));
        fechaInicio.setBackground(nuevo);
        fechaInicio.setBorder(BorderFactory.createLineBorder(nuevo));
        fechaFin.setForeground(nuevo);
        fechaFin.getDateEditor().getUiComponent().setBackground(nuevo);
        fechaInicio.getDateEditor().getUiComponent().setBackground(nuevo);

    }
    
    public void generarBoxes (){
    
        crearBoxes(cbxPuesto);
        crearBoxes(cbxMotivos);
        crearBoxes(cSector);
        crearBoxes(cNombre);
        crearBoxes(cbxDescripcion);
        crearBoxes(cbxMotivos);
        crearBoxes(cCertificado);
        crearBoxes(cbxEmpresa);
        crearBoxes (cAutorizar);
       
    
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
    
    public void filtrarMotivos (Conexion con){
  
        if (cbxDescripcion!=null){

            ResultSet busqueda = con.consultarRegistros("SELECT * FROM Motivos");
            
            String comparar = cbxDescripcion.getItemAt(cbxDescripcion.getSelectedIndex());
            if (comparar.equals("Ausencia")){
                cbxMotivos.addItem("No Justificada");
                cbxMotivos.setVisible(true);
            
            }
            else {
                try {
                while (busqueda.next()){
                    String item = busqueda.getString("Motivo");
                    if (busqueda.getString("Tipo").equals(comparar)){
                        
                            cbxMotivos.addItem(item);
                    }
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
            }
            cbxMotivos.setVisible(true);
                
            }
            

        
        }
    
    }
    
    public void reset (){
        cSector.setSelectedItem(null);
        cbxPuesto.setSelectedItem(null);
        cNombre.setVisible(false);
        cbxDescripcion.setSelectedItem(null);
        cbxEmpresa.setVisible(false);
        cbxMotivos.setVisible(false);
        observacion.setText("");
        fechaFin.setDate(null);
        fechaInicio.setDate(null);
        cCertificado.setSelectedIndex(-1);
        cAutorizar.setSelectedIndex(-1);
        
       
    
    }
    
    
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelNombre1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxPuesto = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        panelNombre2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxMotivos = new javax.swing.JComboBox<>();
        jSeparator5 = new javax.swing.JSeparator();
        panelNombre3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cSector = new javax.swing.JComboBox<>();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        panelNombre4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cNombre = new javax.swing.JComboBox<>();
        jSeparator8 = new javax.swing.JSeparator();
        panelNombre5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxDescripcion = new javax.swing.JComboBox<>();
        jSeparator9 = new javax.swing.JSeparator();
        panelNombre6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cCertificado = new javax.swing.JComboBox<>();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        panelNombre7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbxEmpresa = new javax.swing.JComboBox<>();
        jSeparator12 = new javax.swing.JSeparator();
        panelNombre8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cAutorizar = new javax.swing.JComboBox<>();
        jSeparator13 = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(1040, 680));
        setPreferredSize(new java.awt.Dimension(1040, 680));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/formulario2.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Formulario de permisos y novedades.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 460, 100));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 440, 10));

        panelNombre1.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/puesto-de-trabajo.png"))); // NOI18N
        panelNombre1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Puesto");
        panelNombre1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        cbxPuesto.setBackground(new java.awt.Color(255, 255, 255));
        cbxPuesto.setForeground(new java.awt.Color(0, 0, 0));
        cbxPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chofer local", "Chofer de larga distancia", "Operario/a", "Administrativo/a", "Maestranza", "Otros", " " }));
        cbxPuesto.setSelectedIndex(-1);
        cbxPuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxPuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPuestoItemStateChanged(evt);
            }
        });
        cbxPuesto.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbxPuestoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbxPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPuestoActionPerformed(evt);
            }
        });
        panelNombre1.add(cbxPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 20));
        panelNombre1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 10));

        jPanel1.add(panelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 190, 90));

        panelNombre2.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/lista.png"))); // NOI18N
        panelNombre2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Motivo");
        panelNombre2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        cbxMotivos.setBackground(new java.awt.Color(255, 255, 255));
        cbxMotivos.setForeground(new java.awt.Color(0, 0, 0));
        cbxMotivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxMotivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMotivosActionPerformed(evt);
            }
        });
        panelNombre2.add(cbxMotivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 20));
        panelNombre2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 10));

        jPanel1.add(panelNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 190, 90));

        panelNombre3.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/departamento.png"))); // NOI18N
        panelNombre3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Sector");
        panelNombre3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        cSector.setBackground(new java.awt.Color(255, 255, 255));
        cSector.setForeground(new java.awt.Color(0, 0, 0));
        cSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administracion contable y finanzas", "Operaciones y Logistica", "RRHH Y Asuntos Regulatorios", "Comercial", "Maestranza", "Otros" }));
        cSector.setSelectedIndex(-1);
        cSector.setToolTipText("");
        cSector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cSector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cSectorItemStateChanged(evt);
            }
        });
        cSector.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cSectorPopupMenuWillBecomeVisible(evt);
            }
        });
        cSector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cSectorMouseClicked(evt);
            }
        });
        cSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSectorActionPerformed(evt);
            }
        });
        panelNombre3.add(cSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 20));
        panelNombre3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 190, 10));

        jPanel1.add(panelNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 190, 90));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Datos Empleado");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 240, 40));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(18, 30, 49));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 220, 10));

        panelNombre4.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/usuario.png"))); // NOI18N
        panelNombre4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Apellido y Nombre");
        panelNombre4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        cNombre.setBackground(new java.awt.Color(255, 255, 255));
        cNombre.setForeground(new java.awt.Color(0, 0, 0));
        cNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cNombre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cNombreItemStateChanged(evt);
            }
        });
        cNombre.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cNombrePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panelNombre4.add(cNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 20));
        panelNombre4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 10));

        jPanel1.add(panelNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 190, 90));

        panelNombre5.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/descripcion.png"))); // NOI18N
        panelNombre5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Descripcion");
        panelNombre5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        cbxDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        cbxDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        cbxDescripcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LLegada tarde", "Retiro anticipado", "Licencias", "Cuestiones disciplinarias", "Reconocimientos", "Ausencia", "Otros" }));
        cbxDescripcion.setSelectedIndex(-1);
        cbxDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDescripcionActionPerformed(evt);
            }
        });
        panelNombre5.add(cbxDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 20));
        panelNombre5.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 10));

        jPanel1.add(panelNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 190, 90));

        panelNombre6.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre6.setToolTipText("Esteban Petto\nJose Ferrari\nDiego Fernandez\nAlejandra Vazquez\n");
        panelNombre6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/certificado_1.png"))); // NOI18N
        panelNombre6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Certificado");
        panelNombre6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        cCertificado.setBackground(new java.awt.Color(255, 255, 255));
        cCertificado.setForeground(new java.awt.Color(0, 0, 0));
        cCertificado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        cCertificado.setSelectedIndex(-1);
        cCertificado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cCertificado.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cCertificadoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cCertificado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cCertificadoMouseEntered(evt);
            }
        });
        cCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCertificadoActionPerformed(evt);
            }
        });
        panelNombre6.add(cCertificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 20));
        panelNombre6.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 10));

        jPanel1.add(panelNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 190, 90));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Observacion");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/observacionn.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        observacion.setBackground(new java.awt.Color(255, 255, 255));
        observacion.setColumns(20);
        observacion.setForeground(new java.awt.Color(0, 0, 0));
        observacion.setLineWrap(true);
        observacion.setRows(5);
        observacion.setAutoscrolls(false);
        jScrollPane1.setViewportView(observacion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 320, 90));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Licencia y novedades");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 240, 40));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setForeground(new java.awt.Color(18, 30, 49));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 220, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/calendario.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Hasta");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, -1, -1));

        fechaFin.setBackground(new java.awt.Color(102, 255, 204));
        fechaFin.setForeground(new java.awt.Color(102, 255, 204));
        fechaFin.setDateFormatString("dd/MM/yy");
        jPanel1.add(fechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 160, 30));

        fechaInicio.setBackground(new java.awt.Color(102, 255, 204));
        fechaInicio.setForeground(new java.awt.Color(102, 255, 204));
        fechaInicio.setDateFormatString("d/MM/yy");
        fechaInicio.setMinimumSize(new java.awt.Dimension(45, 28));
        jPanel1.add(fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 160, 30));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Fecha");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, -1, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Desde");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/goma-de-borrar.png"))); // NOI18N
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Borrar");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 170, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/cheque.png"))); // NOI18N
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Generar");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 170, 40));

        panelNombre7.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/empresa.png"))); // NOI18N
        panelNombre7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, -1, -1));

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Empresa");
        panelNombre7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        cbxEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        cbxEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        cbxEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxEmpresa.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxEmpresaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbxEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbxEmpresaMouseEntered(evt);
            }
        });
        cbxEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmpresaActionPerformed(evt);
            }
        });
        panelNombre7.add(cbxEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 20));
        panelNombre7.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 10));

        jPanel1.add(panelNombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 190, 90));

        panelNombre8.setBackground(new java.awt.Color(255, 255, 255));
        panelNombre8.setToolTipText("Esteban Petto\nJose Ferrari\nDiego Fernandez\nAlejandra Vazquez\n");
        panelNombre8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursoshumanoszc/Interface/Imagenes/imagenesFormulario/Autorizar.png"))); // NOI18N
        panelNombre8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, -1, -1));

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Autoriza");
        panelNombre8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        cAutorizar.setBackground(new java.awt.Color(255, 255, 255));
        cAutorizar.setForeground(new java.awt.Color(0, 0, 0));
        cAutorizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esteban Petto", "Jose Ferrari", "Diego Fernandez", "Alejandra Vazquez", "Gonzalo Aguera" }));
        cAutorizar.setSelectedIndex(-1);
        cAutorizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cAutorizar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cAutorizarAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cAutorizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cAutorizarMouseEntered(evt);
            }
        });
        cAutorizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAutorizarActionPerformed(evt);
            }
        });
        panelNombre8.add(cAutorizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 20));
        panelNombre8.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 10));

        jPanel1.add(panelNombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 190, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDescripcionActionPerformed
        if (cbxDescripcion.getSelectedItem()!=null){

           cbxMotivos.removeAllItems();

           filtrarMotivos(con);
          
        }

    }//GEN-LAST:event_cbxDescripcionActionPerformed

    private void cSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSectorActionPerformed
            
    }//GEN-LAST:event_cSectorActionPerformed

    private void cSectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cSectorMouseClicked

    }//GEN-LAST:event_cSectorMouseClicked

    private void cSectorPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cSectorPopupMenuWillBecomeVisible

    }//GEN-LAST:event_cSectorPopupMenuWillBecomeVisible

    private void cbxPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPuestoActionPerformed

    private void cbxPuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPuestoItemStateChanged
      if (cbxPuesto.getSelectedItem()!=null){
        cNombre.removeAllItems();

        filtrarEmpleado(con);
        
      }
   

    }//GEN-LAST:event_cbxPuestoItemStateChanged

    private void cSectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cSectorItemStateChanged
       
    }//GEN-LAST:event_cSectorItemStateChanged

    private void cNombreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cNombreItemStateChanged
   
        
 
       
    }//GEN-LAST:event_cNombreItemStateChanged

    private void cCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCertificadoActionPerformed

    }//GEN-LAST:event_cCertificadoActionPerformed

    private void cCertificadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cCertificadoMouseEntered

    }//GEN-LAST:event_cCertificadoMouseEntered

    private void cCertificadoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cCertificadoAncestorAdded
        
    }//GEN-LAST:event_cCertificadoAncestorAdded

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
            reset();
        
       
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
       
        Color color = new Color(204, 204, 204);
        jPanel4.setBackground(color);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jPanel4.setBorder(border);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
      jPanel4.setBackground(Color.white);
      jPanel4.setBorder(null);
  
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        Color color = new Color(204, 204, 204);
        jPanel3.setBackground(color);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jPanel3.setBorder(border);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
       jPanel3.setBackground(Color.white);
       jPanel3.setBorder(null);
       
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
       if (cNombre.getItemAt(cNombre.getSelectedIndex())!=null &&cbxMotivos.getItemAt(cbxMotivos.getSelectedIndex())!=null ){
       
            
            
            
            SimpleDateFormat format = new SimpleDateFormat(fechaFin.getDateFormatString());
            String fechafin = format.format(fechaFin.getDate());
            String fechainicio = format.format(fechaInicio.getDate());
            String nombre = cNombre.getItemAt(cNombre.getSelectedIndex());
            String autoriza = cAutorizar.getItemAt(cAutorizar.getSelectedIndex());
            String fechaInicio = fechainicio;
            String fechaFin = fechafin;
            String tipoLicencia = cbxDescripcion.getItemAt(cbxDescripcion.getSelectedIndex());
            String observacion = this.observacion.getText();
            String sector = cSector.getItemAt(cSector.getSelectedIndex());
            String puesto = cbxPuesto.getItemAt(cbxPuesto.getSelectedIndex()); 
            String motivo = cbxMotivos.getItemAt(cbxMotivos.getSelectedIndex());
            String certificado = cCertificado.getItemAt(cCertificado.getSelectedIndex());

            String secuenciaInsert = String.format("INSERT INTO `Licencias`(`IDsolicitud`, `Nombre`, `Autoriza`, `Fecha`, `Fecha Fin`, `Tipo Licencia`, `Observacion`, `Sector`, `Puesto`, `Motivo` ,`Certficado` ) VALUES ('%d','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');"
                    , 0 ,nombre , autoriza , fechaInicio , fechaFin,tipoLicencia , observacion , sector , puesto , motivo , certificado );
            
            
            con.ejercutarSentenciaSQL(secuenciaInsert);
            generarPdf();
            reset();
            
            
            
  
            
        }
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void cbxEmpresaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxEmpresaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEmpresaAncestorAdded

    private void cbxEmpresaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEmpresaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEmpresaMouseEntered

    private void cbxEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEmpresaActionPerformed

    private void cAutorizarAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cAutorizarAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cAutorizarAncestorAdded

    private void cAutorizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cAutorizarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cAutorizarMouseEntered

    private void cAutorizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAutorizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cAutorizarActionPerformed

    private void cbxMotivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMotivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMotivosActionPerformed

    private void cbxPuestoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxPuestoPopupMenuWillBecomeInvisible
       
    }//GEN-LAST:event_cbxPuestoPopupMenuWillBecomeInvisible

    private void cNombrePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cNombrePopupMenuWillBecomeInvisible
           if (cNombre.getSelectedItem()!=null){
                
            cbxEmpresa.removeAllItems();
                
                String chofer = cNombre.getItemAt(cNombre.getSelectedIndex());
        
                
                ResultSet busqueda = con.consultarRegistros("SELECT * FROM   Empleado");

                try {
                    while (busqueda.next()){

                        if (chofer.equals(busqueda.getString("Nombre"))){

                                    cbxEmpresa.addItem(busqueda.getString("Empresa"));
                        }

                    }
                        } catch (SQLException ex) {
                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                cbxEmpresa.setVisible(true);

    }
    }//GEN-LAST:event_cNombrePopupMenuWillBecomeInvisible

    public void crearBoxes (JComboBox combo){
       combo.setUI(comboBox.createUI(combo)); 
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cAutorizar;
    private javax.swing.JComboBox<String> cCertificado;
    private javax.swing.JComboBox<String> cNombre;
    private javax.swing.JComboBox<String> cSector;
    private javax.swing.JComboBox<String> cbxDescripcion;
    private javax.swing.JComboBox<String> cbxEmpresa;
    private javax.swing.JComboBox<String> cbxMotivos;
    private javax.swing.JComboBox<String> cbxPuesto;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea observacion;
    private javax.swing.JPanel panelNombre1;
    private javax.swing.JPanel panelNombre2;
    private javax.swing.JPanel panelNombre3;
    private javax.swing.JPanel panelNombre4;
    private javax.swing.JPanel panelNombre5;
    private javax.swing.JPanel panelNombre6;
    private javax.swing.JPanel panelNombre7;
    private javax.swing.JPanel panelNombre8;
    // End of variables declaration//GEN-END:variables
}
