
package recursoshumanoszc.Interface.ConexionSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import recursoshumanoszc.Licencias.Empleado;
import recursoshumanoszc.Licencias.Licencia;


public class Conexion {
    
    String bd = "juandeco_licencias";
    String url ="jdbc:mysql://cpl27.main-hosting.eu:3306/";
    String user="juandeco_juan";
    String password="145623";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx ;
    
    public Conexion (){
        
    }
    
    public Connection conectar (){
       
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("Conectado a la base");
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("Error");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return cx ;
    }
    
    
        public void desconectar(){
    
        try {
            cx.close();
                System.out.println("Desconectado de la base");
                    } catch (SQLException ex) {
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int ejercutarSentenciaSQL (String strSentenciaSQL){
    
        try{
            PreparedStatement  pstm = cx.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1 ;
        }catch (SQLException e){
            System.out.println(e);
            return 0 ;
        }
    
    }
    
    
    public ResultSet consultarRegistros (String strSentencianSQL){
    
            try{
                PreparedStatement pstm = cx.prepareStatement(strSentencianSQL);
                ResultSet respuesta = pstm.executeQuery();
                
                return respuesta ;
                
            }catch (Exception e){
                System.out.println(e);
                return null ;
            }
    
    }
    
        public List<Empleado> obtenerEmpleados (){
        
       List <Empleado> choferes = new ArrayList<>();

        Conexion con = new Conexion ();
        con.conectar();
        ResultSet busqueda = con.consultarRegistros("SELECT * FROM Empleado");
        
        try {
            while (busqueda.next()){
                
                
                Empleado empleado = new Empleado ();
                
                empleado.setId(Integer.parseInt(busqueda.getString("id")));
                empleado.setNombreYapellido(busqueda.getString("Nombre y Apellido"));
                empleado.setDni(busqueda.getString("DNI"));
                empleado.setPuesto(busqueda.getString("Puesto"));
                empleado.setSector(busqueda.getString("Sector"));
                empleado.setEmpresa(busqueda.getString("Empresa"));
                
             
                choferes.add(empleado);
                                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        

       return choferes ;
        

    }
        
        public List <Licencia> obtenerSolicitudes (){
    
        Conexion con = new Conexion ();
        List <Licencia> solicitudes = new ArrayList <> ();

        con.conectar();
        
        ResultSet consulta = con.consultarRegistros("SELECT * FROM Licencias ");
        
        try {
            while (consulta.next()){
                Licencia licencia = new Licencia ();
                
                int id = Integer.parseInt(consulta.getString("IDsolicitud"));
                licencia.setId(id);
                licencia.setNombreApellido(consulta.getString("Nombre y Apellido"));
                licencia.setAutoriza(consulta.getString("Autoriza"));
                licencia.setFechaInicio(consulta.getString("Fecha Inicio"));
                licencia.setFechaFin(consulta.getString("Fecha Fin"));
                licencia.setObservacion(consulta.getString("Tipo Licencia"));
                licencia.setObservacion(consulta.getString("Observacion"));
                solicitudes.add(licencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return solicitudes;
        
    }
        
        
        
    
    
    
}
    
    
    
    
    

