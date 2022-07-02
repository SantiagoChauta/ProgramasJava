/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recostruccionarbol.bianario;

class Nodo {

//miembros de acceso
    Nodo izq;
    String info;
    Nodo der;

//iniciar dato y hacer de este nodo un nodo hoja
    public Nodo(String datosNodo) {
        info = datosNodo;
        izq = der = null; //el nodo no tiene hijos
    }

}
