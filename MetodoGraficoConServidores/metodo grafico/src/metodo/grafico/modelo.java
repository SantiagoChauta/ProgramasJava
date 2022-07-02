package metodo.grafico;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class modelo {
    
    JTextField varmatriz[][], restriccion[];
    JLabel signo[];
    JButton calcular;
    
    public modelo() {
        calcular = new JButton("Calcular");
       
    }

    public void crearcamposmax(JPanel mip, int numec) {
        int j=0,i;
        varmatriz = new JTextField[numec][2];
        restriccion = new JTextField[numec];
        signo = new JLabel[numec];
        for ( i = 0; i < numec; i++) {
            for (j = 0; j < 2; j++) {
                varmatriz[i][j] = new JTextField();
                varmatriz[i][j].setBounds(30 + (40 * j),140 + (i * 30), 40, 30);
                mip.add(varmatriz[i][j]);

            }
            signo[i] = new JLabel("<=");//pinta el simbolo <=
            signo[i].setBounds(30 + (40 * j) + 50, 140 + (i * 30), 40, 30);
            restriccion[i] = new JTextField();
            restriccion[i].setBounds(30 + (40 * j) + 120, 140 + (i * 30), 40, 30);//pinta la restriccion
            
            mip.add(signo[i]);
            mip.add(restriccion[i]);     
        }
        
        calcular.setBounds(140 + (40 * j) + 120, 150 + (i * 30), 100, 30);
        mip.add(calcular);
    }

    public void crearcamposmin(JPanel mip, int numec) {
int j=0,i;
        varmatriz = new JTextField[numec][2];
        restriccion = new JTextField[numec];
        signo = new JLabel[numec];
        for ( i = 0; i < numec; i++) {
            for (j = 0; j < 2; j++) {
                varmatriz[i][j] = new JTextField();
                varmatriz[i][j].setBounds(30 + (40 * j),140 + (i * 30), 40, 30);
                mip.add(varmatriz[i][j]);

            }
            signo[i] = new JLabel(">=");//pinta el simbolo <=
            signo[i].setBounds(30 + (40 * j) + 50, 140 + (i * 30), 40, 30);
            restriccion[i] = new JTextField();
            restriccion[i].setBounds(30 + (40 * j) + 120, 140 + (i * 30), 40, 30);//pinta la restriccion
            
            mip.add(signo[i]);
            mip.add(restriccion[i]);     
        }
        calcular.setBounds(140 + (40 * j) + 120, 150 + (i * 30), 100, 30);
        mip.add(calcular);
    }
    
}
