/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursoshumanoszc.Licencias;

/**
 *
 * @author Juanjo
 */
public class Licencia {
    
    private int id ;
    private String nombreApellido ;
    private String autoriza ;
    private String fechaInicio ;
    private String fechaFin;
    private String tipoLicencia ;
    private String Observacion ; 
    private String Sector ;
    private String Puesto ;
    private String motivo ;
    private String certificado;
    
    public Licencia (){
        
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }
    

    public Licencia(int id, String nombreApellido, String autoriza, String fechaInicio, 
            String fechaFin, String tipoLicencia, String Observacion, String Sector, String Puesto, String motivo) {
        this.id = id;
        this.nombreApellido = nombreApellido;
        this.autoriza = autoriza;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoLicencia = tipoLicencia;
        this.Observacion = Observacion;
        this.Sector = Sector;
        this.Puesto = Puesto;
        this.motivo = motivo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String Sector) {
        this.Sector = Sector;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", nombreApellido=" + nombreApellido + ", autoriza=" + autoriza 
                + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", tipoLicencia=" + tipoLicencia 
                + ", Observacion=" + Observacion + ", Sector=" + Sector + ", Puesto=" + Puesto + ", motivo=" + motivo + '}';
    }
    

}
