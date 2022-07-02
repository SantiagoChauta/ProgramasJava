
package cliente;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Cliente {

    public static void main(String[] args) {
        Modelo m = new Modelo(new Vista());
        m.escuchar(m);
    }
    
   
}

