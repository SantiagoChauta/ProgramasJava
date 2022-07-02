
package servidor;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Vista extends JFrame {
    
    JPanel p1;
    JTextArea campo = new JTextArea();
    JTextArea campo1 = new JTextArea();
    JLabel mensaje2 = new JLabel("La raiz del numero enviado es:");
    JLabel mensaje = new JLabel("El numero enviado es:");
    
    
    public Vista(){
        CrearPanel();
        CrearVentan();
    }

    private void CrearPanel() {
        p1 = new JPanel();
        p1.setLayout(null);
        mensaje.setBounds(40, 20, 200, 30);
        campo.setBounds(40, 70, 50, 30);
        campo.setBorder(BorderFactory.createLineBorder(Color.black));
        campo.setEditable(false);
        mensaje2.setBounds(40, 120, 200, 30);
        campo1.setBounds(40,170,140,30);
        campo1.setBorder(BorderFactory.createLineBorder(Color.black));
        campo1.setEditable(false);
        p1.add(mensaje);
        p1.add(mensaje2);
        p1.add(campo);
        p1.add(campo1);
    }

    private void CrearVentan() {
        setSize(300,300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(p1);
        setLocationRelativeTo(null);
        setTitle("Servidor");
        setVisible(true);
    }
    
}
