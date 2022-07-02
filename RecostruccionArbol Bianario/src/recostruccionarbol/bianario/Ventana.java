/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recostruccionarbol.bianario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener {

    JPanel p1, recorrido;
    JLabel linorden, lpreorden, lpostorden;
    JTextField tfinorden, tfpreorden, tfpostorden;
    JButton bpreorden, bpostorden, bdibujar, bvolver;
    boolean preorden;
    Logica l;

    public Ventana() {
        crearComponenetes();
        crearVentana();
    }

    private void crearComponenetes() {
        l = new Logica();
        p1 = new JPanel();
        recorrido = new JPanel();
        p1.setLayout(null);
        recorrido.setLayout(null);
        linorden = new JLabel("inorden:");
        tfinorden = new JTextField();
        bpreorden = new JButton("Preorden");
        bpostorden = new JButton("Postorden");
        bdibujar = new JButton("Dibujar");
        bvolver = new JButton("Regresar");
        lpostorden = new JLabel("postorden: ");
        tfpostorden = new JTextField();
        bpreorden.setBounds(40, 50, 100, 30);
        bpreorden.addActionListener(this);
        bpostorden.setBounds(40, 90, 100, 30);
        bpostorden.addActionListener(this);
        bdibujar.addActionListener(this);
        bvolver.addActionListener(this);
        lpreorden = new JLabel("Preorden: ");
        tfpreorden = new JTextField();
        p1.add(bpreorden);
        p1.add(bpostorden);
    }

    private void crearVentana() {
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(p1);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bpreorden)) {

            linorden.setBounds(20, 40, 100, 20);
            lpreorden.setBounds(20, 80, 100, 20);
            tfinorden.setBounds(110, 40, 200, 20);
            tfpreorden.setBounds(110, 80, 200, 20);
            bdibujar.setBounds(80, 110, 100, 30);
            bvolver.setBounds(190, 110, 100, 30);
            recorrido.add(bvolver);
            recorrido.add(linorden);
            recorrido.add(tfinorden);
            recorrido.add(lpreorden);
            recorrido.add(tfpreorden);
            recorrido.add(bdibujar);
            preorden =true;
            cambioPanel(p1, recorrido, 400, 200);
        }

        if (ae.getSource().equals(bpostorden)) {

            linorden.setBounds(20, 40, 100, 20);
            lpostorden.setBounds(20, 80, 100, 20);
            tfinorden.setBounds(110, 40, 200, 20);
            tfpostorden.setBounds(110, 80, 200, 20);
            bdibujar.setBounds(80, 110, 100, 30);
            bvolver.setBounds(190, 110, 100, 30);
            recorrido.add(bvolver);
            recorrido.add(linorden);
            recorrido.add(tfinorden);
            recorrido.add(lpostorden);
            recorrido.add(tfpostorden);
            recorrido.add(bdibujar);
            preorden =false;
            cambioPanel(p1, recorrido, 400, 200);
        }
        if (ae.getSource().equals(bvolver)) {
            cambioPanel(recorrido, p1, 200, 200);
            recorrido.removeAll();
            tfinorden.setText("");
            tfpostorden.setText("");
            tfpreorden.setText("");
        }
        
        if(ae.getSource().equals(bdibujar)){
            if(preorden){
                l.dibujar(tfinorden.getText(), tfpreorden.getText(), true);    
               
            }else{
                l.dibujar(tfinorden.getText(), tfpostorden.getText(), false);
            }
            JFrame x = new JFrame();
            x.add(l.getdibujo());
            x.setSize(600, 500);
            x.setVisible(true);
            x.setLocationRelativeTo(null);
            
        }
    }

    private void cambioPanel(JPanel viejo, JPanel nuevo, int x, int y) {
        setVisible(false);
        remove(viejo);
        add(nuevo);
        setSize(x, y);
        setVisible(true);
    }

}
