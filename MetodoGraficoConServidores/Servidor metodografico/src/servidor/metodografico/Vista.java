/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.metodografico;
import java.awt.Font;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vista extends JFrame {
    
    JPanel p1;
    JLabel mensaje = new JLabel("Metodo gráfico");
    
    
    public Vista(){
        CrearPanel();
        CrearVentan();
    }

    private void CrearPanel() {
        p1 = new JPanel();
        p1.setLayout(null);
        mensaje.setFont(new Font("Arial Black",2,30));
        mensaje.setBounds(120, 20, 300, 50);
        p1.add(mensaje);
    }

    private void CrearVentan() {
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(p1);
        setLocationRelativeTo(null);
        setTitle("Servidor");
        setVisible(true);
    }
    
}