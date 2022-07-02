/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_mvc;

import Controlador.ControladorPersona;
import Modelo.ConsultaPersonas;
import Modelo.Persona;
import Vista.Vista;

/**
 *
 * @author Usuario
 */
public class CRUD_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista v =new Vista();
        Persona p = new Persona();
        ConsultaPersonas modelo = new ConsultaPersonas();
        
        ControladorPersona c = new ControladorPersona(v,p,modelo);
        c.iniciar();
    }
    
}
