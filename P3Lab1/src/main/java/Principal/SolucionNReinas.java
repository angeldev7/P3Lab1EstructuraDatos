package Principal;

public class SolucionNReinas {

    private int N;
    private int[][] tablero;

    public SolucionNReinas(int n) {
        this.N = n;
        this.tablero = new int[N][N];
    }

    public boolean resolverNReinas() {
        return resolverNReinas(tablero, 0);
    }

    private boolean resolverNReinas(int[][] tablero, int col) {
        boolean exito = false;
        if (col >= N) {
            exito = true;
        } else {
            int i = 0;
            while (i < N && !exito) {
                if (esSeguro(tablero, i, col)) {
                    tablero[i][col] = 1;
                    exito = resolverNReinas(tablero, col + 1);
                    if (!exito) {
                        tablero[i][col] = 0; // BACKTRACK
                    }
                }
                i++;
            }
        }
        return exito;
    }

    private boolean esSeguro(int[][] tablero, int fila, int col) {
        boolean esSegura = true;
        int i, j;
        // 1. Verificar la fila hacia la izquierda
        for (i = 0; i < col && esSegura; i++) {
            if (tablero[fila][i] == 1) {
                esSegura = false;
            }
        }
        // 2. Verificar la diagonal superior izquierda
        for (i = fila, j = col; i >= 0 && j >= 0 && esSegura; i--, j--) {
            if (tablero[i][j] == 1) {
                esSegura = false;
            }
        }
        // 3. Verificar la diagonal inferior izquierda
        for (i = fila, j = col; j >= 0 && i < N && esSegura; i++, j--) {
            if (tablero[i][j] == 1) {
                esSegura = false;
            }
        }
        return esSegura;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public static void imprimirSolucion(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(" " + (tablero[i][j] == 1 ? "Q" : ".") + " ");
            }
            System.out.println();
        }
    }
}
