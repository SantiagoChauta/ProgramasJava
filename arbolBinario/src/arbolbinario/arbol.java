    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

class arbol {

    Nodo raiz;
    int valor = 1;
    ArrayList<Integer> niv;
    String posrden = "", inorden = "", preorden = "", niveles = "";

    arbol() {
        raiz = null;
        niv = new ArrayList();
    }

    int insertar(int dato) {
        Nodo p, q, nuevo;
        p = raiz;
        if (p == null) {
            raiz = new Nodo(dato);
            raiz.alt = 1;
            return 1;
        }
        q = null;
        while (p != null) {
            if (dato < p.info) {
                q = p;
                p = p.izq;
            } else if (dato > p.info) {
                q = p;
                p = p.der;
            } else {
                return -1;
            }
        }
        nuevo = new Nodo(dato);
        if (dato < q.info) {
            q.izq = nuevo;
            q.izq.alt = q.alt + 1;
        } else {
            q.der = nuevo;
            q.der.alt = q.alt + 1;
        }
        return 1;

    }

    String inorden(Nodo r) {
        if (r != null) {

            inorden(r.izq);
            inorden += r.info + ",";
            System.out.print(r.info + " ");
            inorden(r.der);
        }
        return inorden;
    }

    String posorden(Nodo r) {
        if (r != null) {

            posorden(r.izq);
            posorden(r.der);
            posrden += r.info + " ";
            System.out.print(r.info + " ");
        }
        return posrden;
    }

    public int amplitud(Nodo p) //SE RECIBE LA RAIZ DEL ARBOL
    {
        Cola cola = new Cola();
        int i=0;
        while(p!=null){
            cola.sumar(p);
            p = p.izq;
        }
        
        while(!cola.vacia()){
            p = cola.atender();
            if(p.izq == null && p.der == null){
                i++;
            }
            p = p.der;
            while(p!= null){
                cola.sumar(p);
                p = p.izq;
            }
        }
        return i;
    }

    String preorden(Nodo r) {
        if (r != null) {
            preorden += r.info + " ";
            System.out.print(r.info + " ");
            preorden(r.izq);
            preorden(r.der);
        }
        return preorden;
    }

    int altura(Nodo r) {
        if (r == null) {
            return 0;
        }
        return Math.max(altura(r.izq), altura(r.der)) + 1;
    }

    void niveles(Nodo p) {

        Cola cola = null;
        int fila = 0;
        int x = 100;
        int y = 30;
        if (p != null) {
            cola = new Cola();
            cola.sumar(p);
        }
        while (!cola.vacia()) {
            p = cola.atender();
            niv.add(p.info);
            if (p.izq != null) {
                cola.sumar(p.izq);
            }
            if (p.der != null) {
                cola.sumar(p.der);

            }
        }

    }

    public boolean eliminar(int n) {
        Nodo auxiliar = raiz;
        Nodo padre = raiz;
        boolean esizquierdo = true;
        while (auxiliar.info != n) {
            padre = auxiliar;
            if (n < auxiliar.info) {
                esizquierdo = true;
                auxiliar = auxiliar.izq;
            } else {
                esizquierdo = false;
                auxiliar = auxiliar.der;
            }
            if (auxiliar == null) {
                return false;
            }
        }

        if (auxiliar.izq == null && auxiliar.der == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (esizquierdo) {
                padre.izq = null;
            } else {
                padre.der = null;
            }
        } else if (auxiliar.der == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.izq;
            } else if (esizquierdo) {
                padre.izq = auxiliar.izq;
            } else {
                padre.der = auxiliar.izq;
            }
        } else if (auxiliar.izq == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.der;
            } else if (esizquierdo) {
                padre.izq = auxiliar.der;
            } else {
                padre.der = auxiliar.der;
            }
        } else {
            Nodo reemplazo = ObtenerRemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (esizquierdo) {
                padre.izq = reemplazo;
            } else {
                padre.der = reemplazo;
            }
            reemplazo.izq = auxiliar.izq;
        }
        return true;
    }

    public Nodo ObtenerRemplazo(Nodo R) {
        Nodo reemplazarPadre = R;
        Nodo reemplazo = R;
        Nodo aux = R.der;
        while (aux != null) {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.izq;
        }
        if (reemplazo != R.der) {
            reemplazarPadre.izq = reemplazo.der;
            reemplazo.der = R.der;
        }

        return reemplazo;

    }

    public void retirar(Nodo q, Nodo p) {
        Nodo r, t, s;

        if (p.izq == null) {
            r = p.der;
        } else if (p.der == null) {
            r = p.izq;
        } else {
            s = p;
            r = p.der;
            t = r.izq;
            while (t != null) {
                s = r;
                r = t;
                t = t.izq;
            }
            if (p != s) {
                s.izq = r.der;
                r.der = p.der;
            }
        }
        if (q == null) {
            raiz = r;
        } else if (p == q.izq) {
            q.izq = r;
        } else {
            q.der = r;
        }
    }

    public int getNivel(int n) {

        for (int i = 1; i < niv.size(); i++) {
            if (n == niv.get(i)) {
                if (n < niv.get(i - 1)) {
                    valor++;
                }

            }

        }
        System.out.println("el valor es " + valor);
        return valor;
    }

    String getniv() {
        for (int i = 0; i < niv.size(); i++) {
            niveles += Integer.toString(niv.get(i)) + " ";
        }
        System.out.println(niveles);
        return niveles;
    }
    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }

}
