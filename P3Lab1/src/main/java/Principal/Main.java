package Principal;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            String nStr = JOptionPane.showInputDialog("Ingrese el tamaño del tablero (N):", "8");
            int n = 8; // Valor por defecto
            try {
                if (nStr != null) {
                    n = Integer.parseInt(nStr);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Usando N=8.", "Error", JOptionPane.ERROR_MESSAGE);
            }

			InterfazNReinas interfaz = new InterfazNReinas(n);
			interfaz.setVisible(true);
		});
	}

}
