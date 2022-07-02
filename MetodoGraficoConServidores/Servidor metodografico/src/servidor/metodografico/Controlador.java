/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.metodografico;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador implements Runnable {

    Vista v;
    double matriz[][];
    int numeroecuaciones;
    int x,y;
    Grafica g;
    public Controlador(Vista v) {
        this.v = v;
        Thread mihilo = new Thread(this);
        g= new Grafica();
        mihilo.start();
    }

    @Override
    public void run() {

        try {
            ServerSocket miss = new ServerSocket(9915);
            while (true) {
                Socket misocket = miss.accept();

                DataInputStream flujo_in = new DataInputStream(misocket.getInputStream());

                String mensajellegada = flujo_in.readUTF();               
                boolean estado = flujo_in.readBoolean();
                String mensa[]= mensajellegada.split(" ");
                matriz = decodificarmatriz(mensa);
                g.coordenadas0(matriz,numeroecuaciones,estado,v.p1,x,y);
                
                misocket.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private double[][] decodificarmatriz(String mensajellegada[]) {
        int k=3;
        
        x = Integer.parseInt(mensajellegada[0]);
        y = Integer.parseInt(mensajellegada[1]);
        numeroecuaciones = Integer.parseInt(mensajellegada[2]);
        
        double matrizz[][] = new double[numeroecuaciones][3];
        
        for(int i=0; i<numeroecuaciones;i++){
            for(int j=0;j<3;j++){
                matrizz[i][j]= Double.parseDouble(mensajellegada[k]);
                k++;
            }
        }
        
        System.out.println("La funcion objetivo es: " + (x*-1)+" + "+(y*-1)+" =z");
        
        System.out.println("El numero de escuaciones son: "+ numeroecuaciones);
        for(int i=0; i<numeroecuaciones;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrizz[i][j]+" ");
            }
            System.out.println("");
        }
        return matrizz;
    }
  
}