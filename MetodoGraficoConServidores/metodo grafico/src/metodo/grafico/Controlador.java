package metodo.grafico;

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

public class Controlador implements ActionListener, KeyListener {

    modelo m;
    Vista v;
    int x,y,ecuaciones=0;
    boolean estado;
    public Controlador(modelo m, Vista v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = Integer.parseInt(v.objx.getText());
        y =Integer.parseInt(v.objy.getText());
        ecuaciones = Integer.parseInt(v.numinec.getText());
        
        if (e.getSource().equals(v.Crearcampos)) {
            if ( (x< 0) || (y < 0) || (ecuaciones < 1)) {
                if(ecuaciones<1){
                    JOptionPane.showMessageDialog(null, "minimo ingrese 1 ecuacion");
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor solo ingrese numeros positivos");
                }
                
            } else {

                if (v.max.isSelected()) {
                    estado=true;
                    m.crearcamposmax(v.p2, Integer.parseInt(v.numinec.getText()));
                    v.CambiarPaneles(v.p1, v.p2, Integer.parseInt(v.numinec.getText()));
                } else {
                    if (v.min.isSelected()) {
                        estado=false;
                        m.crearcamposmin(v.p2, Integer.parseInt(v.numinec.getText()));
                        v.CambiarPaneles(v.p1, v.p2, Integer.parseInt(v.numinec.getText()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor seleccione si es un minimo o un maximo");

                    }

                }
            }
        }

        if (e.getSource().equals(m.calcular)) {
            String cadena;
            
            try {
            Socket mis = new Socket("192.168.0.17",9915);
            DataOutputStream file_out = new DataOutputStream(mis.getOutputStream());
            
            cadena = v.objx.getText();
            cadena += " " + v.objy.getText();
            cadena += " " + Integer.toString(ecuaciones);
            
            
           for(int i=0;i<ecuaciones;i++){
                for(int j=0;j<2;j++){
                    cadena += " "+m.varmatriz[i][j].getText();
                }
                cadena+= " " + m.restriccion[i].getText();
            }
           
           file_out.writeUTF(cadena);
           file_out.writeBoolean(estado);
           file_out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public void escuchar(Controlador c) {
        v.Crearcampos.addActionListener(c);
        m.calcular.addActionListener(c);
        v.numinec.addKeyListener(c);
        v.objx.addKeyListener(c);
        v.objy.addKeyListener(c);
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int tecla = ke.getKeyCode();
        if ((tecla > 47 && tecla < 58) || (tecla == 8) || (tecla == 45)) {

        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese solo numeros");
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
