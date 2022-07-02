
package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Modelo implements ActionListener, KeyListener{
    Vista v;
    
    public Modelo(Vista v){
        this.v =v;
    }
    
    public void escuchar(Modelo c){
        v.b1.addActionListener(c);
        v.numero.addKeyListener(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {  
        try {
            Socket mis = new Socket("10.20.150.104",9999);
            DataOutputStream file_out = new DataOutputStream(mis.getOutputStream());
            
            file_out.writeUTF(v.numero.getText());
            
            file_out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int tecla = e.getKeyCode();
         if((tecla>47 && tecla<58) || (tecla==8) || (tecla==109) || (tecla==45) ||(tecla>95 && tecla<106)){
             
         }else{
             JOptionPane.showMessageDialog(null, "Por favor ingrese unicamente numeros");
             v.numero.setText("");
         }
    }

    @Override
    public void keyReleased(KeyEvent e){
    }
  
    
}
