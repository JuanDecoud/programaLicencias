/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursoshumanoszc.Licencias;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juanjo
 */
public class tipoLicencias {
    
    private int id ;
    private String descripcion ;
    private List<motivosLicencia>list ;
    
    
    
    public tipoLicencias (){
    
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<motivosLicencia> getList() {
        return list;
    }

    public void setList(List<motivosLicencia> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "tipoLicencias{" + "id=" + id + ", descripcion=" + descripcion + ", list=" + list + '}';
    }
    

    
}
