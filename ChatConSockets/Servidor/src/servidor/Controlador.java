/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiantes
 */
public class Controlador implements Runnable {

    Vista v;

    public Controlador(Vista v) {
        this.v = v;
        Thread mihilo = new Thread(this);

        mihilo.start();
    }

    @Override
    public void run() {

        try {
            ServerSocket miss = new ServerSocket(9999);
            while (true) {
                Socket misocket = miss.accept();

                DataInputStream flujo_in = new DataInputStream(misocket.getInputStream());

                String mensajellegada = flujo_in.readUTF();

                v.campo.setText(mensajellegada);
                
                double raiz =Calcularraiz(mensajellegada);
                if(raiz>=0){
                    v.campo1.setText(Double.toString(raiz));
                }else{
                    v.campo1.setText("No Existe Raiz de numeros negativos");
                }
                
                misocket.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private double Calcularraiz(String mensajellegada) {
        double numero = Double.parseDouble(mensajellegada);
        numero = Math.sqrt(numero);
        return numero;
        
    }

}
