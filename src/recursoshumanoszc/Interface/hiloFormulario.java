/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursoshumanoszc.Interface;

import java.awt.BorderLayout;

/**
 *
 * @author Juanjo
 */
public class hiloFormulario implements Runnable{
    
    @Override
    public void run() {
        prueba();
    }
    
    public void prueba (){
       
        menuInicio menu = new menuInicio() ;
        cargando nuevo = new cargando ();
        nuevo.setVisible(true);
        nuevo.setLocationRelativeTo(nuevo);
        nuevo.setSize(420, 165);
        Formulario  form = new Formulario ();
        form.setSize (1040,680);
        

      
        
    }
    
}
