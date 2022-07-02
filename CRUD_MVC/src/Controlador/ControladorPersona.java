/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultaPersonas;
import Modelo.Persona;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorPersona implements ActionListener {

    private Vista vista;
    private Persona persona;
    private ConsultaPersonas modelo;

    public ControladorPersona(Vista vista, Persona persona, ConsultaPersonas cp) {
        this.vista = vista;
        this.persona = persona;
        this.modelo = cp;
        this.vista.botonInsertar.addActionListener(this);
        this.vista.botonLimpiar.addActionListener(this);
        this.vista.botonModificar.addActionListener(this);
        this.vista.botonEliminar.addActionListener(this);
        this.vista.botonBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("CRUD MVC");
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.cajaId.setVisible(false);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.botonInsertar)) {
            persona.setClave(vista.cajaClave.getText());
            persona.setNombre(vista.cajaNombre.getText());
            persona.setDomicilio(vista.cajaDomicilio.getText());
            persona.setCelular(vista.cajaCelular.getText());
            persona.setCorreoElectronico(vista.cajaCorreoElectronico.getText());
            persona.setFechaNacimiento(Date.valueOf(vista.cajaFechaNacimiento.getText()));
            persona.setGenero(vista.comboGenero.getSelectedItem().toString());

            if (modelo.insertarPersonas(persona)) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                
            } else {
                JOptionPane.showMessageDialog(null, "Registro fallido");
            }
            limpiarCajas();
        }

        if (e.getSource().equals(vista.botonLimpiar)) {
            limpiarCajas();
        }

        if (e.getSource().equals(vista.botonBuscar)) {
            persona.setClave(vista.cajaBuscar.getText());
            if (modelo.buscarPersona(persona)) {
                vista.cajaId.setText(Integer.toString(persona.getIdPersona()));
                vista.cajaClave.setText(persona.getClave());
                vista.cajaNombre.setText(persona.getNombre());
                vista.cajaDomicilio.setText(persona.getDomicilio());
                vista.cajaCelular.setText(persona.getCelular());
                vista.cajaCorreoElectronico.setText(persona.getCorreoElectronico());
                vista.cajaFechaNacimiento.setText(String.valueOf(persona.getFechaNacimiento()));
                vista.comboGenero.setSelectedItem(persona.getGenero());
            } else {
                JOptionPane.showMessageDialog(null, "No existe una persona con esa clave");
                limpiarCajas();
            }

        }

        if (e.getSource().equals(vista.botonModificar)) {
            persona.setIdPersona(Integer.parseInt(vista.cajaId.getText()));
            persona.setClave(vista.cajaClave.getText());
            persona.setNombre(vista.cajaNombre.getText());
            persona.setDomicilio(vista.cajaDomicilio.getText());
            persona.setCelular(vista.cajaCelular.getText());
            persona.setCorreoElectronico(vista.cajaCorreoElectronico.getText());
            persona.setFechaNacimiento(Date.valueOf(vista.cajaFechaNacimiento.getText()));
            persona.setGenero(vista.comboGenero.getSelectedItem().toString());
            
            if(modelo.modificarPersona(persona)){
                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "Modificacion fallida");
            }
            limpiarCajas();
        }
        
        if(e.getSource().equals(vista.botonEliminar)){
            persona.setIdPersona(Integer.parseInt(vista.cajaId.getText()));
            if(modelo.eliminarPersona(persona)){
                JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "Eliminicaion fallida");
            }
        }
        
    }

    private void limpiarCajas() {
        vista.cajaId.setText("");
        vista.cajaBuscar.setText("");
        vista.cajaNombre.setText("");
        vista.cajaCelular.setText("");
        vista.cajaClave.setText("");
        vista.cajaCorreoElectronico.setText("");
        vista.cajaDomicilio.setText("");
        vista.cajaFechaNacimiento.setText("");
        vista.comboGenero.setSelectedIndex(0);
    }

}
