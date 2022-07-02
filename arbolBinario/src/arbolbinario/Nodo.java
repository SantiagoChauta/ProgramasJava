/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

/**
 *
 * @author JANUS
 */
class Nodo {
    int info;
    int alt;
    Nodo izq;
    Nodo der;
    Nodo(int info){
        this.info = info;
        alt = 0;
        izq=der=null;
    }
    
}
