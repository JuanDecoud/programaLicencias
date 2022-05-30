/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursoshumanoszc.Licencias;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class motivosLicencia {
    
    private int id ;
    private String motivo ;
    private String tipoLicencia ;
    
    
    public motivosLicencia (){
        
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "motivosLicencia{" + "id=" + id + ", motivo=" 
                + motivo + ", tipoLicencia=" + tipoLicencia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.tipoLicencia);
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
        final motivosLicencia other = (motivosLicencia) obj;
        return Objects.equals(this.tipoLicencia, other.tipoLicencia);
    }
    
    
    
    
    
    
    

 
  

   
    
    
    


    
    
    
    
    
    
}
