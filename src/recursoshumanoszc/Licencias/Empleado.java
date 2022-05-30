
package recursoshumanoszc.Licencias;

import java.util.Objects;


public class Empleado {
    
    private int id ;
    private String nombreYapellido ;
    private String dni ;
    private String puesto ;
    private String sector ;
    private String empresa ;
    
 

    public Empleado(int id, String nombreYapellido, String dni, String puesto, String sector, String empresa) {
        this.id = id;
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
        this.puesto = puesto;
        this.sector = sector;
        this.empresa = empresa;
    }
    
    public Empleado (String sector , String puesto){
        this.sector = sector ;
        this.puesto=puesto ;
    
    }
    
    public Empleado (){
    
    }
    
    

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public void setNombreYapellido(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.puesto);
        hash = 41 * hash + Objects.hashCode(this.sector);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.puesto, other.puesto)) {
            return false;
        }
        return Objects.equals(this.sector, other.sector);
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombreYapellido=" + nombreYapellido + ", dni=" + dni 
                + ", puesto=" + puesto + ", sector=" + sector + ", empresa=" + empresa + '}';
    }
    
    
    

 
    
    

}