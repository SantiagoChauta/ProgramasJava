/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Estudiantes
 */
public class Vista extends JFrame {
    
    JPanel p1;
    JTextField numero = new JTextField();
    JLabel mensaje = new JLabel("Ingrese el numero a enviar");
    JButton b1 = new JButton("Enviar");
    
    
    public Vista(){
        CrearPanel();
        CrearVentan();
    }

    private void CrearPanel() {
        p1 = new JPanel();
        p1.setLayout(null);
        mensaje.setBounds(40, 20, 200, 30);
        b1.setBounds(100, 100, 70, 30);
        numero.setBounds(40, 60, 50, 30);
        p1.add(mensaje);
        p1.add(numero);
        p1.add(b1);
    }

    private void CrearVentan() {
        setSize(300,200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(p1);
        setLocationRelativeTo(null);
        setTitle("Cliente");
        setVisible(true);
    }
    
}
