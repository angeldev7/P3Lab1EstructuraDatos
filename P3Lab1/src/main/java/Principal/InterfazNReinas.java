package Principal;

import javax.swing.*;
import java.awt.*;

public class InterfazNReinas extends JFrame {

    private TableroPanel tableroPanel;
    private int N;

    public InterfazNReinas(int n) {
        this.N = n;
        setTitle("Solución para " + N + " Reinas");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        SolucionNReinas solucion = new SolucionNReinas(N);
        if (solucion.resolverNReinas()) {
            tableroPanel = new TableroPanel(solucion.getTablero());
            add(tableroPanel);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró solución para N = " + N);
        }
    }
}
