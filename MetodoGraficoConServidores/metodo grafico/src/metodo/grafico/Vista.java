
package metodo.grafico;

import java.awt.Font;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Vista extends JFrame{
    
    JPanel p1,p2;
    JTextField objx,objy,numinec;
    JLabel mensaje1 = new JLabel("Ingrese el numero de inecuaciones:");
    JLabel mensaje2 = new JLabel("Ingrese los valores");
    JLabel titulo = new JLabel("Metodo Gráfico");
    JLabel titulo2 = new JLabel("Metodo Gráfico");
    JLabel menx = new JLabel("coeficiente x:");        
    JLabel meny = new JLabel("coeficiente y:");        
    JLabel funobje = new JLabel("Funcion objetivo");        
    JButton Crearcampos;
    JRadioButton max,min;
    
    public Vista(){
        crearPanel();
        Crearradiobotones();
        crearVentana();
    }

    private void crearPanel() {
       p1 = new JPanel();
       p1.setLayout(null);
       p2 = new JPanel();
       p2.setLayout(null);
       mensaje2.setBounds(30, 110, 110, 20);
       objx = new JTextField();
       objy = new JTextField();
       numinec = new JTextField();
       Crearcampos = new JButton("Crear campos para las inecuaciones");
       titulo.setBounds(150, 20, 220, 50);
       titulo2.setBounds(150, 20, 220, 50);
       titulo.setFont(new Font("Arial",3,30));
       titulo2.setFont(new Font("Arial",3,30));
       funobje.setBounds(30, 70, 200, 30);
       menx.setBounds(30, 110, 90, 20);
       meny.setBounds(140, 110, 90, 20);
       objx.setBounds(110, 110, 25, 20);
       objy.setBounds(220, 110, 25, 20);
       mensaje1.setBounds(30, 140, 220,20);
       numinec.setBounds(240,140,30,20);
       Crearcampos.setBounds(110, 200, 250, 20);
       p1.add(titulo);
       p1.add(menx);
       p1.add(meny);
       p1.add(funobje);
       p1.add(objx);
       p1.add(objy);
       p1.add(mensaje1); 
       p1.add(numinec);
       p1.add(Crearcampos);
       p2.add(titulo2);
       p2.add(mensaje2);
    }
    
    private void crearVentana() {
        setSize(500,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(p1);
        setVisible(true);
        
    }

     public void CambiarPaneles(JPanel pv, JPanel pn,int ec){//hace el cambio de paneles
        this.setVisible(false);
        this.remove(pv);
        this.add(pn);
        this.setSize(500, 230 + (ec * 30));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
     
      public void Crearradiobotones(){//hace el cambio de paneles
        max = new JRadioButton("Maximo",false);
        min = new JRadioButton("Minimo", false);
        max.setBounds(300, 100, 100, 20);
        min.setBounds(300, 140, 100, 20);
        ButtonGroup maximin = new ButtonGroup();
        maximin.add(max);
        maximin.add(min);
        p1.add(max);
        p1.add(min);
    }
}
