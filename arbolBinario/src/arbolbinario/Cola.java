/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

public class Cola {
    NodoCola cola;
    
    Cola(){
        cola = new NodoCola(null);
        cola.sig = cola;
    }
    
    public void sumar(Nodo objeto){
        NodoCola nuevo = new NodoCola(objeto);
        nuevo.sig = cola.sig;
        cola.sig = nuevo;
        cola = nuevo;
    }
    
    public Nodo atender(){
        NodoCola q,r;
        Nodo temp;
        if(cola == cola.sig){
            return null;
        }else{
            q = cola.sig;
            r = q.sig;
            temp = r.info;
            q.sig = r.sig;
            if(q == q.sig){
                cola = q;
            }
            return temp;
        }
        
        
    }
    
    boolean vacia(){
        return cola == cola.sig;
    }
    
    
}
