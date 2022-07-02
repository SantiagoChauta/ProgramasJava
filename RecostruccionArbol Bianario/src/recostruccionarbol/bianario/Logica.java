/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recostruccionarbol.bianario;

import javax.swing.JPanel;

public class Logica {

    Nodo raiz;
    String Inorden[];
    String otroRecorrido[];
    boolean mat[][];

    Logica() {
        raiz = null;
    }

    public void dibujar(String inorder, String otro, boolean preorden) {
        Inorden = inorder.split(",");
        otroRecorrido = otro.split(",");
        mat = new boolean[Inorden.length][Inorden.length];

        if (preorden) {
            raiz = new Nodo(otroRecorrido[0]);
            LlenarMatriz();
            Llenar(raiz, 0, posraiz(), mat.length);
        } else {
            raiz = new Nodo(otroRecorrido[otroRecorrido.length - 1]);
            girar();
            LlenarMatriz();
            Llenar(raiz, 0, posraiz(), mat.length);
        }
        System.out.println("Inorden");
        inorden(raiz);
        System.out.println("");
        System.out.println("Preorden");
        preorden(raiz);
        System.out.println("");
        System.out.println("Posorden");
        posorden(raiz);
    }

    private void LlenarMatriz() {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (otroRecorrido[i].equals(Inorden[j])) {
                    mat[i][j] = true;
                } else {
                    mat[i][j] = false;
                }
            }
        }
    }

    private void girar() {
        String aux[] = new String[otroRecorrido.length];
        for (int i = 0; i < otroRecorrido.length; i++) {
            aux[i] = otroRecorrido[otroRecorrido.length - 1 - i];

        }
        otroRecorrido = aux;

    }

    private void Llenar(Nodo r, int izq, int posraiz, int der) {
        try {
            for (int i = 1; i < mat.length; i++) {
                for (int j = izq; j < posraiz; j++) {
                    if (mat[i][j]) {
                        r.izq = new Nodo(otroRecorrido[i]);
                        Llenar(r.izq, izq, j, posraiz);
                        j = der;
                        i = mat.length;

                    }
                }
            }

        } catch (Exception e) {

        }
        try {
            for (int i = 1; i < mat.length; i++) {
                for (int j = posraiz + 1; j < der; j++) {
                    if (mat[i][j]) {
                        r.der = new Nodo(otroRecorrido[i]);
                        Llenar(r.der, posraiz + 1, j, der);
                        j = der;
                        i = mat.length;
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    void inorden(Nodo r) {
        if (r != null) {

            inorden(r.izq);
            System.out.print(r.info + " ");
            inorden(r.der);
        }
    }

    void posorden(Nodo r) {
        if (r != null) {

            posorden(r.izq);
            posorden(r.der);
            System.out.print(r.info + " ");
        }
    }

    void preorden(Nodo r) {
        if (r != null) {
            System.out.print(r.info + " ");
            preorden(r.izq);
            preorden(r.der);
        }
    }

    private int posraiz() {
        int aux = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat[0][i]) {
                aux = i;
            }
        }
        return aux;
    }

    public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }

}
