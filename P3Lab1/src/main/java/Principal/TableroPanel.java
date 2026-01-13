package Principal;

import javax.swing.*;
import java.awt.*;

public class TableroPanel extends JPanel {

    private int[][] tablero;
    private int N;

    public TableroPanel(int[][] tablero) {
        this.tablero = tablero;
        this.N = tablero.length;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tamanoCelda = 50; // Pixeles

        for (int fila = 0; fila < N; fila++) {
            for (int col = 0; col < N; col++) {
                // 1. Dibujar el cuadrado (alternando colores)
                if (((fila + col) % 2 == 0)) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(col * tamanoCelda, fila * tamanoCelda, tamanoCelda, tamanoCelda);

                // 2. Dibujar la Reina si existe en la matriz lógica
                if (tablero[fila][col] == 1) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

                    int x = col * tamanoCelda;
                    int y = fila * tamanoCelda;

                    // Usar el símbolo de reina en Unicode
                    String reina = "\u265B"; // ♛

                    // Ajustar tamaño y color para buen contraste
                    float fontSize = tamanoCelda * 0.8f;
                    g2.setFont(g2.getFont().deriveFont(Font.BOLD, fontSize));
                    // Color: negro en casilla clara, blanco en casilla oscura
                    boolean casillaClara = ((fila + col) % 2 == 0);
                    g2.setColor(casillaClara ? Color.BLACK : Color.WHITE);

                    FontMetrics fm = g2.getFontMetrics();
                    int textWidth = fm.stringWidth(reina);
                    int textAscent = fm.getAscent();
                    int textDescent = fm.getDescent();

                    int drawX = x + (tamanoCelda - textWidth) / 2;
                    int drawY = y + (tamanoCelda + textAscent - textDescent) / 2;

                    g2.drawString(reina, drawX, drawY);
                    g2.dispose();
                }
            }
        }
    }
}
