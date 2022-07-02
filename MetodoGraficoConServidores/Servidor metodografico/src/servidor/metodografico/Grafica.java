package servidor.metodografico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Grafica {

    double puntosx[];
    double puntosy[];
    int numecuaciones, h = 0;
    double matrizcopy[][];
    boolean maxmin;
    double interseccionesx[];
    double interseccionesy[];
    int coefx, coefy;
    JPanel p;
    File fichero = new File("Grafica.jpg");
    String formato = "jpg";
    BufferedImage imagen;
    Graphics2D g2d;
    Graphics g;

    public void coordenadas0(double matriz[][], int ecuaciones, boolean estado, JPanel mip, int x, int y) {
        puntosx = new double[ecuaciones];
        puntosy = new double[ecuaciones];
        numecuaciones = ecuaciones;
        matrizcopy = matriz;
        maxmin = estado;
        interseccionesx = new double[numecuaciones * 2];
        interseccionesy = new double[numecuaciones * 2];
        p = mip;
        coefx = x;
        coefy = y;

        for (int i = 0; i < ecuaciones; i++) {
            puntosy[i] = (matriz[i][2] / matriz[i][1]);
        }
        for (int i = 0; i < ecuaciones; i++) {
            puntosx[i] = (matriz[i][2] / matriz[i][0]);
        }
        gauss(matriz);
    }

    public void gauss(double matriz[][]) {
        double rectaA[] = new double[3];
        double rectaB[] = new double[3];
        double multiplicador = 0;
        for (int i = 0; i < numecuaciones; i++) {
            for (int k = i + 1; k < numecuaciones; k++) {
                rectaA = Asignarrecta(matriz, i);
                rectaB = Asignarrecta(matriz, k);
                interseccionrectas(rectaA, rectaB);
            }
        }
        Verificarrestriciones(interseccionesx, interseccionesy);

    }

    private double[] Asignarrecta(double[][] matriz, int pos) {
        double recta[] = new double[3];
        for (int i = 0; i < 3; i++) {
            recta[i] = matriz[pos][i];
        }
        return recta;
    }

    private void interseccionrectas(double[] rectaA, double[] rectaB) {
        double multiplicadorA = Math.pow(rectaA[0], -1);
        double FactorA, FactorB;
        FactorA = rectaB[0] * -1;

        for (int i = 0; i < 3; i++) {
            rectaA[i] *= multiplicadorA;
            rectaB[i] = (rectaB[i] + (rectaA[i] * FactorA));
        }

        double multiplicadorB = Math.pow(rectaB[1], -1);
        FactorB = rectaA[1] * -1;
        for (int i = 0; i < 3; i++) {
            rectaB[i] *= multiplicadorB;
            rectaA[i] = (rectaA[i] + (rectaB[i] * FactorB));
        }
        interseccionesx[h] = rectaA[2];
        interseccionesy[h] = rectaB[2];
        h++;

    }

    private void Verificarrestriciones(double[] coorx, double[] coory) {
        double x1, x2, restri, valor;
        boolean cumple = true;
        int k = 0;
        if (maxmin) {
            for (int i = 0; i < coorx.length; i++) {
                for (int j = 0; j < numecuaciones; j++) {
                    x1 = matrizcopy[j][0] * coorx[i];
                    x2 = matrizcopy[j][1] * coory[i];
                    valor = x1 + x2;
                    restri = matrizcopy[j][2];
                    if (valor > restri) {
                        cumple = false;
                    }
                }
                if (cumple && coorx[i] > 0 && coory[i] > 0) {
                    k++;

                }
                cumple = true;
            }
        } else {
            for (int i = 0; i < coorx.length; i++) {
                for (int j = 0; j < numecuaciones; j++) {
                    x1 = matrizcopy[j][0] * coorx[i];
                    x2 = matrizcopy[j][1] * coory[i];
                    valor = x1 + x2;
                    restri = matrizcopy[j][2];
                    if (valor < restri) {
                        cumple = false;
                    }
                }
                if (cumple && coorx[i] > 0 && coory[i] > 0) {
                    k++;
                }
                cumple = true;

            }
        }
        double puntosxvalido[];
        double puntosyvalido[];
        if (maxmin) {
            puntosxvalido = new double[k + 3];
            puntosyvalido = new double[k + 3];
        } else {
            puntosxvalido = new double[k + 5];
            puntosyvalido = new double[k + 5];

        }

        k = 0;
        if (maxmin) {
            for (int i = 0; i < coorx.length; i++) {
                for (int j = 0; j < numecuaciones; j++) {
                    x1 = matrizcopy[j][0] * coorx[i];
                    x2 = matrizcopy[j][1] * coory[i];
                    valor = x1 + x2;
                    restri = matrizcopy[j][2];
                    if (valor > restri) {
                        cumple = false;
                    }
                }
                if (cumple && coorx[i] > 0 && coory[i] > 0) {
                    puntosxvalido[k] = coorx[i];
                    puntosyvalido[k] = coory[i];
                    k++;
                }
                cumple = true;
            }
        } else {
            for (int i = 0; i < coorx.length; i++) {
                for (int j = 0; j < numecuaciones; j++) {
                    x1 = matrizcopy[j][0] * coorx[i];
                    x2 = matrizcopy[j][1] * coory[i];
                    valor = x1 + x2;
                    restri = matrizcopy[j][2];
                    if (valor < restri) {
                        cumple = false;
                    }
                }
                if (cumple && coorx[i] > 0 && coory[i] > 0) {
                    puntosxvalido[k] = coorx[i];
                    puntosyvalido[k] = coory[i];
                    k++;
                }
                cumple = true;
            }
        }
        double masbajoy;
        double masbajox;
        if (maxmin) {
            masbajoy = maspequeño(puntosy);
            masbajox = maspequeño(puntosx);
            puntosxvalido[k] = masbajox;
            puntosyvalido[k] = 0;
            puntosxvalido[k + 1] = 0;
            puntosyvalido[k + 1] = masbajoy;
            puntosxvalido[k + 2] = 0;
            puntosyvalido[k + 2] = 0;
        }else{
            masbajox = masgrande(puntosx);
            masbajoy = masgrande(puntosy);
            puntosxvalido[k] = masbajox;
            puntosyvalido[k] = 0;
            puntosxvalido[k + 1] = 0;
            puntosyvalido[k + 1] = masbajoy;
            puntosxvalido[k + 2] = masbajox + 50;
            puntosyvalido[k + 2] = 0;
            puntosxvalido[k + 3] = masbajox+50;
            puntosyvalido[k + 3] = masbajoy+50;
            puntosxvalido[k + 4] = 0;
            puntosyvalido[k + 4] = masbajoy+50;
            
           
            
        }

        String resultado = evaluarfuncion(puntosxvalido, puntosyvalido);
        System.out.println("EL resultado es: " + resultado);
        pintarresctas(puntosxvalido, puntosyvalido);

    }

    private double maspequeño(double[] puntosx) {
        double aux = puntosx[0];
        for (int i = 0; i < puntosx.length; i++) {
            if (aux <= puntosx[i]) {

            } else {
                aux = puntosx[i];
                i = 0;
            }
        }
        return aux;
    }

    private void pintarresctas(double[] puntosxvalido, double[] puntosyvalido) {
        double valorx = masgrande(puntosx);
        double valory = masgrande(puntosy);
        double mayor;
        int multiplicador;
        if (valorx > valory) {
            mayor = valorx;
        } else {
            mayor = valory;
        }
        if (mayor > 180) {
            multiplicador = 1;
        } else {
            multiplicador = 2;
        }
        Graphics g = p.getGraphics();
        g.drawLine(40, 80, 40, 400);
        g.drawLine(40, 400, 400, 400);
        
        
        if(maxmin){
            ordenar(puntosxvalido, puntosyvalido,1);
        }
        else{
            ordenar(puntosxvalido, puntosyvalido, 3);
        }
        
        int pux[] = new int[puntosxvalido.length];
        int puy[] = new int[puntosxvalido.length];

        for (int i = 0; i < puntosx.length; i++) {
            g.drawLine(40, 400 - multiplicador * (int) puntosy[i], 40 + multiplicador * (int) puntosx[i], 400);
        }
        
        for (int i = 0; i < puntosxvalido.length; i++) {
            pux[i] = 40 + (int) puntosxvalido[i] * multiplicador;
            puy[i] = 400 - (int) puntosyvalido[i] * multiplicador;
        }
        
        g.fillPolygon(pux, puy, pux.length);
        
        guardarimagen();
    }

    private double masgrande(double[] puntosx) {
        double aux = puntosx[0];
        for (int i = 0; i < puntosx.length; i++) {
            if (aux >= puntosx[i]) {

            } else {
                aux = puntosx[i];
                i = 0;
            }
        }
        return aux;
    }

    private String evaluarfuncion(double[] puntosxvalido, double[] puntosyvalido) {
        double aux = coefx * puntosxvalido[0] + coefy * puntosyvalido[0];
        double valor;
        double x = puntosxvalido[0];
        double y = puntosyvalido[0];
       
        if (maxmin) {
            for (int i = 0; i < puntosxvalido.length; i++) {
                valor = coefx * puntosxvalido[i] + coefy * puntosyvalido[i];
                if (aux >= valor) {

                } else {
                    aux = valor;
                    x = puntosxvalido[i];
                    y= puntosyvalido[i];
                    i = 0;
                }
            }
        } else {
            for (int i = 0; i < puntosxvalido.length; i++) {
                valor = coefx * puntosxvalido[i] + coefy * puntosyvalido[i];
                if (aux <= valor) {

                } else {
                    aux = valor;
                    x = puntosxvalido[i];
                    y= puntosyvalido[i];
                    i = 0;
                }
            }
        }
        String resultado = "z= "+aux+", x1="+x+", x2= "+y;
        
        return resultado;
    }

    private void ordenar(double[] puntosxvalido, double[] puntosyvalido,int resta) {
        double aux, auxy;
        for (int i = 0; i < puntosxvalido.length - resta; i++) {
            for (int j = 0; j < puntosxvalido.length - resta; j++) {
                if (puntosxvalido[i] < puntosxvalido[j]) {
                    aux = puntosxvalido[j];
                    auxy = puntosyvalido[j];
                    puntosxvalido[j] = puntosxvalido[i];
                    puntosyvalido[j] = puntosyvalido[i];
                    puntosxvalido[i] = aux;
                    puntosyvalido[i] = auxy;
                    j = 0;
                }
            }

        }
    }

    private void guardarimagen() {
        int w = 500;
        int h = 500;
        imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        g2d = (Graphics2D) imagen.getGraphics();

        p.paint(g2d);
        try {
            ImageIO.write(imagen, formato, fichero);
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

}
