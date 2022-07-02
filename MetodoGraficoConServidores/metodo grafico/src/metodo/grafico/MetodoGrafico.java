
package metodo.grafico;

public class MetodoGrafico {

    public static void main(String[] args) {
        Controlador c = new Controlador(new modelo(), new Vista());
        c.escuchar(c);
    }
    
}
